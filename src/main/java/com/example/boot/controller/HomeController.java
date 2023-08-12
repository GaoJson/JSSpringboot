package com.example.boot.controller;

import com.example.boot.service.ProductService;
import com.example.boot.service.UserService;
import com.example.boot.tools.PageUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Resource(name = "userService")
    UserService userService;
    @Resource(name = "productService")
    ProductService productService;







}
