package com.hhnail.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描DAO包
@MapperScan("com.hhnail.web.mapper")
public class HhnailApplication {

    public static void main(String[] args) {
        SpringApplication.run(HhnailApplication.class, args);
    }

}
