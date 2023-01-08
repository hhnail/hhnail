package com.hhnail.test.rabbitmq.demo06;

import com.hhnail.test.rabbitmq.util.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

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

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtil.getChannel();
        channel.queueDeclare(QUEUE_NAME,
                false, false, false,
                null
        );
        // 开启发布确认
        channel.confirmSelect();

        // 线程安全有序的一个map，支持高并发（多线程）
        ConcurrentSkipListMap<Long, String> outstandingConfirm = new ConcurrentSkipListMap<>();

        // 添加确认发布的监听器。
        // 这样发布就不用确认了，监听发布的结果，不同情况做不同处理，起到”异步确认“的效果
        channel.addConfirmListener(
                (deliveryTag, multiple) -> {
                    /**
                     * 成功的处理
                     * 2.删除掉已经确认的消息。剩下的就是未确认的消息
                     */
                    if (multiple) { // 如果是批量确认
                        // 保留key小于deliveryTag的。tailMap()是保留key大于deliveryTag的
                        ConcurrentNavigableMap<Long, String> confirmed = outstandingConfirm.headMap(deliveryTag);
                        confirmed.clear(); // 执行这个confirmed会清空，outstandingConfirm的元素也才会移除
                    } else {
                        outstandingConfirm.remove(deliveryTag);
                    }
                    System.out.println("确认的消息：" + deliveryTag);
                },
                (deliveryTag, multiple) -> {
                    // 失败的处理
                    // 3.打印一下未确认的消息都有哪些
                    String unconfirmedMsg = outstandingConfirm.get(deliveryTag);
                    System.out.println("未确认的消息：" + unconfirmedMsg);
                });

        long start = System.currentTimeMillis();
        for (Integer i = 0; i < MESSAGE_COUNT; i++) {
            String message = "消息" + i;
            channel.basicPublish(
                    "",
                    QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes(StandardCharsets.UTF_8)
            );
            // 1.此处记录下所有要发送的消息  消息的总和
            outstandingConfirm.put(channel.getNextPublishSeqNo(), message);
        }
        long end = System.currentTimeMillis();
        System.out.println("单个确认发布耗时：" + (end - start));


    }
}
