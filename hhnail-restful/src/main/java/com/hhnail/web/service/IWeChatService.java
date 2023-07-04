package com.hhnail.web.service;


import com.hhnail.web.bean.WeChatFollower;

import java.util.List;
import java.util.Map;

public interface IWeChatService {

    List<WeChatFollower> getWeChatFollowerList(Map<String, Object> reqVO);

    List<WeChatFollower> saveWeChatFollowerList(Map<String, Object> reqVO);
}
