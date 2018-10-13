package com.lxd.project2.test;

import com.lxd.project2.dao.IResumeDao;
import com.lxd.project2.entity.Resume;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Administrator on 2018/10/12 0012.
 */
@Service
public class test {
    @Autowired
    private IResumeDao iResumeDao;
    @Test
    public void aa(){
        System.out.println(iResumeDao);
        System.out.println(iResumeDao.queryByUserName("123"));
    }
}
