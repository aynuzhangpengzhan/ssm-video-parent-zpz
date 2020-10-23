package com.qf.user.service;

import com.qf.pojo.Course;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 14:27
 */
public interface CourseService {
    List<Course> findAll();
    Course findByid(Integer id);
}
