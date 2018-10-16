package com.lxd.project2.test;

import com.lxd.project2.dao.IEmployeeDao;
import com.lxd.project2.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


/**
 * Created by Administrator on 2018/10/12 0012.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class test {

    @Autowired
    private IEmployeeDao iEmployeeDao;
    @Test
    public void aa(){
        Employee employee = new Employee("1","1","1",1,"1",1,"1",new Date(),"1","1");
        iEmployeeDao.add(employee);
    }
}
