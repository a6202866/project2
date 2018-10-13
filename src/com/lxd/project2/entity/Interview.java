package com.lxd.project2.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
public class Interview {
    private int id;
    private String name;
    private String username;
    private Date date;
    private String look;
    private String interview;

    public Interview() {
    }

    public Interview(int id, String name, String username, Date date, String look, String interview) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.date = date;
        this.look = look;
        this.interview = interview;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", date=" + date +
                ", look='" + look + '\'' +
                ", interview='" + interview + '\'' +
                '}';
    }
}
