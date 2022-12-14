package com.hhnail.test.rabbitmq.demo05;

import com.hhnail.test.rabbitmq.util.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


/**
 * @author Hhnail
 * @version 1.0
 * @description: 批量确认发布
 * 生产者
 * @date 2023/1/7 19:16
 */
public class Producer {

    public static final String QUEUE_NAME = "queueName";

    public static final Integer MESSAGE_COUNT = 100;
    public static final Integer BATCH_CONFIRM = 100;

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtil.getChannel();
        channel.queueDeclare(QUEUE_NAME,
                true, false, false,
                null
        );
        // 开启发布确认
        channel.confirmSelect();
        long start = System.currentTimeMillis();
        for (Integer i = 0; i < MESSAGE_COUNT; i++) {
            String message = "消息" + i;
            {
                channel.basicPublish("",
                        QUEUE_NAME,
                        MessageProperties.PERSISTENT_TEXT_PLAIN,
                        message.getBytes(StandardCharsets.UTF_8)
                );
                if (i % BATCH_CONFIRM == 0) {
                    boolean success = channel.waitForConfirms();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("单个确认发布耗时：" + (end - start));


    }

}
