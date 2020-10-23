package com.qf.user.service;

import com.qf.pojo.Speaker;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/22 16:05
 */
public interface SpeakerService {

    Speaker findById(Integer id);

    List<Speaker> findAll();
}
