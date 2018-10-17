package com.lxd.project2.service.impl;

import com.lxd.project2.dao.ITrainDao;
import com.lxd.project2.entity.Train;
import com.lxd.project2.service.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/17 0017.
 */
@Transactional
@Service
public class TrainServiceImpl implements ITrainService{
    @Autowired
    private ITrainDao iTrainDao;
    @Override
    public void add(Train train) {
        iTrainDao.add(train);
    }

    @Override
    public List<Train> queryByDept(String dept) {
        return iTrainDao.queryByDept(dept);
    }

    @Override
    public List<Train> queryAll() {
        return iTrainDao.queryAll();
    }

    @Override
    public void delByID(int id) {
        iTrainDao.delByID(id);
    }

    @Override
    public void update(Train train) {
        iTrainDao.update(train);
    }
}
