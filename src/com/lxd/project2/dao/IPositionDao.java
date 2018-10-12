package com.lxd.project2.dao;

import com.lxd.project2.entity.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
@Repository
public interface IPositionDao {
    public List<Position> queryAll();
    public List<Position> queryByDept(String dept);
}
