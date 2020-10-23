package com.qf.user.service;

import com.qf.pojo.Subject;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 10:34
 */
public interface SubjectService {

    List<Subject> findAll();

    Subject findSubject(Integer Id);
}
