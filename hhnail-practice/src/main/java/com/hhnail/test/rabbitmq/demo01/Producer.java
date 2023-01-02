package com.hhnail.test.rabbitmq.demo01;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

/**
 * mq
 * 简单模式
 * 生产者代码
 */
public class Producer {

    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        // MQ服务地址。这里用的是虚拟机的MQ。端口默认15672
        factory.setHost("192.168.225.130");
        factory.setUsername("admin");
        factory.setPassword("admin");
        // 获取连接
        Connection connection = factory.newConnection();
        // 创建信道
        Channel channel = connection.createChannel();
        // 创建队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "hello world 123";

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));


    }


}
