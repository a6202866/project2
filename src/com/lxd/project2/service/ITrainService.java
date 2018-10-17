package com.lxd.project2.service;

import com.lxd.project2.entity.Train;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/17 0017.
 */

public interface ITrainService {
    void add(Train train);
    List<Train> queryByDept(String dept);
    List<Train> queryAll();
    void delByID(int id);
    void update(Train train);
}
