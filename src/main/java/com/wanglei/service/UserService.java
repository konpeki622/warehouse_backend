package com.wanglei.service;
import com.wanglei.pojo.User;

import javax.servlet.ServletOutputStream;
import java.util.List;

public interface UserService {
    //检验用户登录
    User findUserByName(String username);
    List<User> getUser(Integer auth, String[] keywords, Integer page);
    Integer getUserCount(Integer auth, String[] keywords);
    boolean register(String username, String password, Integer auth, String workid, String nickname, String gender, String phone, String email);
    Integer updateUser(Integer id, String oldPassword, String newPassword, String phone, String email, Integer auth, String nickname);
    boolean deleteUser(Integer id);
//    void export(Integer auth, String[] keywords, Integer pageStart, Integer pageEnd, ServletOutputStream out);
}
