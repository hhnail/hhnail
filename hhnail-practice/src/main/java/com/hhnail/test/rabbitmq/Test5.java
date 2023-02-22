package com.hhnail.test.rabbitmq;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2023/2/22 15:39
 */
public class Test5 {

    public static void main(String[] args) throws Exception {
        Long timestamp = System.currentTimeMillis();
        String secret = "SECf4c7ddfc5e256ae5c113b535f41af0410d162827d789c8cf27279e7a3fee21f8";
        System.out.println(timestamp);

        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.getMimeEncoder().encode(signData)), "UTF-8");
        System.out.println(sign);
    }
}
