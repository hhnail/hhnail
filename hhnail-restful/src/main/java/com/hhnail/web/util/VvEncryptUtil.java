package com.hhnail.web.util;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 加密工具类
 * @date 2023/10/15 17:37
 */
public class VvEncryptUtil {

    /**
     * sha1加密
     *
     * @param str
     * @return
     */
    public static String sha1(String str) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
