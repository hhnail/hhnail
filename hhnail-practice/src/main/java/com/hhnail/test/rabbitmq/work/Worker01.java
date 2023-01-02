package com.hhnail.test.rabbitmq.work;

import com.hhnail.test.rabbitmq.util.RabbitMQUtil;
import com.rabbitmq.client.Channel;

public class Worker01 {

    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtil.getChannel();

        System.out.println("queue03 启动！");
        channel.basicConsume(QUEUE_NAME, true,
                (tag, msg) -> {
                    String m = new String(msg.getBody());
                    System.out.println("接受消息：" + m);
                },
                (msg) -> {
                    System.err.println("接受失败：" + msg);
                }
        );


    }
}
