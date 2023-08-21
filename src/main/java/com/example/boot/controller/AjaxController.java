package com.example.boot.controller;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.boot.mapper.ProductDao;
import com.example.boot.pojo.Product;
import com.example.boot.pojo.User;
import com.example.boot.service.UserService;
import com.example.boot.tools.ApiResponse;
import com.example.boot.tools.Tools;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import javax.tools.Tool;
import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AjaxController {

    @Resource
    ProductDao productDao;

    @Resource(name = "userService")
    UserService userService;

    @RequestMapping("index/captcha")
    public  void defaultCaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/gif");
        // 三个参数分别为宽、高、位数
        SpecCaptcha captcha = new SpecCaptcha(100, 40, 4);
        // 设置字体
        captcha.setCharType(Captcha.FONT_9);
        // 验证码存入session
        httpServletRequest.getSession().setAttribute("verifyCode", captcha.text().toLowerCase());
        // 输出图片流
        captcha.out(httpServletResponse.getOutputStream());
    }


}
