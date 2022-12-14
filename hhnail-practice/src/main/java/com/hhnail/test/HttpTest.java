package com.hhnail.test;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author r221587
 * @version 1.0
 * @description: java Http
 * @date 2022/12/14 16:35
 */
public class HttpTest {

    /**
     * hutool工具
     * java用body传递json类型参数，发送http请求
     */
    @Test
    public void test01(){
        // {
        //     "param": {
        //             "time": "2022-12-12 14:22:22",
        //             "accesstoken": "034cfa11106819837586d4dd30259a49",
        //             "ehr_no": "213374"
        // }
        // }
        JSONObject param = new JSONObject();
        param.put("time", "2022-12-12 14:22:22");
        param.put("accesstoken", "034cfa11106819837586d4dd30259a49");
        param.put("ehr_no", "213374");
        JSONObject json = new JSONObject();
        json.put("param", param);
        String body = HttpUtil.createPost("http://tst-fx.hzrobam.com/DWGateway/restful/Sys/ILoginService/login4GuideHelper")
                .contentType("application/json")
                .body(json.toString()).execute().body();
        System.out.println(JSONObject.toJSONString(body));
    }


}

