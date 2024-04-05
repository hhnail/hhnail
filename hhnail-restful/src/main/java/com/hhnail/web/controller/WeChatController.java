package com.hhnail.web.controller;

import com.hhnail.web.bean.WeChatFollower;
import com.hhnail.web.service.IWeChatService;
import com.hhnail.web.util.VvEncryptUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
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

    private static final String TOKEN = "hhnail";

    @Autowired
    IWeChatService weChatService;

    @GetMapping("/checkSignature")
    public boolean checkSignature(
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce
    ) {

        String[] tmpArr = {TOKEN, timestamp, nonce};
        Arrays.sort(tmpArr);
        String tmpStr = String.join("", tmpArr);
        tmpStr = VvEncryptUtil.sha1(tmpStr);

        return tmpStr.equals(signature);
    }

    @PostMapping("/getWeChatFollowerList")
    public List<WeChatFollower> getWeChatFollowerList(@RequestBody Map<String, Object> reqVO) {
        List<WeChatFollower> weChatFollowerList = weChatService.getWeChatFollowerList(reqVO);
        return weChatFollowerList;
    }

    /**
     * 保存公众号关注用户列表
     *
     * @param reqVO
     * @return
     */
    @PostMapping("/saveWeChatFollowerList")
    public List<WeChatFollower> saveWeChatFollowerList(@RequestBody Map<String, Object> reqVO) {
        List<WeChatFollower> weChatFollowerList = weChatService.saveWeChatFollowerListBatch(reqVO);
        return null;
    }


}
