package com.hhnail.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author ChatGPT
 * @version 1.0
 * @description: TODO
 * @date 2023/5/3 14:19
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {


    private static final String LOCK_KEY = "lock_key";

    private static final int LOCK_EXPIRE_TIME = 5000;

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    StringEncryptor encryptor;


    /**
     * 释放锁
     *
     * @param requestId
     * @return
     */
    @GetMapping("/hello")
    public String hello(String requestId) {
        return "hello world!";
    }


    /**
     * 加锁
     *
     * @param requestId
     * @return
     */
    public boolean acquireDistributedLock(String requestId) {
        Boolean success = redisTemplate.opsForValue().setIfAbsent(
                LOCK_KEY, requestId, LOCK_EXPIRE_TIME, TimeUnit.MILLISECONDS
        );
        return success;

    }

    /**
     * 释放锁
     *
     * @param requestId
     * @return
     */
    public boolean releaseDistributedLock(String requestId) {
        Object lockValue = redisTemplate.opsForValue().get(LOCK_KEY);
        if (requestId.equals(lockValue)) {
            redisTemplate.delete(LOCK_KEY);
            return true;
        }
        return false;
    }



    @PostMapping("/jasypt")
    public void encryptor() {
        String url = encryptor.encrypt("172.26.1.26");
        String name = encryptor.encrypt("6379");
        String password = encryptor.encrypt("123123");
        System.out.println(url + "----------------");
        System.out.println(name + "----------------");
        System.out.println(password + "----------------");
    }
}
