package com.hhnail.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2023/2/22 11:20
 */
public class DingDingTest {

    public static void main(String[] args) {
        Map<String, Object> json = new HashMap<>();
        Map<String, Object> text = new HashMap<>();
        json.put("msgtype", "text");
        text.put("content", "鼠鼠我要忙死了捏");
        json.put("text", text);
        send(json);
    }


    /**
     * 发送普通文本消息
     *
     * @param message
     * @return
     */
    public static SendResult send(Map<String, Object> message) {
        RobotClient robot = new RobotClient();
        SendResult sendResult = null;
        try {
            robot.send("https://oapi.dingtalk.com/robot/send" +
                            "?access_token=413d7f0d9c797a517db8eda621eae5e3c01974ce967bc4c0ce4c4a48182bc270",
                    message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendResult;
    }


}


class SendResult {
    private boolean isSuccess;
    private Integer errorCode;
    private String errorMsg;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        Map<String, Object> items = new HashMap<String, Object>();
        items.put("errorCode", errorCode);
        items.put("errorMsg", errorMsg);
        items.put("isSuccess", isSuccess);
        return JSON.toJSONString(items);
    }
}


class RobotClient {


    public void send(String webhook, Map<String, Object> message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode params = objectMapper.createObjectNode();
        params.put("business_type", 1);
        HttpEntity<String> request = new HttpEntity<>(message.toString(), headers);
        ResponseEntity<Map> forEntity = new RestTemplate()
                .postForEntity(webhook, request, Map.class);
        Map body = forEntity.getBody();
        System.out.println(JSONObject.toJSONString(body));
    }
}
