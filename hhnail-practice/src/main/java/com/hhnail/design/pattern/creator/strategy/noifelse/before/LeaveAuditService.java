package com.hhnail.design.pattern.creator.strategy.noifelse.before;

import com.hhnail.design.pattern.creator.strategy.noifelse.bean.Leave;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 请假审批流程 使用策略模式前
 * @date 2023/1/21 10:37
 */
public class LeaveAuditService {

    public void audit(Leave leave) {
        if (leave.getDays() <= 3 && leave.getType() == 1) {
            System.out.println("三天以下婚丧假，无需审批，自动通过");
        }
        if (leave.getDays() > 3 && leave.getType() == 1) {
            System.out.println("三天以上婚丧假，进入审批流程");
        }
        if (leave.getEmployee().getLevel() == 9) {
            System.out.println("总经理请假，无需审批，自动通过");
        }
        if (leave.getDays() == 1 && leave.getType() == 0) {
            System.out.println("一天病假，无需审批，自动通过");
        }
        if (leave.getDays() > 1 && leave.getType() == 0) {
            System.out.println("一天以上病假，进入审批流程");
        }

    }


}
