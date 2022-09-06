package com.hhnail.design.pattern.structural.chain;

import lombok.Data;
import org.omg.SendingContext.RunTime;

@Data
public class GroupLeader extends Handler {

    private String name = "组长";

    public GroupLeader(Handler leader) {
        super(0, Handler.SHORT_LEAVE, leader);
    }

    @Override
    void handle(LeaveRequest request) {
        if (request.getDay() <= this.maxDay) {
            System.out.println(String.format("%s处理了%s发起的%d天(%s)的请假请求，流程结束",
                    this.name,
                    request.getStaffName(),
                    request.getDay(),
                    request.getContent())
            );
        } else if (this.leader != null) {
            this.leader.handle(request);
        } else {
            System.err.println(String.format("%s处理了%s发起的%d天(%s)的请假请求，审批未通过",
                    this.name,
                    request.getStaffName(),
                    request.getDay(),
                    request.getContent())
            );
        }
    }
}
