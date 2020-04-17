package com.wanglei.mapper;

import com.wanglei.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    User findByUsername(String username);
    User findById(Integer id);

    List<User> getUser(@Param("auth")Integer auth, @Param("keywords")String[] keywords, @Param("pageStart") Integer pageStart, @Param("pageEnd") Integer pageEnd);
    Integer getUserCount(@Param("auth")Integer auth, @Param("keywords")String[] keywords);

    void insertUser(@Param("username") String username, @Param("password") String password, @Param("auth") Integer auth, @Param("workid") String workid, @Param("nickname") String nickname, @Param("gender") String gender, @Param("email") String email, @Param("phone") String phone);
    void updateUser(@Param("id")Integer id, @Param("password") String password, @Param("auth") Integer auth, @Param("nickname") String nickname, @Param("phone") String phone, @Param("email") String email);
    void deleteUser(@Param("id")Integer id);
}
