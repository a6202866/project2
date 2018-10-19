package com.lxd.project2.service;

import com.lxd.project2.entity.Salary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
public interface ISalaryService {
    void add(Salary salary);
}
