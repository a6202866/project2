package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IInterviewDao;
import com.lxd.project2.entity.Interview;
import com.lxd.project2.entity.Resume;
import com.lxd.project2.service.IInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
@Transactional
@Service
public class InterviewServiceImpl implements IInterviewService {
    @Autowired
    private IInterviewDao iInterviewDao;
    @Override
    public void add(Resume resume) {
        iInterviewDao.add(resume);
    }

    @Override
    public List<Interview> queryAll() {
        return iInterviewDao.queryAll();
    }

    @Override
    public Interview queryByName(String name) {
        return iInterviewDao.queryByName(name);
    }

    @Override
    public void deleteByName(String name) {
        iInterviewDao.deleteByName(name);
    }

    @Override
    public void update(String username) {
        iInterviewDao.update(username);
    }
}
