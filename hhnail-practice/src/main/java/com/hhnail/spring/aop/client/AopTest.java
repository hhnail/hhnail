package com.hhnail.spring.aop.client;

import com.hhnail.spring.aop.OrderService;
import com.hhnail.spring.aop.SaveOrderReqVO;
import com.hhnail.spring.aop.UpdateOrderReqVO;

/**
 * @author r221587
 * @version 1.0
 * @description: AOP日志处理实践
 * @date 2022/11/18 16:59
 */
public class AopTest {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        orderService.saveOrder(new SaveOrderReqVO(1L));
        orderService.updateOrder(new UpdateOrderReqVO(2L));



    }

}
