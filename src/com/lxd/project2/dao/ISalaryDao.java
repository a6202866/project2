package com.lxd.project2.dao;

import com.lxd.project2.entity.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
@Repository
public interface ISalaryDao {
    void add(Salary salary);
    List<Salary> qeuryByDate(String date);
    List<Salary> queryByUsername(String username);
    void add1(Salary salary);
    List<Salary> queryAll();
}
