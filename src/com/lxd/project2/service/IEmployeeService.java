package com.lxd.project2.service;

import com.lxd.project2.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/16 0016.
 */

public interface IEmployeeService {
    void add(Employee employee);
    List<Employee> queryAll();
    List<Employee> queryByState(String state);
    Employee queryByID(int id);
    void changeEmp(Employee employee);
    void deleteById(int id);
    Employee queryByUsername(String username);
    void updateEmp(Employee employee);
    List<String> queryByDept(String dept);
}
