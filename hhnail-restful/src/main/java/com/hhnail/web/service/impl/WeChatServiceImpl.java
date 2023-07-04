package com.hhnail.web.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hhnail.web.bean.WeChatFollower;
import com.hhnail.web.mapper.WeChatMapper;
import com.hhnail.web.service.IWeChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WeChatServiceImpl implements IWeChatService {

    @Autowired
    WeChatMapper weChatMapper;

    private String getAccessToken(Object appid, Object secret) {
        String url = "https://api.weixin.qq.com/cgi-bin/token" +
                "?grant_type=client_credential" +
                "&appid=" + appid +
                "&secret=" + secret;
        String reqResult = HttpUtil.get(url);
        JSONObject result = JSONObject.parseObject(reqResult);
        return result.get("access_token").toString();
    }

    public static void main(String[] args) {
        Map<String, Object> reqVO = new HashMap<>();
        reqVO.put("appid", "wx38d4c0dc2306855c");
        reqVO.put("secret", "c5a41924a043311bdd518aafb0ec35b3");
        List<WeChatFollower> weChatFollowerList = new WeChatServiceImpl().getWeChatFollowerList(reqVO);
        System.out.println(JSONObject.toJSONString(weChatFollowerList));
    }

    @Override
    public List<WeChatFollower> getWeChatFollowerList(Map<String, Object> reqVO) {
        List<WeChatFollower> weChatFollowerList = new ArrayList<>();

        String openidListUrl = "https://api.weixin.qq.com/cgi-bin/user/get" +
                "?access_token=" + getAccessToken(reqVO.get("appid"), reqVO.get("secret"));
        String reqResult = HttpUtil.get(openidListUrl);
        JSONObject result = JSONObject.parseObject(reqResult);
        JSONArray jsonArray = result.getJSONObject("data").getJSONArray("openid");
        for (Object openid : jsonArray) {
            String userInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info" +
                    "?access_token=" + getAccessToken(reqVO.get("appid"), reqVO.get("secret")) +
                    "&openid=" + openid +
                    "&lang=zh_CN";
            reqResult = HttpUtil.get(userInfoUrl);
            WeChatFollower weChatFollower = JSONObject.parseObject(reqResult, WeChatFollower.class);
            System.out.println("current:" + weChatFollower);
            weChatFollowerList.add(weChatFollower);
        }
        return weChatFollowerList;
    }

    @Override
    public List<WeChatFollower> saveWeChatFollowerList(Map<String, Object> reqVO) {
        List<WeChatFollower> weChatFollowerList = new ArrayList<>();

        String openidListUrl = "https://api.weixin.qq.com/cgi-bin/user/get" +
                "?access_token=" + getAccessToken(reqVO.get("appid"), reqVO.get("secret"));
        String reqResult = HttpUtil.get(openidListUrl);
        JSONObject result = JSONObject.parseObject(reqResult);
        JSONArray jsonArray = result.getJSONObject("data").getJSONArray("openid");
        for (Object openid : jsonArray) {
            String userInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info" +
                    "?access_token=" + getAccessToken(reqVO.get("appid"), reqVO.get("secret")) +
                    "&openid=" + openid +
                    "&lang=zh_CN";
            reqResult = HttpUtil.get(userInfoUrl);
            WeChatFollower weChatFollower = JSONObject.parseObject(reqResult, WeChatFollower.class);
            weChatFollower.setTagIdListStr(weChatFollower.getTagIdList().stream().collect(Collectors.joining(",")));
            System.out.println("current:" + weChatFollower);
            weChatMapper.insert(weChatFollower);
            weChatFollowerList.add(weChatFollower);
        }
        return weChatFollowerList;
    }
}