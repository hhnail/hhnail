package com.hhnail.web.handler;

import com.hhnail.web.bean.User;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2023/4/26 11:08
 */
@Component
@Slf4j
public class XxlJobHandler {

    @XxlJob("XxlJobHandler4Println")
    public ReturnT<String> println(String param) {
        System.out.println("------------------定时任务执行了-----------XxlJobHandler4Println");
        return ReturnT.SUCCESS;
    }


    // @XxlJob("onlyHandlerCan")
    // public ReturnT<String> onlyHandlerCan(String param) {
    //     System.out.println("定时任务执行了==========================");
    //     log.debug("定时任务执行了==========================");
    //     // return users;
    //     return ReturnT.SUCCESS;
    // }
}
