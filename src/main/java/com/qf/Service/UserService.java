package com.qf.Service;

import com.qf.pojo.User;

import java.util.List;

public interface UserService {
    List<User> all();
    Boolean deleteById(int id);
    User findById(int id);
    Boolean update(User user);
}
