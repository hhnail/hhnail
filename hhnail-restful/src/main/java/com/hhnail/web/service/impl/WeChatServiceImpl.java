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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static javax.swing.UIManager.put;

@Service
@Slf4j
public class WeChatServiceImpl implements IWeChatService {

    // 创建线程池并设置参数
    private int corePoolSize = 10;
    private int maxPoolSize = 30;
    private long keepAliveTime = 5000;
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    private BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workQueue);

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
        boolean flag = true;
        final JSONArray jsonArray = new JSONArray();
        String next_openid = null;
        // String next_openid = "o1sGt1Z0A-SqnnaYQjnIxyuhVb-g";
        while (flag) {
            String accessToken = getAccessToken(reqVO.get("appid"), reqVO.get("secret"));
            // String accessToken = "70_RJzKwEmFTxq1z_1kS_xVE_A2qCh1Hi0zlyfnSwso4jr8qHbn1YnpkqmDfpeuSFyb3sCv2CPut_1ocXbqZgwXoE6lAqcFnUIgPbJvPrgGJ-CiN6lJVbD4GqBeasAVHAbAIAEQJ";
            String openidListUrl = "https://api.weixin.qq.com/cgi-bin/user/get" +
                    "?access_token=" + accessToken +
                    (next_openid == null ? "" : ("&next_openid=" + next_openid));
            String reqResult = HttpUtil.get(openidListUrl);
            JSONObject result = JSONObject.parseObject(reqResult);
            JSONArray openidArr = result.getJSONObject("data").getJSONArray("openid");
            next_openid = openidArr.get(openidArr.size() - 1).toString();

            if (openidArr.size() < 10000) {
                flag = false;
            }

            jsonArray.clear();
            jsonArray.addAll(openidArr);
            threadPoolExecutor.execute(() -> {
                // 执行相同任务
                try {
                    JSONArray arr = jsonArray;
                    saveDataBatch(reqVO, arr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        return null;
    }

    private void saveDataBatch(Map<String, Object> reqVO, JSONArray jsonArray) {
        String reqResult;
        for (Object openid : jsonArray) {
            String userInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info" +
                    "?access_token=" + getAccessToken(reqVO.get("appid"), reqVO.get("secret")) +
                    "&openid=" + openid +
                    "&lang=zh_CN";
            reqResult = HttpUtil.get(userInfoUrl);
            WeChatFollower weChatFollower = JSONObject.parseObject(reqResult, WeChatFollower.class);
            weChatFollower.setTagIdListStr(weChatFollower.getTagIdList().stream().collect(Collectors.joining(",")));
            System.out.println("currentThread------------------:" + Thread.currentThread().getName());
            System.out.println("current:" + weChatFollower);
            weChatMapper.insert(weChatFollower);
        }
    }


    @Override
    public List<WeChatFollower> saveWeChatFollowerListSingle(Map<String, Object> reqVO) {
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

    @Override
    public List<WeChatFollower> saveWeChatFollowerListBatch(Map<String, Object> reqVO) {
        boolean flag = true;
        String next_openid = null;
        // String next_openid = "o1sGt1SA2pgnLJ7Za67n5ZaRKfNg";
        while (flag) {
            String openidListUrl = "https://api.weixin.qq.com/cgi-bin/user/get" +
                    "?access_token=" + getAccessToken(reqVO.get("appid"), reqVO.get("secret")) +
                    (next_openid == null ? "" : ("&next_openid=" + next_openid));
            String reqResult = HttpUtil.get(openidListUrl);
            JSONObject result = JSONObject.parseObject(reqResult);
            List<String> list = JSONArray.parseArray(result.getJSONObject("data").getString("openid"), String.class);
            if (list.size() == 0) {
                flag = false;
            }
            next_openid = list.get(list.size() - 1);
            List<Map<String, String>> reqUserList = new ArrayList<>();
            for (String openid : list) {
                Map<String, String> map = new HashMap<>();
                map.put("openid", openid);
                reqUserList.add(map);
                if (reqUserList.size() == 100 || (list.size() < 10000 && openid.equals(list.get(list.size() - 1)))) {
                    String url2 = "https://api.weixin.qq.com/cgi-bin/user/info/batchget" +
                            "?access_token=" + getAccessToken(reqVO.get("appid"), reqVO.get("secret"));
                    Map<String, Object> reqParam = new HashMap<>();
                    reqParam.put("user_list", reqUserList);
                    String postResult = HttpUtil.post(url2, JSONObject.toJSONString(reqParam));
                    String jsonString = JSONObject.parseObject(postResult).getString("user_info_list");
                    List<WeChatFollower> weChatFollowers = JSONArray.parseArray(jsonString, WeChatFollower.class);
                    for (WeChatFollower item : weChatFollowers) {
                        weChatMapper.insert(item);
                    }
                    reqUserList.clear();
                }
            }
        }
        return null;
    }
}