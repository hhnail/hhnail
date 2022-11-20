package com.hhnail.spring.aop;

import com.hhnail.spring.aop.anno.RecordOperate;
import com.hhnail.spring.aop.convert.impl.SaveOrderParamConvert;
import com.hhnail.spring.aop.convert.impl.UpdateOrderParamConvert;

/**
 * @author r221587
 * @version 1.0
 * @description: AOP日志处理实践
 * @date 2022/11/18 16:54
 */
public class OrderService {


    @RecordOperate(desc = "保存订单", convert = SaveOrderParamConvert.class)
    public void saveOrder(SaveOrderReqVO reqVO) {
        System.out.println("save order,orderId:" + reqVO.getId());
    }

    @RecordOperate(desc = "更新订单", convert = UpdateOrderParamConvert.class)
    public void updateOrder(UpdateOrderReqVO reqVO) {
        System.out.println("update order,orderId:" + reqVO.getOrderId());
    }


}
