package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IEmployeeDao;
import com.lxd.project2.entity.Employee;
import com.lxd.project2.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Employee> queryAll() {
        return iEmployeeDao.queryAll();
    }

    @Override
    public List<Employee> queryByState(String state) {
        return iEmployeeDao.queryByState(state);
    }

    @Override
    public Employee queryByID(int id) {
        return iEmployeeDao.queryByID(id);
    }

    @Override
    public void changeEmp(Employee employee) {
        iEmployeeDao.changeEmp(employee);
    }

    @Override
    public void deleteById(int id) {
        iEmployeeDao.deleteById(id);
    }

    @Override
    public Employee queryByUsername(String username) {
        return iEmployeeDao.queryByUsername(username);
    }

    @Override
    public void updateEmp(Employee employee) {
        iEmployeeDao.updateEmp(employee);
    }

    @Override
    public List<String> queryByDept(String dept) {
        return iEmployeeDao.queryByDept(dept);
    }
}
