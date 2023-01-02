package com.hhnail.test.rabbitmq.demo01;

import com.rabbitmq.client.*;

/**
 * mq
 * 简单模式
 * 消费者代码
 */
public class Consumer {

    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        // MQ服务地址。这里用的是虚拟机的MQ。端口默认15672
        factory.setHost("192.168.225.130");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.basicConsume(
                QUEUE_NAME, // 队列名
                true, // 是否自动应答
                // 成功的回调
                (consumerTag, message) -> {
                    byte[] body = message.getBody();
                    System.out.println("消费成功");
                    System.out.println(new String(body));
                },
                // 失败时的回调
                consumerTag -> System.out.println("消费失败：" + consumerTag)
        );


    }
}
