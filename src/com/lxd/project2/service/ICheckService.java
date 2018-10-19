package com.lxd.project2.service;

import com.lxd.project2.entity.Check;

import java.util.List;

/**
 * Created by Administrator on 2018/10/18 0018.
 */
public interface ICheckService {
    void addOnDuty(Check check);
    void addOffDuty(Check check);
    Check queryByOnState(String likeDay);
    List<Check> queryByMonth(String date);
    List<Check> queryByUsername(String username);
}
