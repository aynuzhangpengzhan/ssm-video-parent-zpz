package com.qf.user.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 9:53
 */
@Repository
public interface UserDao {
    User findUser(@Param("email") String email, @Param("password") String password);

    User findUserByEmail(String email);

    void updateUser(User user);

    void insertUser(User user);


}
