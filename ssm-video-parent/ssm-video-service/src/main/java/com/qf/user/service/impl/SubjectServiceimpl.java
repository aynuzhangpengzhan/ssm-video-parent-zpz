package com.qf.user.service.impl;

import com.qf.pojo.Subject;
import com.qf.user.dao.SubjectDao;
import com.qf.user.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 10:35
 */
@Service
public class SubjectServiceimpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }

    @Override
    public Subject findSubject(Integer id) {
        return subjectDao.findSubject(id);
    }
}
