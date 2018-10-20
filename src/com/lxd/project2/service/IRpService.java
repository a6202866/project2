package com.lxd.project2.service;

import com.lxd.project2.entity.Rp;

import java.util.List;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
public interface IRpService {
    void add(Rp rp);
    List<Rp> queryAll();
    List<Rp> queryByDate(String date);
    void deleteById(int id);
    Rp queryById(int id);
    void changeRp(Rp rp);
    List<Rp> queryByUsername(String username);
    List<Rp> queryByDateUsername(String username,String date);
}
