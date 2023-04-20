package com.hhnail.web.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.hhnail.web.service.DingDingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author r221587
 * @version 1.0
 * @description: 钉钉API
 * @date 2023/4/19 17:41
 */
@Service
@Slf4j
public class DingDingServiceImpl implements DingDingService {

    public static void main(String[] args) {
        new DingDingServiceImpl().getSubDepartmentIds("1");
    }

    // 请求api的token
    private final static String DING_DING_API_TOKEN_REDIS_KEY = "DING_DING_API_TOKEN_REDIS_KEY";
    private final static String SUB_DEPT_IDS_URL = "https://oapi.dingtalk.com/topapi/v2/department/listsubid";
    private final static String APP_KEY = "dingwvsum0hr84anpzh0";
    private final static String APP_SECRET = "curkP7uFdDuFLYqfaxixGmext_SCdBxrS190B1wNX7DpGRLqoLyMQ53ABKsZ6KO3";

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public String getDingDingApiToken() {

        // 如果命中缓存，直接取缓存即可
        Object token = redisTemplate.opsForValue().get(DING_DING_API_TOKEN_REDIS_KEY);
        if (token != null) {
            return token.toString();
        }

        String url = "https://oapi.dingtalk.com/gettoken" +
                "?appkey=" + APP_KEY +
                "&appsecret=" + APP_SECRET;

        log.info("v-DingDingServiceImpl-getDingDingApiToken-url:{}", url);


        String httpGetBody = HttpUtil.createGet(url).execute().body();
        JSONObject resultJson = JSONObject.parseObject(httpGetBody);
        String accessToken = resultJson.getString("access_token");

        log.info("v-DingDingServiceImpl-getDingDingApiToken-accessToken:{}", accessToken);

        // 缓存token
        redisTemplate.opsForValue().set(DING_DING_API_TOKEN_REDIS_KEY, accessToken, (60 * 2 - 5), TimeUnit.MINUTES);
        // redisTemplate.expire(DING_DING_API_TOKEN, (60 * 2 - 5), TimeUnit.MINUTES);

        return accessToken;


    }

    @Override
    public List<Integer> getSubDepartmentIds(String deptId) {

        log.info("v-DingDingServiceImpl-getSubDepartmentIds-入参-deptId:{}", deptId);

        Map<String, Object> param = new HashMap<String, Object>() {{
            put("dept_id", deptId);
        }};
        String apiUrl = SUB_DEPT_IDS_URL + "?access_token=" + getDingDingApiToken();

        log.info("v-DingDingServiceImpl-getSubDepartmentIds-apiUrl:{}", apiUrl);

        String postResult = HttpUtil.createPost(apiUrl)
                .body(JSONObject.toJSONString(param))
                .execute()
                .body();

        log.info("v-DingDingServiceImpl-getSubDepartmentIds-postResult:{}", postResult);

        JSONObject postResultJson = JSONObject.parseObject(postResult);

        if (postResultJson == null || !(new Integer(0).equals(postResultJson.getInteger("errcode")))) {
            log.error("v-DingDingServiceImpl-getSubDepartmentIds-post error-errcode:{},errmsg:{}",
                    postResultJson.get("errcode"), postResultJson.get("errmsg")
            );
            throw new RuntimeException("调用钉钉接口失败，原因：" + postResultJson.get("errmsg"));
        }

        List<Integer> subDepartmentIds = postResultJson.getJSONObject("result").getObject("dept_id_list", List.class);

        log.info("v-DingDingServiceImpl-getSubDepartmentIds-出参-subDepartmentIds:{}", subDepartmentIds);

        return subDepartmentIds;
    }
}
