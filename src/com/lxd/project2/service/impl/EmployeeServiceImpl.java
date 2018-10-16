package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IEmployeeDao;
import com.lxd.project2.entity.Employee;
import com.lxd.project2.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/10/16 0016.
 */
@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeDao iEmployeeDao;
    @Override
    public void add(Employee employee) {
        iEmployeeDao.add(employee);
    }
}
