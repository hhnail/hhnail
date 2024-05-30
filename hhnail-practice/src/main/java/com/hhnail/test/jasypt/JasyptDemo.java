package com.hhnail.test.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 221587
 * @version 1.0
 * @description: TODO
 * @date 2024/5/30 9:38
 */
public class JasyptDemo {

    @Autowired
    StringEncryptor encryptor;


    @Test
    public void encryptor() {
        String url = encryptor.encrypt("172.26.1.26");
        String name = encryptor.encrypt("6379");
        String password = encryptor.encrypt("123123");
        System.out.println(url + "----------------");
        System.out.println(name + "----------------");
        System.out.println(password + "----------------");

    }
}
