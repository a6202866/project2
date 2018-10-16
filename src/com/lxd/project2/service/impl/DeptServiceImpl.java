package com.lxd.project2.service.impl;

import com.lxd.project2.dao.IDeptDao;
import com.lxd.project2.entity.Dept;
import com.lxd.project2.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
@Transactional
@Service
public class DeptServiceImpl implements IDeptService{
    @Autowired
    private IDeptDao iDeptDao;
    @Override
    public List<Dept> queryAll() {
        return iDeptDao.queryAll();
    }

    @Override
    public Dept queryByDept(String dept) {
        return iDeptDao.queryByDept(dept);
    }

    @Override
    public void add(Dept dept) {
        iDeptDao.add(dept);
    }

    @Override
    public void changeDept(String dept1,String dept2) {
        iDeptDao.changeDept(dept1,dept2);
    }

    @Override
    public void deleteByDept(String dept) {
        iDeptDao.deleteByDept(dept);
    }
}
