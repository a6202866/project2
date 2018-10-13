package com.lxd.project2.dao;

import com.lxd.project2.entity.Resume;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
@Repository
public interface IResumeDao {
    public void add(Resume resume);
    public Resume queryByUserName(String username);
    public void update(Resume resume);
}
