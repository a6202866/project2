package com.lxd.project2.dao;

import com.lxd.project2.entity.Reason;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Repository
public interface IReasonDao {
    void add(Reason reason);
    List<Reason> queryAll();
    void deleteById(int id);
}
