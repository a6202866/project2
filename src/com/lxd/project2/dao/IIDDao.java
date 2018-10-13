package com.lxd.project2.dao;

import com.lxd.project2.entity.IID;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
@Repository
public interface IIDDao {
    public void add(IID iid);
    public IID queryByRID(IID iid);
}
