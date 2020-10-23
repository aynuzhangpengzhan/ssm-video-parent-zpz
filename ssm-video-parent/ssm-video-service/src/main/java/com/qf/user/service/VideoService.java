package com.qf.user.service;

import com.qf.pojo.Video;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 14:27
 */
public interface VideoService {
    List<Video> findAll();

    Video findVideoById(String id);

    List<Video> findByCourseId(Integer courseId);
}
