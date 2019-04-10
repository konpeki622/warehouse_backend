package com.wanglei.mapper;

import com.wanglei.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User findByUsername(String username);

    void insertUser(User user);

    void updatePassword(User user);
}
