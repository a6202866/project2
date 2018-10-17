package com.lxd.project2.dao;

import com.lxd.project2.entity.Train;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/10/17 0017.
 */
@Repository
public interface ITrainDao {
    void add(Train train);
    List<Train> queryByDept(String dept);
    List<Train> queryAll();
    void delByID(int id);
    void update(Train train);
}
