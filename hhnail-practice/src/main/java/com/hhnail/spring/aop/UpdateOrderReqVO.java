package com.hhnail.spring.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author r221587
 * @version 1.0
 * @description: 更新订单请求VO
 * @date 2022/11/18 16:57
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderReqVO {

    private Long orderId;
}
