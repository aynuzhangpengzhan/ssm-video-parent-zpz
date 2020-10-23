package com.qf.user.service.impl;


import com.qf.pojo.Course;
import com.qf.pojo.Video;
import com.qf.user.dao.CourseDao;
import com.qf.user.service.CourseService;
import com.qf.user.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 14:30
 */
@Service
public class CourseServiceimpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public Course findByid(Integer id) {
        return courseDao.findById(id);
    }
}
