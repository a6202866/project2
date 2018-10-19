package com.lxd.project2.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
public class Rp {
    private int id;
    private String username;
    private String name;
    private double price;
    private String cause;
    private Date date;

    public Rp() {
    }

    public Rp(int id, String username, String name, double price, String cause, Date date) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.price = price;
        this.cause = cause;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCause() {
        return cause;
    }

    public Rp(String username, String name, double price, String cause, Date date) {
        this.username = username;
        this.name = name;
        this.price = price;
        this.cause = cause;
        this.date = date;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Rp{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cause='" + cause + '\'' +
                ", date=" + date +
                '}';
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
