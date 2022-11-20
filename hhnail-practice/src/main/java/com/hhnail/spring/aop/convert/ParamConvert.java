package com.hhnail.spring.aop.convert;

import com.hhnail.spring.aop.OperateLogDO;

public interface ParamConvert<PARAM> {

    OperateLogDO convert(PARAM param);

}
