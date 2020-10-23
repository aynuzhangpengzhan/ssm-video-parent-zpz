package com.qf.user.dao;

import com.qf.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 11:02
 */
@Repository
public interface CourseDao {
    List<Course> findAll();

    Course findById(Integer id);

}
