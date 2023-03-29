package com.hhnail.design.pattern.creator.strategy.noifelse.after;

import com.hhnail.design.pattern.creator.strategy.noifelse.bean.Leave;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 请假实现策略：事假
 * @date 2023/1/21 10:50
 */
public class AbsenceLeave implements LeaveAuditStrategy {
    @Override
    public boolean isMatch(Leave leave) {
        return leave.getDays() <= 3 && leave.getType() == 1;
    }

    @Override
    public void audit(Leave leave) {
        System.out.println(leave);
        System.out.println("====三天以下婚丧假，无需审批，自动通过");
    }

    @Override
    public Integer getPriority() {
        return 0;
    }

    @Override
    public String getLeaveMsg() {
        return "三天以下婚丧假，无需审批，自动通过";
    }
}
