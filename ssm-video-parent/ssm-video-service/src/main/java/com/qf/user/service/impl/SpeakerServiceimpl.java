package com.qf.user.service.impl;

import com.qf.pojo.Speaker;
import com.qf.user.dao.SpeakerDao;
import com.qf.user.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/22 16:06
 */
@Service
public class SpeakerServiceimpl implements SpeakerService {

    @Autowired
    private SpeakerDao speakerDao;
    @Override
    public Speaker findById(Integer id) {
        return speakerDao.findById(id);
    }

    @Override
    public List<Speaker> findAll() {
        return speakerDao.findAll();
    }
}
