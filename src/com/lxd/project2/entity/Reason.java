package com.lxd.project2.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public class Reason {
    private int id;
    private int Sid;
    private String username;
    private String name;
    private String reason;
    private Date date;

    public Reason() {
    }

    public Reason(int id, int sid, String username, String name, String reason, Date date) {
        this.id = id;
        Sid = sid;
        this.username = username;
        this.name = name;
        this.reason = reason;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reason{" +
                "id=" + id +
                ", Sid=" + Sid +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", reason='" + reason + '\'' +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return Sid;
    }

    public void setSid(int sid) {
        Sid = sid;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
