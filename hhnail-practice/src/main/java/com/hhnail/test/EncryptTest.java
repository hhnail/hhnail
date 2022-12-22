package com.hhnail.test;

import cn.hutool.crypto.digest.DigestUtil;
import org.junit.Test;

/**
 * @author r221587
 * @version 1.0
 * @description: 测试加密
 * @date 2022/12/15 9:37
 */
public class EncryptTest {


    @Test
    public void test01(){
        System.out.println(DigestUtil.sha1("7ba1eab3ed7b5e8elb"));
    }

    @Test
    public void test02(){
        // String time = "2022-12-12 14:22:22";
        // String ehrNo = "221587";
        // String myToken = DigestUtil.md5Hex(time + "|huanke|" + ehrNo + "|qyreqorqor");
        // System.out.println(myToken); // 0fa764dba0d698df20d221ad77d201dd

        String time = "2022-12-12 14:22:22";
        String ehrNo = "schedule";
        String myToken = DigestUtil.md5Hex(time + "|huanke|" + ehrNo + "|qyreqorqor");
        System.out.println(myToken); // a1334dff4882477d0f4c0648abb41718
    }

    @Test
    public void test03(){
        System.out.println(DigestUtil.sha1("7ba1eab3ed7b5e8elb"));
    }

}
