package com.hhnail.design.pattern.creator.strategy.noifelse.after;

import com.hhnail.design.pattern.creator.strategy.noifelse.bean.Leave;

public interface LeaveAuditStrategy {

    boolean isMatch(Leave leave);

    void audit(Leave leave);

    Integer getPriority();

    String getLeaveMsg();

}
