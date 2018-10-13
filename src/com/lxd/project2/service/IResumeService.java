package com.lxd.project2.service;

import com.lxd.project2.entity.Resume;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
public interface IResumeService {
    void add(Resume resume);
    Resume queryByUserName(String name);
    public void update(Resume resume);
}
