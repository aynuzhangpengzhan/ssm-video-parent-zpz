package com.qf.user.service.impl;

import com.qf.pojo.Video;
import com.qf.user.dao.VideoDao;
import com.qf.user.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 14:31
 */
@Service
public class VideoServiceimpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }

    @Override
    public Video findVideoById(String id) {
        return videoDao.findVideoById(id);
    }

    @Override
    public List<Video> findByCourseId(Integer courseId) {
        return videoDao.findByCourseId(courseId);
    }
}
