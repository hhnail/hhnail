package com.hhnail.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描DAO包
@MapperScan("com.hhnail.pkg.mapper")
public class MptestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MptestApplication.class, args);
    }

}
