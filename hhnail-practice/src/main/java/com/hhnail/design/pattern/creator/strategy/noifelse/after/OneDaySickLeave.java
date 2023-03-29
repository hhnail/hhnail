package com.hhnail.design.pattern.creator.strategy.noifelse.after;

import com.hhnail.design.pattern.creator.strategy.noifelse.bean.Leave;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 请假实现类：一天病假
 * @date 2023/1/21 10:55
 */
public class OneDaySickLeave implements LeaveAuditStrategy {
    @Override
    public boolean isMatch(Leave leave) {
        return leave.getDays() == 1 && leave.getType() == 0;
    }

    @Override
    public void audit(Leave leave) {
        System.out.println(leave);
        System.out.println("一天病假，无需审批，自动通过");
    }

    @Override
    public Integer getPriority() {
        return 0;
    }

    @Override
    public String getLeaveMsg() {
        return "一天病假，无需审批，自动通过";
    }
}
