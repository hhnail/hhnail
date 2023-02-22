package com.hhnail.test;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author zxq
 * @description 钉钉推送服务类
 * @date 2020/11/26
 */
@Slf4j
public class DingDingTest2 {

    //文本消息
    private static final String TEXT = "text";
    private static final String LINK = "link";
    private static final String MARKDOWN = "markdown";
    private static final String ACTION_CARD = "actionCard";
    private static final String FEED_CARD = "feedCard";

    /**
     * @param in
     * @description: 推送消息
     * @return: void
     * @author: zxq
     * @Date: 2020/11/26 13:28
     */
    public static void sendMessage(SendMessageIn in) throws Exception {

        log.info("开始推送钉钉消息：" + in);
        Long timestamp = System.currentTimeMillis();
        String secret = in.getSecret();

        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.getMimeDecoder().decode(signData)), "UTF-8");
        DingTalkClient client = new DefaultDingTalkClient(in.getWebhook() + "&timestamp=" + timestamp + "&sign=" + sign);
        OapiRobotSendRequest request = new OapiRobotSendRequest();

        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        if (in.isAtAll() || in.getMobileList() == null || in.getMobileList().size() == 0) {
            //推送所有人
            at.setIsAtAll(true);
        } else {
            //推送指定用户
            at.setAtMobiles(in.getMobileList());
            at.setIsAtAll(false);
        }
        request.setAt(at);

        //文本消息
        if (TEXT.equals(in.getMsgType())) {
            request.setMsgtype(TEXT);
            OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
            text.setContent(in.getText());
            request.setText(text);
        }

        OapiRobotSendResponse response = client.execute(request);
        log.info("钉钉推送返回结果：" + response);

    }

    public static void main(String[] args) throws Exception {

        List<String> mobileList = new ArrayList<>();
        mobileList.add("18030290509");

        SendMessageIn in = new SendMessageIn();
        in.setMsgType(TEXT);
        in.setAtAll(false);
        in.setMobileList(mobileList);
        in.setWebhook("https://oapi.dingtalk.com/robot/send" +
                "?access_token=413d7f0d9c797a517db8eda621eae5e3c01974ce967bc4c0ce4c4a48182bc270");
        in.setSecret("my_secret");
        in.setText("桃花坞里桃花庵，桃花庵下桃花仙");

        sendMessage(in);

    }

}

