package com.hhnail.design.pattern.creator.strategy.noifelse.after;

import com.hhnail.design.pattern.creator.strategy.noifelse.bean.Leave;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 请假实现类：多天病假
 * @date 2023/1/21 10:56
 */
public class MoreDaySickLeave implements LeaveAuditStrategy {

    @Override
    public boolean isMatch(Leave leave) {
        return leave.getDays() > 1 && leave.getType() == 0;
    }

    @Override
    public void audit(Leave leave) {
        System.out.println(leave);
        System.out.println("一天以上病假，进入审批流程");
    }

    @Override
    public Integer getPriority() {
        return 0;
    }

    @Override
    public String getLeaveMsg() {
        return "一天以上病假，进入审批流程";
    }
}
