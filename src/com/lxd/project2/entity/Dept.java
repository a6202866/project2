package com.lxd.project2.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
public class Dept {
    private int id;
    private String dept;
    private Date date;
    public Dept() {
    }

    public Dept(int id, String dept, Date date) {
        this.id = id;
        this.dept = dept;
        this.date = date;
    }

    public Dept(String dept, Date date) {
        this.dept = dept;
        this.date = date;
    }

    public Dept(int id, String dept) {
        this.id = id;
        this.dept = dept;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", dept='" + dept + '\'' +
                ", date=" + date +
                '}';
    }
}
