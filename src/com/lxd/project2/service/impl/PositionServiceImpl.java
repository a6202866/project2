package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IPositionDao;
import com.lxd.project2.entity.Position;
import com.lxd.project2.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
@Transactional
@Service
public class PositionServiceImpl implements IPositionService{
    @Autowired
    private IPositionDao iPositionDao;
    @Override
    public List<Position> queryAll() {
        return iPositionDao.queryAll();
    }

    @Override
    public List<Position> queryByDept(String dept) {
        return iPositionDao.queryByDept(dept);
    }

    @Override
    public void add(Position position) {
        iPositionDao.add(position);
    }

    @Override
    public void changePosition(Position position) {
        iPositionDao.changePosition(position);
    }

    @Override
    public void deletePosition(Position position) {
        iPositionDao.deletePosition(position);
    }

    @Override
    public void changeP(String dept, String dept1) {
        iPositionDao.changeP(dept,dept1);
    }

}
