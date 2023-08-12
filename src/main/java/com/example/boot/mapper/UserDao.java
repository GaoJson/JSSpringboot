package com.example.boot.mapper;

import com.example.boot.pojo.User;
import com.example.boot.tools.PageUtil;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface UserDao {

    List<User> getAllUser(@Param("page") int page,@Param("pageSize") int pageSize);

    User findUser(String username);

    boolean addUser(@Param("user") User user);

    boolean updateUser(@Param("user") User user);

    boolean deleteUser(Integer id);

    Integer getAllUserCount();

    User selectByLogin(@Param("userName") String userName,@Param("password") String password);


}
