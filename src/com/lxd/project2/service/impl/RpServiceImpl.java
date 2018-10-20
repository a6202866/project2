package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IRpDao;
import com.lxd.project2.entity.Rp;
import com.lxd.project2.service.IRpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
@Transactional
@Service
public class RpServiceImpl implements IRpService {
    @Autowired
    private IRpDao iRpDao;
    @Override
    public void add(Rp rp) {
        iRpDao.add(rp);
    }

    @Override
    public List<Rp> queryAll() {
        return iRpDao.queryAll();
    }

    @Override
    public List<Rp> queryByDate(String date) {
        return iRpDao.queryByDate(date);
    }

    @Override
    public void deleteById(int id) {
        iRpDao.deleteById(id);
    }

    @Override
    public Rp queryById(int id) {
        return iRpDao.queryById(id);
    }

    @Override
    public void changeRp(Rp rp) {
        iRpDao.changeRp(rp);
    }

    @Override
    public List<Rp> queryByUsername(String username) {
        return iRpDao.queryByUsername(username);
    }

    @Override
    public List<Rp> queryByDateUsername(String username, String date) {
        return iRpDao.queryByDateUsername(username,date);
    }
}
