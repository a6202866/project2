package com.lxd.project2.service;

import com.lxd.project2.entity.Position;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
public interface IPositionService {
    List<Position> queryAll();
    public List<Position> queryByDept(String dept);
    public void add(Position position);
    public void changePosition(Position position);
    void deletePosition(Position position);
    void changeP(String dept,String dept1);
}
