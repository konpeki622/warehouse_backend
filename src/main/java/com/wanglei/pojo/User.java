package com.wanglei.pojo;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private Integer auth;
    private String gender;
    private String nickname;
    private String workid;
    private String email;
    private String phone;
    private String auth_name;
    private Integer menu_id;

    @JsonProperty(value = "id")
    public Integer getId() {
        return this.id;
    }

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
    public Integer getAuth() {
        return this.auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    @JsonProperty(value = "gender")
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty(value = "nickname")
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonProperty(value = "workid")
    public String getWorkId() {
        return this.workid;
    }
    public void setWorkId(String workid) {
        this.workid = workid;
    }

    @JsonProperty(value = "email")
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty(value = "phone")
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty(value = "auth_name")
    public String getAuthName() {
        return this.auth_name;
    }
    public void setAuthName(String auth_name) {
        this.auth_name = auth_name;
    }

    @JsonProperty(value = "menu_id")
    public Integer getMenuId() {
        return this.menu_id;
    }
    public void setMenuId(Integer menu_id) {
        this.menu_id = menu_id;
    }
}
