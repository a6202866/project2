package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IIDDao;
import com.lxd.project2.entity.IID;
import com.lxd.project2.service.IIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
@Transactional
@Service
public class IIDServiceImpl implements IIDService{
    @Autowired
    private IIDDao iidDao;
    @Override
    public void add(IID iid) {
        iidDao.add(iid);
    }

    @Override
    public IID queryByRID(IID iid) {
        return iidDao.queryByRID(iid);
    }

}
