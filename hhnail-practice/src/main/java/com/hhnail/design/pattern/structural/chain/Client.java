package com.hhnail.design.pattern.structural.chain;

public class Client {
    public static void main(String[] args) {
        // 配置责任链
        CompanyLeader companyLeader = new CompanyLeader(null);
        DepartmentLeader departmentLeader = new DepartmentLeader(companyLeader);
        GroupLeader groupLeader = new GroupLeader(departmentLeader);

        // 生成请假请求
        LeaveRequest leaveRequest = new LeaveRequest("张三",5,"嫖娼被抓");
        LeaveRequest leaveRequest2 = new LeaveRequest("李四",8,"世界那么大，我想去看看");
        LeaveRequest leaveRequest3 = new LeaveRequest("王五",1,"肚子疼");
        LeaveRequest leaveRequest4 = new LeaveRequest("王五",3,"回家看看");
        // 处理请假请求
        groupLeader.handle(leaveRequest);
        groupLeader.handle(leaveRequest2);
        groupLeader.handle(leaveRequest3);
        groupLeader.handle(leaveRequest4);
    }
}
