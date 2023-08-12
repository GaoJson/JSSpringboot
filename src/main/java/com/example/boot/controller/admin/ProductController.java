package com.example.boot.controller.admin;

import com.example.boot.service.ProductService;
import com.example.boot.tools.ApiResponse;
import com.example.boot.tools.PageUtil;
import com.example.boot.tools.Tools;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ProductController {

    @Resource(name = "productService")
    ProductService productService;


    @RequestMapping(value = "/admin/product")
    public String product(HttpSession session, @RequestParam("page") Integer page, Model model) {
        Integer allCount = productService.getAllProductCount();

        PageUtil pageUtil = new PageUtil();
        pageUtil.page = page-1;
        pageUtil.pageSize = 10;

        model.addAttribute("allCount",allCount);
        model.addAttribute("productList",productService.getAllProduct(pageUtil));
        model.addAttribute("page",pageUtil.getPageList(page,allCount));


        return "admin/product";
    }

    @RequestMapping("/admin/product/add")
    @ResponseBody
    public String  uploadProduct(@RequestParam Map<String, Object> map) {

        return ApiResponse.response(200,"请求成功","");
    }

    @RequestMapping("/admin/product/delete")
    @ResponseBody
    public String deleteProduct(@RequestParam Map<String,Object> map) {
        productService.deleteProduct(Integer.parseInt(""+map.get("id")));
        return ApiResponse.response(200,"删除成功",null);
    }


}
