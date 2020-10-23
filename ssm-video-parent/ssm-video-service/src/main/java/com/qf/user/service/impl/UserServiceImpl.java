package com.qf.user.service.impl;

import com.qf.pojo.User;
import com.qf.user.dao.UserDao;
import com.qf.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(String email, String password) {

        System.out.println(email);
        System.out.println(password);
        return userDao.findUser(email,password);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public void insertUser(User user) {
        System.out.println("12346565");

         userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {

       userDao.updateUser(user);
    }
}
