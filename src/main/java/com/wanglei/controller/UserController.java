package com.wanglei.controller;

import com.alibaba.fastjson.JSONObject;
import com.wanglei.pojo.ResponseMessage;
import com.wanglei.pojo.User;
import com.wanglei.service.UserService;
import com.wanglei.util.CheckToken;
import com.wanglei.util.JwtUtil;
import com.wanglei.util.LoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = {"/checkLogin"}, method = RequestMethod.POST)
    @LoginToken
    public ResponseEntity loginController(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        JSONObject jsonObject = new JSONObject();
        User result = userService.findUserByName(username);
        if (result == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"account is not exist"));
        }
        else {
            if (!result.getPassword().equals(password)) {
                return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"invalid password"));
            }
            else {
                String token = JwtUtil.createJWT(600000000, result);
                jsonObject.put("token", token);
                jsonObject.put("user", result);
                return ResponseEntity.status(200).body(new ResponseMessage<>(jsonObject, 1).success());
            }
        }
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity registerController(@RequestParam(value = "username")String username,
                                             @RequestParam(value = "password")String password,
                                             @RequestParam(value = "auth")Integer auth){
        if(userService.register(username, password, auth)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null, 0).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"failed to register!"));
    }

    @RequestMapping(value = {"/password"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity passwordController(@RequestParam(value = "username") String username, @RequestParam(value = "oldPassword") String oldPassword, @RequestParam(value = "newPassword") String newPassword){
        if(userService.updatePassword(username, oldPassword, newPassword) == 200){
            JSONObject jsonObject = new JSONObject();
            User result = userService.findUserByName(username);
            String token = JwtUtil.createJWT(600000000, result);
            jsonObject.put("token", token);
            return ResponseEntity.status(200).body(new ResponseMessage<>(jsonObject, 1).success());
        }
        else if (userService.updatePassword(username, oldPassword, newPassword) == 404) {
            return ResponseEntity.status(205).body(new ResponseMessage<>(null, 0).error(205,"invalid password"));
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"failed to update password!"));
    }


}

