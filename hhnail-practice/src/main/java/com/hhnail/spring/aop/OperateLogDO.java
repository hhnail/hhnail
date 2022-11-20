package com.hhnail.spring.aop;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OperateLogDO {

    private Long orderId;

    private String desc;

    private String result;
}
