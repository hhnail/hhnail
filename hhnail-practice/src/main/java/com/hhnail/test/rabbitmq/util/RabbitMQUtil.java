package com.hhnail.test.rabbitmq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * RabbitMQ 工具类
 */
public class RabbitMQUtil {


    /**
     * 获取信道
     *
     * @return
     * @throws Exception
     */
    public static Channel getChannel() {
        ConnectionFactory factory = new ConnectionFactory();
        // MQ服务地址。这里用的是虚拟机的MQ。端口默认15672
        factory.setHost("192.168.225.130");
        factory.setUsername("admin");
        factory.setPassword("admin");
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            return channel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
