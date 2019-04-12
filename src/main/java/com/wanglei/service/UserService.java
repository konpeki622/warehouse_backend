package com.wanglei.service;
import com.wanglei.pojo.User;

import java.util.List;

public interface UserService {
    //检验用户登录
    User findUserByName(String username);
    boolean register(User user);
    Integer updatePassword(String username, String oldPassword, String newPassword);
}
