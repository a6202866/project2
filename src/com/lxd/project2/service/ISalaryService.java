package com.lxd.project2.service;

import com.lxd.project2.entity.Salary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
public interface ISalaryService {
    void add(Salary salary);
    List<Salary> qeuryByDate(String date);
    List<Salary> queryByUsername(String username);
    void add1(Salary salary);
    List<Salary> queryAll();
}
