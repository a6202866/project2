package com.lxd.project2.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/18 0018.
 */
public class Check {
    private int id;
    private String username;
    private String name;
    private Date onduty;
    private Date offduty;
    private String ondutystate;
    private String offdutystate;

    public Check() {
    }

    public Check(int id, String username, String name, Date onduty, Date offduty, String ondutystate, String offdutystate) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.onduty = onduty;
        this.offduty = offduty;
        this.ondutystate = ondutystate;
        this.offdutystate = offdutystate;
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

    public Date getOnduty() {
        return onduty;
    }

    public void setOnduty(Date onduty) {
        this.onduty = onduty;
    }

    public Date getOffduty() {
        return offduty;
    }

    public void setOffduty(Date offduty) {
        this.offduty = offduty;
    }

    public String getOndutystate() {
        return ondutystate;
    }

    public void setOndutystate(String ondutystate) {
        this.ondutystate = ondutystate;
    }

    public String getOffdutystate() {
        return offdutystate;
    }

    public void setOffdutystate(String offdutystate) {
        this.offdutystate = offdutystate;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", onduty=" + onduty +
                ", offduty=" + offduty +
                ", ondutystate='" + ondutystate + '\'' +
                ", offdutystate='" + offdutystate + '\'' +
                '}';
    }
}
