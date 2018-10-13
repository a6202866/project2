package com.lxd.project2.dao;

import com.lxd.project2.entity.Recruit;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
@Repository
public interface IRecruitDao {
    public void add(Recruit recruit);
    public List<Recruit> queryAll();
    Recruit queryByID(int id);
}
