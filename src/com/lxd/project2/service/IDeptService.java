package com.lxd.project2.service;

import com.lxd.project2.entity.Dept;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
public interface IDeptService {
    public List<Dept> queryAll();
    public Dept queryByDept(String dept);
    public void add(String dept);
    public void changeDept(String dept1,String dept2);
}
