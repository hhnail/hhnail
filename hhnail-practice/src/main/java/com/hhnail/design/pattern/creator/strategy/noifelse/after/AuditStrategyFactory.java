package com.hhnail.design.pattern.creator.strategy.noifelse.after;

import com.hhnail.design.pattern.creator.strategy.noifelse.bean.Leave;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 审批策略工厂
 * @date 2023/1/21 10:59
 */
public class AuditStrategyFactory {

    private final static AuditStrategyFactory INSTANCE = new AuditStrategyFactory();

    public static AuditStrategyFactory getInstance() {
        return INSTANCE;
    }

    private List<LeaveAuditStrategy> strategyList = new ArrayList<>();


    private AuditStrategyFactory() {
        // 注册策略。可以考虑取数据库配置、取配置文件配置等，这样就不用改注册的代码了
        strategyList.add(new AbsenceLeave());
        strategyList.add(new AbsenceLeave2());
        strategyList.add(new OneDaySickLeave());
        strategyList.add(new MoreDaySickLeave());
    }

    public LeaveAuditStrategy getLeaveAuditStrategy(Leave leave) {
        LeaveAuditStrategy finalStrategy = null;
        for (LeaveAuditStrategy strategyItem : strategyList) {
            if (strategyItem.isMatch(leave)) {
                if (finalStrategy == null) {
                    finalStrategy = strategyItem;
                } else {
                    if (finalStrategy.getPriority() == strategyItem.getPriority()) {
                        // 优先级冲突
                        throw new RuntimeException("优先级冲突！");
                    } else if (finalStrategy.getPriority() > strategyItem.getPriority()) {
                        // 优先级高的优先
                        finalStrategy = strategyItem;
                    } else {
                        // do something
                    }
                }
            }
        }
        if (finalStrategy == null) {
            throw new RuntimeException("为找到匹配的策略！");
        }
        return finalStrategy;
    }
}
