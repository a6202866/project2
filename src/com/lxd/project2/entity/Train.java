package com.lxd.project2.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/17 0017.
 */
public class Train {
    private int id;
    private String name;
    private Date date;
    private String dept;

    public Train() {
    }

    public Train(int id, String name, Date date, String dept) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", dept='" + dept + '\'' +
                '}';
    }
}
