package com.lxd.project2.dao;

import com.lxd.project2.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
@Repository
public interface IDeptDao {
    public List<Dept> queryAll();
}
