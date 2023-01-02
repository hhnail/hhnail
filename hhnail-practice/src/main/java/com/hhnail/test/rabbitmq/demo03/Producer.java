package com.hhnail.test.rabbitmq.demo03;

import com.hhnail.test.rabbitmq.util.RabbitMQUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


/**
 * 消息手动应答
 */
public class Producer {

    public static final String QUEUE_NAME = "ack_message";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMQUtil.getChannel();
        channel.queueDeclare(QUEUE_NAME,
                false, false, false,
                null
        );

        Scanner input = new Scanner(System.in);
        System.out.print("请输入要发送的消息：");
        while (input.hasNext()) {
            String msg = input.next();
            channel.basicPublish(
                    "",
                    QUEUE_NAME,
                    null,
                    msg.getBytes(StandardCharsets.UTF_8)
            );
            System.out.println("发送完成：" + msg+"。可继续输入..");
        }

    }

}
