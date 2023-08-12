package com.example.boot.controller.admin;

import com.example.boot.pojo.User;
import com.example.boot.service.UserService;
import com.example.boot.tools.ApiResponse;
import com.example.boot.tools.PageUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class UserController {

    @Resource(name = "userService")
    UserService userService;

    @RequestMapping(value = "/admin/user")
    public String user(HttpSession session, @RequestParam("page") Integer page, Model model) {
        Integer allCount = userService.getAllUserCount();
        model.addAttribute("allCount",allCount);
        PageUtil pageUtil = new PageUtil();
        pageUtil.page = page-1;
        pageUtil.pageSize = 10;
        model.addAttribute("userList",userService.getAllUsers(pageUtil));
        model.addAttribute("page",pageUtil.getPageList(page,allCount));
        return "admin/user";
    }

    @PostMapping("/admin/user/delete")
    @ResponseBody
    public String deleteUser(@RequestParam Map<String,Object> map) {
        userService.deleteUser(Integer.parseInt(""+map.get("id")));
        return ApiResponse.response(200,"删除成功",null);
    }

    @PostMapping("/admin/user/update")
    @ResponseBody
    public String updateUser(@RequestParam Map<String,Object>map) {
        System.out.println(map);
        User user = new User();
        user.setId(Integer.parseInt(map.get("id").toString()));
        user.setUsername(map.get("username").toString());
        user.setNickname(map.get("nickname").toString());
        user.setImg(map.get("img").toString());
        userService.updateUser(user);
        return ApiResponse.response(200,"更新成功",null);
    }

    @RequestMapping(value = "/registerAction")
    public  String registerAction(String username, String password, MultipartFile files, Model model){
        User user  =  userService.findUser(username);
        if (user != null) {
            model.addAttribute("message","用户已存在");
        } else  {
            String originalFilename = files.getOriginalFilename();
            Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置显示格式
            String nowTime = df.format(dt);
            String imgPath = "";
            if (!files.isEmpty()) {
                try {
                    String path = ResourceUtils.getURL("classpath:").getPath()+"static/img/upload/";
                    File dirs = new File(path);
                    if (!dirs.exists()) {
                        dirs.mkdirs();
                    }
                    path = path+nowTime+originalFilename;
                    System.out.println(nowTime);
                    files.transferTo(new File(path));
                    imgPath = "img/upload/"+nowTime+originalFilename;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            User addUser = new User();
            addUser.setUsername(username);
            addUser.setPassword(password);
            addUser.setImg(imgPath);
            for (int i = 0; i < 100; i++) {
                addUser.setUsername(username+i);
                boolean isAdd = userService.addUser(addUser);
            }
            model.addAttribute("message","注册成功");
        }
        return "redirect:/register";
    }



}
