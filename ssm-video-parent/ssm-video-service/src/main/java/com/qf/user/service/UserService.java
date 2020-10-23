package com.qf.user.service;

import com.qf.pojo.User;

public interface UserService {
    User findUser(String email, String password);

    User findUserByEmail(String email);

    void insertUser(User user);

    void updateUser(User user);
}
