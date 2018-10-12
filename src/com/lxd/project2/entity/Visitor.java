package com.lxd.project2.entity;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
public class Visitor {
    private int id;
    private String name;
    private String password;
    private int cls;

    public Visitor() {
    }

    public Visitor(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Visitor(int id, String name, String password, int cls) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.cls = cls;
    }

    public Visitor(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCls() {
        return cls;
    }

    public void setCls(int cls) {
        this.cls = cls;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", cls=" + cls +
                '}';
    }
}
