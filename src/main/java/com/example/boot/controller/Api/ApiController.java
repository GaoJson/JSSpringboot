package com.example.boot.controller.Api;

import com.example.boot.pojo.User;
import com.example.boot.service.UserService;
import com.example.boot.tools.ApiResponse;
import com.example.boot.tools.RedisTool;
import com.example.boot.tools.TokenTool;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Resource
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam Map<String,Object> map,@RequestHeader Map<String,Object> header){
        String userName = map.get("username").toString();
        String password = map.get("password").toString();
        User user = userService.login(userName,password);
        if (user != null) {
            String token = TokenTool.createToken(user);
            HashMap<String,Object> data = new HashMap<>();
            data.put("token",token);
            return ApiResponse.response(200,"登录成功",data);
        }
        return ApiResponse.response(500,"账户或密码错误","");
    }

    @PostMapping("/user")
    public String user(@RequestHeader Map<String,Object> header) {
        String tokens = header.get("cookie").toString();
        String tk = TokenTool.getCookie("token",tokens);
        String tokenFlag = TokenTool.verifyToken(tk);
        if (!tokenFlag.isEmpty()) {
            User model = userService.findUser(tokenFlag);
            model.setPassword(null);
            return ApiResponse.response(200,"请求成功",model);
        }


        return ApiResponse.response(500,"登录过期",tk);
    };








}
