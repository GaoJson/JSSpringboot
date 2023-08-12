package com.example.boot.controller.admin;

import com.alibaba.fastjson.JSON;
import com.example.boot.pojo.User;
import com.example.boot.service.BankService;
import com.example.boot.service.UserService;
import com.example.boot.tools.ApiResponse;
import com.example.boot.tools.Tools;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LoginController {
    @Resource(name = "userService")
    UserService userService;

    @Resource(name = "bankService")
    BankService bankService;

    @RequestMapping("/admin/login")
    public String loginPage() {
        Tools.loadBankData(bankService);

        return "admin/login";
    }

    @PostMapping("/admin/api/login")
    @ResponseBody
    public String login(HttpServletRequest httpServletRequest, @RequestParam Map<String,Object> map) {
        String verifyCode =  (String) httpServletRequest.getSession().getAttribute("verifyCode");
        String inputVerifyCode = (String) map.get("verifyCode");
        if (!inputVerifyCode.toLowerCase().equals(verifyCode)) {
           // return ApiResponse.response(500,"验证码错误",null);
        }

        String userName = map.get("username").toString();
        String password = map.get("password").toString();

        User user = userService.login(userName,password);
        if (user != null) {
            httpServletRequest.getSession().setAttribute("admin_id",user.getId());
            httpServletRequest.getSession().setAttribute("admin_name",user.getUsername());
            return ApiResponse.response(200,"登录成功", JSON.toJSON(user));
        } else  {
            return ApiResponse.response(500,"用户名或密码错误", null);
        }
    }
}
