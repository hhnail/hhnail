package com.hhnail.design.pattern.structural.chain;

/**
 * 抽象
 * 请求处理者
 */
public abstract class Handler {
    protected static final Integer SHORT_LEAVE = 1;
    protected static final Integer MIDDLE_LEAVE = 3;
    protected static final Integer LONG_LEAVE = 7;

    protected Integer minDay;
    protected Integer maxDay;
    protected Handler leader;

    public Handler(Integer minDay, Integer maxDay,Handler leader) {
        this.minDay = minDay;
        this.maxDay = maxDay;
        this.leader = leader;
    }

    abstract void handle(LeaveRequest request);
}
