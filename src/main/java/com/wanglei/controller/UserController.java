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
            return ResponseEntity.status(202).body(new ResponseMessage<>(null).error(202,"account is not exist"));
        }
        else {
            if (!result.getPassword().equals(password)) {
                return ResponseEntity.status(202).body(new ResponseMessage<>(null).error(202,"invalid password"));
            }
            else {
                String token = JwtUtil.createJWT(6000000, result);
                jsonObject.put("token", token);
                jsonObject.put("user", result);
                return ResponseEntity.status(200).body(new ResponseMessage<>(jsonObject).success());
            }
        }
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity registerController(@RequestBody User user){
        if(userService.register(user)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null).error(202,"failed to register!"));
    }

    @CheckToken
    @RequestMapping(value = {"/password"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity passwordController(@RequestParam(value = "username") String username, @RequestParam(value = "oldPassword") String oldPassword, @RequestParam(value = "newPassword") String newPassword){
        if(userService.updatePassword(username, oldPassword, newPassword) == -1){
            return ResponseEntity.status(205).body(new ResponseMessage<>(null).error(205,"invalid password"));
        }
        else if (userService.updatePassword(username, oldPassword, newPassword) == 1) {
            return ResponseEntity.status(200).body(new ResponseMessage<>(null).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null).error(202,"failed to update password!"));
    }


}

