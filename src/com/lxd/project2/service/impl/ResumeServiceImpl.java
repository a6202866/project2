package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IResumeDao;
import com.lxd.project2.entity.Resume;
import com.lxd.project2.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
@Transactional
@Service
public class ResumeServiceImpl  implements IResumeService{
    @Autowired
    private IResumeDao iResumeDao;

    @Override
    public void add(Resume resume) {
        iResumeDao.add(resume);
    }

    @Override
    public Resume queryByUserName(String name) {
        return iResumeDao.queryByUserName(name);
    }

    @Override
    public void update(Resume resume) {
        iResumeDao.update(resume);
    }
}
