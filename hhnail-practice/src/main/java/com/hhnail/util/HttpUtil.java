package com.hhnail.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * 请求工具
 */
public class HttpUtil {


    /**
     * @param url    地址
     * @param params 请求参数
     * @return
     * @throws Exception
     */
    public static String doPost(String url, String params) throws Exception {
        return doPost(url, null, params, 60000, 30000);
    }


    /**
     * @param url     地址
     * @param headers 请求头
     * @param params  请求参数
     * @return
     * @throws Exception
     */
    public static String doPost(String url, Map<String, Object> headers, String params) throws Exception {
        return doPost(url, headers, params, 60000, 30000);
    }


    /**
     * @param url
     * @param params
     * @param connTimeout
     * @param readTimeout
     * @return
     * @throws Exception
     */
    public static String doPost(String url, Map<String, Object> headers, String params, int connTimeout, int readTimeout) throws Exception {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("content-type", "application/json");
            for (Map.Entry<String, Object> entry : headers.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue().toString());
            }

            // 设置超时时间
            conn.setConnectTimeout(connTimeout);
            conn.setReadTimeout(readTimeout);

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(
                    new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            // 发送请求参数
            out.print(params);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


}
