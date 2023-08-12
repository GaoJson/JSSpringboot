package com.example.boot.controller.admin;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.alibaba.fastjson.JSON;
import com.example.boot.pojo.User;
import com.example.boot.service.BankService;
import com.example.boot.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminController {


    @Resource(name = "userService")
    UserService userService;



    @RequestMapping("/admin")
    public String adminPage(HttpServletRequest httpServletRequest, Model model){
       Integer adminId = Integer.parseInt(httpServletRequest.getSession().getAttribute("admin_id").toString());
       String userName = httpServletRequest.getSession().getAttribute("admin_name").toString();
        User user = userService.findUser(userName);
        model.addAttribute("userInfo",user);
        return "admin/admin";
    }



}
