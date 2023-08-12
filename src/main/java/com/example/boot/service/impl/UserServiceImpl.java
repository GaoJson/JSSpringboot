package com.example.boot.service.impl;

import com.example.boot.mapper.UserDao;
import com.example.boot.pojo.User;
import com.example.boot.service.UserService;
import com.example.boot.tools.PageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    @Resource(name = "userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getAllUsers(PageUtil pageUtil) {
        return userDao.getAllUser(pageUtil.page*pageUtil.pageSize,pageUtil.pageSize);
    }

    @Override
    public User findUser(String username) {
        return userDao.findUser(username);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    @Override
    public Integer getAllUserCount() {
        return userDao.getAllUserCount();
    }

    @Override
    public User login(String userName, String password) {
        return userDao.selectByLogin(userName,password);
    }
}
