package com.example.boot.controller.front;

import com.example.boot.tools.RedisTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontLoginController {

    @Autowired
    private RedisTool redisTool;

    @RequestMapping("/login")
    public String login() {

        System.out.print(redisTool.getRedis("data"));


        return "front/login";
    }

}
