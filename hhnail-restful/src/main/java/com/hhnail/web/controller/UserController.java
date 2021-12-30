package com.hhnail.web.controller;

import com.hhnail.web.bean.User;
import com.hhnail.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
// @Api(tags = "用户模块")
public class UserController {

	@Autowired
	private UserService userService;

    @ApiOperation("查询用户")
	@GetMapping("/queryUser")
	public List<User> queryUser() {
		List<User> users = userService.queryUser();
	    System.out.println("users=" + users.toString());
		log.debug("users={}", users);
		return users;
	}


}
