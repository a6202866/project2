package com.lxd.project2.service;

import com.lxd.project2.entity.Interview;
import com.lxd.project2.entity.Resume;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
public interface IInterviewService {
    public void add(Resume resume);
    public List<Interview> queryAll();
    public Interview queryByName(String username);
    public void deleteByName(String username);
    public void update(String username);
    public void updatein(int id);
    Interview queryByID(int id);
}
