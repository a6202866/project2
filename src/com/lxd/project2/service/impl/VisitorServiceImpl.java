package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IVisitorDao;
import com.lxd.project2.entity.Visitor;
import com.lxd.project2.service.IVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
@Transactional
@Service("VisitorService")
public class VisitorServiceImpl implements IVisitorService{
    @Autowired
    private IVisitorDao iVisitorDao;
    @Override
    public void add(Visitor visitor) {
        iVisitorDao.add(visitor);
    }

    @Override
    public Visitor queryByName(String name) {
        return iVisitorDao.queryByName(name);
    }

    @Override
    public void regist(Visitor visitor) {
        iVisitorDao.add(visitor);
    }

    @Override
    public Visitor queryByNamePassword(Visitor visitor) {
        return iVisitorDao.queryByNamePassword(visitor);
    }

}
