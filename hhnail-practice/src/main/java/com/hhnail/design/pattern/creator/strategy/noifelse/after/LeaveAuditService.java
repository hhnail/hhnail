package com.hhnail.design.pattern.creator.strategy.noifelse.after;

import com.hhnail.design.pattern.creator.strategy.noifelse.bean.Employee;
import com.hhnail.design.pattern.creator.strategy.noifelse.bean.Leave;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 调用审批流程的服务
 * @date 2023/1/21 11:10
 */
public class LeaveAuditService {

    // 测试用例
    public static void main(String[] args) {
        LeaveAuditService leaveAuditService = new LeaveAuditService();
        leaveAuditService.audit(new Leave(3, 1, new Employee(1L, "张三", 100)));
        leaveAuditService.audit(new Leave(1, 0, new Employee(2L, "李四", 100)));
    }

    public void audit(Leave leave) {
        // 以后加新的流程这里就不用改了
        AuditStrategyFactory factory = AuditStrategyFactory.getInstance();
        LeaveAuditStrategy strategy = factory.getLeaveAuditStrategy(leave);
        System.out.println("匹配到规则" + strategy.getLeaveMsg() + "(" + strategy.getClass().getName() + ")");
        strategy.audit(leave);
    }

}
