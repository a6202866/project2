package com.lxd.project2.test;

import com.lxd.project2.dao.IEmployeeDao;
import com.lxd.project2.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Test
    public void aaa() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String d1 = sdf.format(date);
        Date time = sdf.parse("1:00:00");
        Date time1 = sdf.parse("2:00:00");
        Date time2 = sdf.parse("3:00:00");
        Date time3 = sdf.parse("4:00:00");
        Date time4 = sdf.parse("5:00:00");
        Date time5 = sdf.parse("6:00:00");
        Date time6 = sdf.parse("7:00:00");
        Date time7 = sdf.parse("8:00:00");
        Date time8 = sdf.parse("9:00:00");
        System.out.println(time.getTime());
        System.out.println(time1.getTime());
        System.out.println(time2.getTime());
        System.out.println(time3.getTime());
        System.out.println(time4.getTime());
        System.out.println(time5.getTime());
        System.out.println(time6.getTime());
        System.out.println(time7.getTime());
        System.out.println(time8.getTime());


    }
}
