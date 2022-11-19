package com.hhnail.spring.aop;

/**
 * @author r221587
 * @version 1.0
 * @description: AOP日志处理实践
 * @date 2022/11/18 16:54
 */
public class OrderService {


    public void saveOrder(SaveOrderReqVO reqVO) {
        System.out.println("save order,orderId:" + reqVO.getId());
    }

    public void updateOrder(UpdateOrderReqVO reqVO) {
        System.out.println("update order,orderId:" + reqVO.getOrderId());
    }


}
