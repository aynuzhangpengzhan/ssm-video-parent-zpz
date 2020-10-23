package com.qf.user.dao;

import com.qf.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 14:13
 */
@Repository
public interface VideoDao {
    List<Video> findAll();

    Video findVideoById(String id);

    List<Video> findByCourseId(Integer courseId);
}
