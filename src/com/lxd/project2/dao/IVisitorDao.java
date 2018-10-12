package com.lxd.project2.dao;

import com.lxd.project2.entity.Visitor;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
@Repository("VisitorDao")
public interface IVisitorDao {
    public void add(Visitor visitor);
    public Visitor queryByName(String name);
    public Visitor queryByNamePassword(Visitor visitor);
}
