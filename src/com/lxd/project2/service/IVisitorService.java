package com.lxd.project2.service;

import com.lxd.project2.entity.Visitor;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
public interface IVisitorService {
    public void add(Visitor visitor);
    public Visitor queryByName(String name);
    public void regist(Visitor visitor);
    public Visitor queryByNamePassword(Visitor visitor);
    public void changePassword(Visitor visitor);
    public void changeVisitorCls2(String name);
}
