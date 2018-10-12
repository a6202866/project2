package com.lxd.project2.entity;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
public class Dept {
    private int id;
    private String dept;

    public Dept() {
    }

    public Dept(int id, String dept) {
        this.id = id;
        this.dept = dept;
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
                '}';
    }
}
