package com.hhnail.test;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class BloomFilterTest {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        // 构造Redisson
        RedissonClient redissonClient = Redisson.create(config);
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("bloom"); // bloom对应redis中的key
        // 初始化布隆过滤器。元素1000000个，误判率1%
        bloomFilter.tryInit(1000000L,0.01);
        bloomFilter.add("1");
        System.out.println(bloomFilter.contains("1")); // 1
        System.out.println(bloomFilter.contains("666")); // 666
    }
}
