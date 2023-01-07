package com.hhnail.test.rabbitmq.demo07;

import com.hhnail.test.rabbitmq.util.RabbitMQUtil;
import com.rabbitmq.client.Channel;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 消费者
 * 不公平分发、预取值
 * @date 2023/1/7 19:28
 */
public class Consumer {


    public static final String QUEUE_NAME = "ack_message";

    public static void main(String[] args) throws Exception {

        Channel channel = RabbitMQUtil.getChannel();

        { // TODO 核心代码
            int prefetchCount = 1; // 不公平分发
            // int prefetchCount = 5; // 预取值
            channel.basicQos(prefetchCount);
        }
        boolean autoAsk = false;
        channel.basicConsume(
                QUEUE_NAME, // 队列名
                autoAsk, // 是否自动应答
                // 成功的回调
                (consumerTag, message) -> {
                    byte[] body = message.getBody();
                    System.out.println("消费成功");
                    System.out.println(new String(body));
                    // 手动应答
                    channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
                },
                // 失败时的回调
                consumerTag -> System.out.println("消费失败：" + consumerTag)
        );

    }
}
