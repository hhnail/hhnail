package com.hhnail.test.rabbitmq.demo08;

import com.hhnail.test.rabbitmq.util.RabbitMQUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;

/**
 * @author Hhnail
 * @version 1.0
 * @description: fanout 扇出（广播，一人发送，多人接收）
 * @date 2023/1/15 11:13
 */
public class ReceiveLog01 {

    // 交换机名称
    public static final String EXCHANGE_NAME = "log";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtil.getChannel();
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        // 生成临时队列
        String queueName = channel.queueDeclare().getQueue();

        // 绑定交换机和队列
        channel.queueBind(queueName, EXCHANGE_NAME, "routingKey");

        channel.basicConsume(
                queueName,
                true,
                (consumerTag, message) -> {
                    String msg = new String(message.getBody(), "UTF-8");
                    System.out.println("ReceiveLog01接收到的消息：" + msg);
                },
                consumerTag -> System.out.println("处理失败")
        );

    }
}
