package com.lxd.project2.service;

import com.lxd.project2.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/10/16 0016.
 */

public interface IEmployeeService {
    void add(Employee employee);
}
