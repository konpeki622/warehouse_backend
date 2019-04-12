package com.wanglei.mapper;

import com.wanglei.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User findByUsername(String username);

    void insertUser(User user);

    void updatePassword(@Param("username")String username, @Param("password")String password);
}
