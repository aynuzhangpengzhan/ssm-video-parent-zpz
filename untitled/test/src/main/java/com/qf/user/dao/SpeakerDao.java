package com.qf.user.dao;

import com.qf.pojo.Speaker;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/22 16:24
 */
@Repository
public interface  SpeakerDao {
    Speaker findById(Integer id);

    List<Speaker> findAll();
}
