package com.hhnail.web.controller;

import com.hhnail.web.bean.WeChatFollower;
import com.hhnail.web.service.IWeChatService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author r221587
 * @version 1.0
 * @description: 微信平台
 * @date 2023/7/4 10:48
 */
@Slf4j
@RestController
@RequestMapping("/wechat")
@Api(tags = "微信平台api")
public class WeChatController {

    // 创建线程池并设置参数
    private int corePoolSize = 5;
    private int maxPoolSize = 10;
    private long keepAliveTime = 5000;
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    private BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workQueue);

    @Autowired
    IWeChatService weChatService;

    @PostMapping("/getWeChatFollowerList")
    public List<WeChatFollower> getWeChatFollowerList(@RequestBody Map<String, Object> reqVO) {
        List<WeChatFollower> weChatFollowerList = weChatService.getWeChatFollowerList(reqVO);
        return weChatFollowerList;
    }

    @PostMapping("/saveWeChatFollowerList")
    public List<WeChatFollower> saveWeChatFollowerList(@RequestBody Map<String, Object> reqVO) {
        List<WeChatFollower> weChatFollowerList = weChatService.saveWeChatFollowerListBatch(reqVO);
        return null;
    }


}
