package com.example.boot.service.impl;

import com.example.boot.mapper.ProductDao;
import com.example.boot.pojo.Product;
import com.example.boot.pojo.User;
import com.example.boot.service.ProductService;
import com.example.boot.tools.PageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;
    @Resource(name = "productDao")
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllProduct(PageUtil pageUtil) {
        return productDao.getAllProduct(pageUtil.page*pageUtil.pageSize,pageUtil.pageSize);
    }

    @Override
    public boolean deleteProduct(Integer id) {
        return productDao.deleteProduct(id);
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean findProduct(Integer id) {
        return false;
    }

    @Override
    public Integer getAllProductCount() {
        return productDao.getAll();
    }
}
