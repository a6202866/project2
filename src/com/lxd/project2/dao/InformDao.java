package com.lxd.project2.dao;

import com.lxd.project2.entity.Inform;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
@Repository
public interface InformDao {
    void add(Inform inform);
}
