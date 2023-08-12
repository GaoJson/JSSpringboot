package com.example.boot.controller.admin;

import com.example.boot.service.BankService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankController {

    @Resource
    BankService bankService;
    @RequestMapping("/admin/bank")
    public String index(Model model){

        model.addAttribute("bankList",bankService.allBank());


        return "admin/bank";
    }

}
