package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IRecruitDao;
import com.lxd.project2.entity.Recruit;
import com.lxd.project2.service.IRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
@Transactional
@Service
public class RecruitServiceImpl implements IRecruitService {
    @Autowired
    private IRecruitDao iRecruitDao;
    @Override
    public void add(Recruit recruit) {
        iRecruitDao.add(recruit);
    }

    @Override
    public List<Recruit> queryAll() {
        return iRecruitDao.queryAll();
    }

    @Override
    public Recruit queryByID(int id) {
        return iRecruitDao.queryByID(id);
    }

    @Override
    public void deleteById(int id) {
        iRecruitDao.deleteById(id);
    }

    @Override
    public void changeRecruit(Recruit recruit) {
        iRecruitDao.changeRecruit(recruit);
    }
}
