package com.lxd.project2.dao;

import com.lxd.project2.entity.Interview;
import com.lxd.project2.entity.Resume;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
@Repository
public interface IInterviewDao {
    public void add(Resume resume);
    public List<Interview> queryAll();
    public Interview queryByName(String name);
    public void deleteByName(String name);
    public void update(String name);
}
