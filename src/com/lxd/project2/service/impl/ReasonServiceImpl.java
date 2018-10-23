package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IReasonDao;
import com.lxd.project2.entity.Reason;
import com.lxd.project2.service.IReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Transactional
@Service
public class ReasonServiceImpl implements IReasonService {
    @Autowired
    private IReasonDao iReasonDao;
    @Override
    public void add(Reason reason) {
        iReasonDao.add(reason);
    }

    @Override
    public List<Reason> queryAll() {
        return iReasonDao.queryAll();
    }

    @Override
    public void deleteById(int id) {
        iReasonDao.deleteById(id);
    }
}
