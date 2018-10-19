package com.lxd.project2.dao;

import com.lxd.project2.entity.Salary;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
@Repository
public interface ISalaryDao {
    void add(Salary salary);
}
