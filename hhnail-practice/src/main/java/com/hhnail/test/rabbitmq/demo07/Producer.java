package com.hhnail.test.rabbitmq.demo07;

import com.hhnail.test.rabbitmq.util.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 生产者
 * 异步确认发布
 * @date 2023/1/7 19:28
 */
public class Producer {

    public static final String QUEUE_NAME = "queueName";

    public static final Integer MESSAGE_COUNT = 100;
    public static final Integer BATCH_CONFIRM = 100;

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtil.getChannel();
        channel.queueDeclare(QUEUE_NAME,
                false, false, false,
                null
        );

        // 添加确认发布的监听器。
        // 这样发布就不用确认了，监听发布的结果，不同情况做不同处理，起到”异步确认“的效果
        channel.addConfirmListener(
                (deliveryTag, multiple) -> {
                    // 成功的处理
                    System.out.println("发布成功");
                },
                (deliveryTag, multiple) -> {
                    // 失败的处理
                    System.out.println("发布失败");
                });

        long start = System.currentTimeMillis();
        for (Integer i = 0; i < MESSAGE_COUNT; i++) {
            String message = "消息" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
        }
        long end = System.currentTimeMillis();
        System.out.println("单个确认发布耗时：" + (end - start));


    }
}
