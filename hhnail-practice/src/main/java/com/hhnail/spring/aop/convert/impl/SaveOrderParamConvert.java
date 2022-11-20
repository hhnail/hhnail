package com.hhnail.spring.aop.convert.impl;

import com.hhnail.spring.aop.OperateLogDO;
import com.hhnail.spring.aop.SaveOrderReqVO;
import com.hhnail.spring.aop.convert.ParamConvert;

public class SaveOrderParamConvert implements ParamConvert<SaveOrderReqVO> {


    @Override
    public OperateLogDO convert(SaveOrderReqVO saveOrderReqVO) {
        OperateLogDO logDO = new OperateLogDO();
        logDO.setOrderId(saveOrderReqVO.getId());
        return logDO;
    }
}
