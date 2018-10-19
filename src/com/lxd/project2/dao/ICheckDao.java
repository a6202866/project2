package com.lxd.project2.dao;

import com.lxd.project2.entity.Check;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/10/18 0018.
 */
@Repository
public interface ICheckDao {
    void addOnDuty(Check check);
    void addOffDuty(Check check);
    Check queryByOnState(String likeDay);
    List<Check> queryByMonth(String date);
    List<Check> queryByUsername(String username);
}
