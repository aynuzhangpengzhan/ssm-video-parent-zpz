package com.qf.user.dao;

import com.qf.pojo.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 10:29
 */
@Repository
public interface SubjectDao {
    List<Subject> findAll();

    Subject findSubject(Integer Id);
}
