package com.wanglei.service.impl;

import com.wanglei.mapper.UserMapper;
import com.wanglei.pojo.User;
import com.wanglei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public boolean register(String username, String password, Integer auth) {
        if (username.isEmpty() || password.isEmpty()) return false;
        userMapper.insertUser(username, password, auth);
        return true;
    }

    @Override
    public Integer updatePassword(String username, String oldPassword, String newPassword) {
        if (!findUserByName(username).getPassword().equals(oldPassword)) return 404;
        else {
            userMapper.updatePassword(username, newPassword);
            return 200;
        }
    }
}
