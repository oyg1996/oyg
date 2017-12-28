package com.oyg.service.impl;

import com.oyg.dao.UserMapper;
import com.oyg.entity.User;
import com.oyg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/12/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User insert(User user) {
        userMapper.insert(user);
        return user;
    }
}
