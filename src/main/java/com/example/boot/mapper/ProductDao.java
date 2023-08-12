package com.example.boot.mapper;

import com.example.boot.pojo.Product;
import com.example.boot.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    Integer addProduct(@Param("Product") Product product);

    boolean deleteProduct(Integer id);

    boolean updateProduct(ProductDao productDao);

    List<Product> getAllProduct(@Param("page") int page, @Param("pageSize") int pageSize);

    Integer getAll();

}
