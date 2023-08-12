package com.example.boot.service;

import com.example.boot.pojo.Product;
import com.example.boot.pojo.User;
import com.example.boot.tools.PageUtil;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct(PageUtil pageUtil);

    boolean deleteProduct(Integer id);

    boolean updateProduct(Product product);

    boolean addProduct(Product product);

    boolean findProduct(Integer id);

    Integer getAllProductCount();


}
