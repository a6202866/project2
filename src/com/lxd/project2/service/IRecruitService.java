package com.lxd.project2.service;

import com.lxd.project2.entity.Recruit;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
public interface IRecruitService {
    void add(Recruit recruit);
    public List<Recruit> queryAll();
    Recruit queryByID(int id);
}
