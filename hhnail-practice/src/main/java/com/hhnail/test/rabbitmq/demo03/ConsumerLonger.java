package com.hhnail.test.rabbitmq.demo03;

import com.hhnail.test.rabbitmq.util.RabbitMQUtil;
import com.rabbitmq.client.*;

/**
 * 消息手动应答
 * 消费者
 */
public class ConsumerLonger {

    public static final String QUEUE_NAME = "ack_message";

    public static void main(String[] args) throws Exception {


        Channel channel = RabbitMQUtil.getChannel();

        boolean autoAsk = false;
        channel.basicConsume(
                QUEUE_NAME, // 队列名
                autoAsk, // 是否自动应答
                // 成功的回调
                (consumerTag, message) -> {
                    byte[] body = message.getBody();
                    try {
                        Thread.sleep(30 * 1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
