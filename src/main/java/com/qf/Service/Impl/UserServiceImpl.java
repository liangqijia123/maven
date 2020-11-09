package com.qf.Service.Impl;

import com.qf.Dao.Impl.UserDaoImpl;
import com.qf.Dao.UserDao;
import com.qf.Service.UserService;
import com.qf.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> all() {
        return userDao.all();
    }

    @Override
    public Boolean deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public Boolean update(User user) {
        return userDao.update(user);
    }
}
