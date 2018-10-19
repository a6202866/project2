package com.lxd.project2.service.impl;

import com.lxd.project2.dao.ISalaryDao;
import com.lxd.project2.entity.Salary;
import com.lxd.project2.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
