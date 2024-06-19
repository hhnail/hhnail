package com.hhnail.web.service;


import com.alibaba.fastjson.JSONObject;
import com.hhnail.web.bean.YunbiCommonUser;

import java.util.List;
import java.util.Map;

/**
 * 微信公众号事件日志
 *
 * @author zlt
 * @date 2023-12-09 13:53:14
 */
public interface IJdbcCdpQaService {


    List<YunbiCommonUser> getList(Map<String, Object> param);

    int insertList(List<YunbiCommonUser> list);
    
    String getNewUpdateTime(Map<String, Object> param);

    void insertOrUpdate(YunbiCommonUser obj);


    void resetUserPwd(JSONObject param);
}

