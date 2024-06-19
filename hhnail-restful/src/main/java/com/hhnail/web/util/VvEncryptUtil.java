package com.hhnail.web.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;


public class VvEncryptUtil {

    public static void main(String[] args) throws Exception{
        // String inputString = "123";
        // String sha256Hash = getSha256(inputString);
        // System.out.println("SHA-256 Hash of \"" + inputString + "\": " + sha256Hash);
        //
        // byte[] decodedBytes = Base64.getDecoder().decode("userpoolv");
        //
        // String decodedText = new String(decodedBytes, StandardCharsets.UTF_8);






        // String plainText = "this is message";
        //
        // // 假设已经通过generateAESKey()生成了keySpec和一个合适的ivSpec
        // SecretKeySpec keySpec = generateAESKey(); // 使用之前定义的generateAESKey函数
        // IvParameterSpec ivSpec = new IvParameterSpec(new byte[16]); // 初始化向量，通常需要随机生成并安全保存，这里仅作为示例
        //
        // String cipherText = encrypt(plainText, keySpec, ivSpec);
        // System.out.println("Encrypted: " + cipherText);
        //
        // String decryptedText = decrypt(cipherText, keySpec, ivSpec);
        // System.out.println("Decrypted: " + decryptedText)
        //
        // ;


        // String userpoolv = encode("12312414");
        // System.out.println(userpoolv);
        // String decode = decode(userpoolv);
        // System.out.println(decode);


        String cKey = UUID.randomUUID().toString().substring(0, 16);
        System.out.println(cKey);
        // 需要加密的字串
        String cSrc = "test.888888";
        System.out.println(cSrc);
        // 加密
        String enString = VvEncryptUtil.aes16Encrypt(cSrc, cKey);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String DeString = VvEncryptUtil.aes16Decrypt(enString, cKey);
        System.out.println("解密后的字串是：" + DeString);


        System.out.println("============== 华丽的分割线 ============");
        // jdbc:mysql://IP或地址:端口号/数据库名称?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true
        // jdbc:mysql://rm-bp1o04tfh4e8r6o5l.mysql.rds.aliyuncs.com:3306/quickaudience?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true
        // System.out.println("cdp_qa_app");
        // System.out.println("cvdBgsn&IFO0duUx");

        System.out.println(VvEncryptUtil.aes16Encrypt("jdbc:mysql://172.18.11.91:30234/jhdb" +
                "?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai"
                , cKey)
        );
        System.out.println(VvEncryptUtil.aes16Encrypt("user_app", cKey));
        System.out.println(VvEncryptUtil.aes16Encrypt("x_duRgoeheJ9jOQZ", cKey));



    }

    /**
     * Calculates the SHA-256 hash of a given string and returns it as a hexadecimal string.
     *
     * @param input The string to be hashed.
     * @return The SHA-256 hash of the input string as a hexadecimal string.
     */
    public static String getSha256(String input) {
        try {
            // Step 2: Create a MessageDigest instance for SHA-256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Step 3: Update the MessageDigest with the input string's bytes
            byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
            messageDigest.update(inputBytes);

            // Step 4: Compute the SHA-256 hash
            byte[] hashBytes = messageDigest.digest();

            // Step 5: Convert the hash bytes to a hexadecimal string
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to initialize SHA-256 MessageDigest", e);
        }
    }

    /**
     * Converts a byte array to a hexadecimal string representation.
     *
     * @param bytes The byte array to convert.
     * @return A hexadecimal string representation of the input bytes.
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


    public static String encrypt(String plainText, SecretKeySpec keySpec, IvParameterSpec ivSpec) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // 使用CBC模式和PKCS5Padding
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec); // 初始化为加密模式

            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes); // 返回Base64编码的密文
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String cipherText, SecretKeySpec keySpec, IvParameterSpec ivSpec) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec); // 初始化为解密模式

            byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8); // 返回解密后的原文
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static SecretKeySpec generateAESKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // 初始化为128位密钥长度
            SecretKey secretKey = keyGen.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(), "AES");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对字符串进行Base64编码。
     *
     * @param input 需要编码的原始字符串。
     * @return Base64编码后的字符串。
     */
    public static String encode(String input) {
        if (input == null) {
            return null;
        }
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 对Base64编码的字符串进行解码。
     *
     * @param encodedString 需要解码的Base64字符串。
     * @return 解码后的原始字符串。
     */
    public static String decode(String encodedString) {
        if (encodedString == null) {
            return null;
        }
        byte[] bytes = Base64.getDecoder().decode(encodedString);
        return new String(bytes, StandardCharsets.UTF_8);
    }


    /**
     * 加密
     * @param sSrc 需要加密的字符串
     * @param sKey 此处使用AES-128-ECB加密模式，key需要为16位。
     * @return
     * @throws Exception
     */
    public static String aes16Encrypt(String sSrc, String sKey){

        try {
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

            return Base64.getEncoder().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 解密
     * @param sSrc 需要解密的字符串
     * @param sKey 此处使用AES-128-ECB加密模式，key需要为16位。
     * @return
     * @throws Exception
     */
    public static String aes16Decrypt(String sSrc, String sKey) {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = Base64.getDecoder().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            // System.out.println(ex.toString());
            ex.printStackTrace();
            return null;
        }
    }

}