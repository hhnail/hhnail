package com.hhnail.web.service;


import com.hhnail.web.bean.WeChatFollower;

import java.util.List;
import java.util.Map;

public interface IWeChatService {

    List<WeChatFollower> getWeChatFollowerList(Map<String, Object> reqVO);

    List<WeChatFollower> saveWeChatFollowerList(Map<String, Object> reqVO);

    /**
     * 查询单个用户，并保存
     * @param reqVO
     * @return
     */
    List<WeChatFollower> saveWeChatFollowerListSingle(Map<String, Object> reqVO);

    /**
     * 批量查询用户，并保存
     * @param reqVO
     * @return
     */
    List<WeChatFollower> saveWeChatFollowerListBatch(Map<String, Object> reqVO);
}
