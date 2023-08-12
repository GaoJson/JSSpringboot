package com.example.boot.pojo;

import lombok.Data;

@Data
public class Product {

    Integer id;
    String product_name;
    Integer product_id;
    String product_banner;
    String product_content;
    double product_price;
    double product_sale_price;
    String product_img;
    String create_time;
}
