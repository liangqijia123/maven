package com.qf.Dao;

import com.qf.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> all();
    Boolean deleteById(int id);
    User findById(int id);
    Boolean update(User user);
}
