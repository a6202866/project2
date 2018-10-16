package com.lxd.project2.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
public class Position {
    private int id;
    private String dept;
    private String position;
    private Date date;
    public Position() {
    }

    public Position(String dept, String position, Date date) {
        this.dept = dept;
        this.position = position;
        this.date = date;
    }

    public Position(String dept) {
        this.dept = dept;
    }

    public Position(int id, String dept) {
        this.id = id;
        this.dept = dept;
    }

    public Position(String dept, String position) {
        this.dept = dept;
        this.position = position;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Position(int id, String dept, String position) {
        this.id = id;
        this.dept = dept;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", dept='" + dept + '\'' +
                ", position='" + position + '\'' +
                ", date=" + date +
                '}';
    }
}
