package com.lxd.project2.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
public class Inform {
    private int id;
    private String name;
    private String address;
    private String position;
    private Date date;
    private String state;

    public Inform() {
    }

    public Inform(int id, String name, String address, String position, Date date, String state) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.position = position;
        this.date = date;
        this.state = state;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Inform{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", date=" + date +
                ", state='" + state + '\'' +
                '}';
    }

    public Inform(String name, String address, String position, Date date, String state) {
        this.name = name;
        this.address = address;
        this.position = position;
        this.date = date;
        this.state = state;
    }

    public Inform(String name, String address, String position, Date date) {
        this.name = name;
        this.address = address;
        this.position = position;
        this.date = date;
    }

    public void setState(String state) {
        this.state = state;
    }
}
