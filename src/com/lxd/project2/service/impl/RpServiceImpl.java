package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IRpDao;
import com.lxd.project2.entity.Rp;
import com.lxd.project2.service.IRpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
