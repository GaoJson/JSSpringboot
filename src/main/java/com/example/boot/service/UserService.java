package com.example.boot.service;

import com.example.boot.pojo.User;
import com.example.boot.tools.PageUtil;

import java.util.List;

public interface UserService {

    List<User> getAllUsers(PageUtil pageUtil);

    User findUser(String username);

    boolean updateUser(User user);

    boolean addUser(User user);

    boolean deleteUser(Integer id);

    Integer getAllUserCount();

    User login(String userName,String password);


}
