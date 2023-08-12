package com.example.boot.pojo;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String nickname;
    private String password;
    private String img;
    private String create_time;
}


