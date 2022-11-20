package com.hhnail.spring.aop.convert.impl;

import com.hhnail.spring.aop.OperateLogDO;
import com.hhnail.spring.aop.UpdateOrderReqVO;
import com.hhnail.spring.aop.convert.ParamConvert;

public class UpdateOrderParamConvert implements ParamConvert<UpdateOrderReqVO> {

    @Override
    public OperateLogDO convert(UpdateOrderReqVO updateOrderReqVO) {
        OperateLogDO logDO = new OperateLogDO();
        logDO.setOrderId(updateOrderReqVO.getOrderId());
        return logDO;
    }

}
