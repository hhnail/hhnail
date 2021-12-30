package com.hhnail.web.service.impl;

import com.hhnail.web.bean.User;
import com.hhnail.web.mapper.UserMapper;
import com.hhnail.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUser() {
        List<User> users = userMapper.selectList(null);
        return users;
    }
}
