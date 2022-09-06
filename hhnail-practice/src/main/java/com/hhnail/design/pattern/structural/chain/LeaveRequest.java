package com.hhnail.design.pattern.structural.chain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeaveRequest {
    private String staffName;
    private Integer day;
    private String content;
}
