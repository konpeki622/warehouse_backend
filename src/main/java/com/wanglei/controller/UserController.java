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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @CheckToken
//    @RequestMapping(value="/user/download", method = RequestMethod.POST)
//    public @ResponseBody String dowm(HttpServletResponse response, @RequestParam(value = "auth", required = false) Integer auth, @RequestParam(value = "keywords",required = false) String[] keywords, @RequestParam(value = "pageStart") Integer pageStart, @RequestParam(value = "pageEnd") Integer pageEnd){
//        response.setContentType("application/binary;charset=UTF-8");
//        try{
//            ServletOutputStream out=response.getOutputStream();
//            try {
//                //设置文件头：最后一个参数是设置下载文件名(这里我们叫：张三.pdf)
//                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("用户信息导出.xls", "UTF-8"));
//            } catch (UnsupportedEncodingException e1) {
//                e1.printStackTrace();
//            }
//
//            userService.export(auth, keywords, pageStart, pageEnd, out);
//            return "success";
//        } catch(Exception e){
//            e.printStackTrace();
//            return "导出信息失败";
//        }
//    }

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
    public ResponseEntity registerController(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "auth") Integer auth, @RequestParam(value = "nickname") String nickname, @RequestParam(value = "gender") String gender, @RequestParam(value = "workid") String workid, @RequestParam(value = "phone") String phone, @RequestParam(value = "email") String email){
        if(userService.register(username, password, auth, workid, nickname, gender, phone, email)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null, 0).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"failed to register!"));
    }

    @RequestMapping(value = {"/user/list"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage goodsController(@RequestParam(value = "auth", required = false) Integer auth, @RequestParam(value = "keywords",required = false) String[] keywords, @RequestParam(value = "page") Integer page){
        List<User> userList = userService.getUser(auth, keywords, page);
        Integer count = userService.getUserCount(auth, keywords);
        return new ResponseMessage<>(userList, count).success();
    }

    @CheckToken
    @RequestMapping(value = {"/user/update"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity passwordController(@RequestParam(value = "id") Integer id, @RequestParam(value = "username") String username, @RequestParam(value = "oldPassword") String oldPassword, @RequestParam(value = "newPassword") String newPassword, @RequestParam(value = "phone") String phone, @RequestParam(value = "email") String email, @RequestParam(value = "auth") Integer auth, @RequestParam(value = "nickname") String nickname){
        Integer result = userService.updateUser(id, oldPassword, newPassword, phone, email, auth, nickname);
        if(result == 200){
            JSONObject jsonObject = new JSONObject();
            User info = userService.findUserByName(username);
            String token = JwtUtil.createJWT(600000000, info);
            jsonObject.put("token", token);
            return ResponseEntity.status(200).body(new ResponseMessage<>(jsonObject, 1).success());
        }
        else if (result == 404) {
            return ResponseEntity.status(205).body(new ResponseMessage<>(null, 0).error(205,"invalid password"));
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"failed to update password!"));
    }

    @CheckToken
    @RequestMapping(value = {"/user/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity deleteUserController(@RequestParam(value = "id") Integer id){
        if(userService.deleteUser(id)){
            return ResponseEntity.status(200).body(new ResponseMessage<>(null, 0).success());
        }
        return ResponseEntity.status(202).body(new ResponseMessage<>(null, 0).error(202,"failed to delete!"));
    }


}

