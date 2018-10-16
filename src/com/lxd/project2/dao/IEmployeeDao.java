package com.lxd.project2.dao;

import com.lxd.project2.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/10/16 0016.
 */
@Repository
public interface IEmployeeDao {
    void add(Employee employee);
}
