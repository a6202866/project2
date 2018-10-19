package com.lxd.project2.service.impl;

import com.lxd.project2.dao.ICheckDao;
import com.lxd.project2.entity.Check;
import com.lxd.project2.service.ICheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/18 0018.
 */
@Transactional
@Service
public class CheckServiceImpl implements ICheckService {
    @Autowired
    private ICheckDao iCheckDao;
    @Override
    public void addOnDuty(Check check) {
        iCheckDao.addOnDuty(check);
    }

    @Override
    public void addOffDuty(Check check) {
        iCheckDao.addOffDuty(check);
    }

    @Override
    public Check queryByOnState(String likeDay) {
        return iCheckDao.queryByOnState(likeDay);
    }

    @Override
    public List<Check> queryByMonth(String date) {
        return iCheckDao.queryByMonth(date);
    }

    @Override
    public List<Check> queryByUsername(String username) {
        return iCheckDao.queryByUsername(username);
    }
}
