package com.lxd.project2.service.impl;

import com.lxd.project2.dao.ISalaryDao;
import com.lxd.project2.entity.Salary;
import com.lxd.project2.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
@Transactional
@Service
public class SalaryServiceImpl implements ISalaryService{
    @Autowired
    private ISalaryDao iSalaryDao;
    @Override
    public void add(Salary salary) {
        iSalaryDao.add(salary);
    }

    @Override
    public List<Salary> qeuryByDate(String date) {
        return iSalaryDao.qeuryByDate(date);
    }

    @Override
    public List<Salary> queryByUsername(String username) {
        return iSalaryDao.queryByUsername(username);
    }

    @Override
    public void add1(Salary salary) {
        iSalaryDao.add1(salary);
    }

    @Override
    public List<Salary> queryAll() {
        return iSalaryDao.queryAll();
    }
}
