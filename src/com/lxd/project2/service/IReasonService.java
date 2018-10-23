package com.lxd.project2.service;

import com.lxd.project2.entity.Reason;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface IReasonService {
    void add(Reason reason);
    List<Reason> queryAll();
    void deleteById(int id);
}
