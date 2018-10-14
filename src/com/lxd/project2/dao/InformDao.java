package com.lxd.project2.dao;

import com.lxd.project2.entity.Inform;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
@Repository
public interface InformDao {
    void add(Inform inform);
    List<Inform> queryAll();
    void update();
}
