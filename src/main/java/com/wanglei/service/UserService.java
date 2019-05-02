package com.wanglei.service;
import com.wanglei.pojo.User;

import java.util.List;

public interface UserService {
    //检验用户登录
    User findUserByName(String username);
    boolean register(String username, String password, Integer auth);
    Integer updatePassword(String username, String oldPassword, String newPassword);
}
