package com.lxd.project2.service;

import com.lxd.project2.entity.Inform;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
public interface IInformService {
    void add(Inform inform);
    List<Inform> queryAll();
    void update();
    List<Inform> queryByUsername(String username);
}
