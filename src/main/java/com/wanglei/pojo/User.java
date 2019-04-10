package com.wanglei.pojo;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * 用户实体
 * 与用户表对应
 *
 */
@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private Integer auth;

    @JsonProperty(value = "id")
    public Integer getId() { return this.id; }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty(value = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty(value = "auth")
    public Integer getAuth() { return this.auth; }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }
}
