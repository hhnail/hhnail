package com.hhnail.web.controller;

import com.hhnail.web.bean.User;
import com.hhnail.web.service.UserService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @Api(tags = "用户模块")
@RestController
@Slf4j
// @Component
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("查询用户")
    @PostMapping("/queryUser")
    @XxlJob("queryUser")
    public ReturnT<String> queryUser(String param) {
        List<User> users = userService.queryUser();
        System.out.println("users=" + users.toString());
        log.debug("users={}", users);
        // return users;
        return ReturnT.SUCCESS;
    }

    @PostMapping("/run")
    @XxlJob("queryUser")
    public ReturnT<String> run(String param) {
        List<User> users = userService.queryUser();
        System.out.println("users=" + users.toString());
        log.debug("users={}", users);
        // return users;
        return ReturnT.SUCCESS;
    }


}
