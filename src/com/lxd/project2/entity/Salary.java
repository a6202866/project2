package com.lxd.project2.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
public class Salary {
    private int id;
    private String username;
    private String name;
    private double allSalary;
    private double basicSalary;
    private double pSalary;
    private double overtimeSalary;
    private double checkSalry;
    private double socialSalary;
    private String date;
    public Salary() {
    }

    public Salary(int id, String username, String name, double allSalary, double basicSalary, double pSalary, double overtimeSalary, double checkSalry, double socialSalary, String date) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.allSalary = allSalary;
        this.basicSalary = basicSalary;
        this.pSalary = pSalary;
        this.overtimeSalary = overtimeSalary;
        this.checkSalry = checkSalry;
        this.socialSalary = socialSalary;
        this.date = date;
    }

    public Salary(String username, String name, double allSalary, double basicSalary, double pSalary, double overtimeSalary, double checkSalry, double socialSalary, String date) {
        this.username = username;
        this.name = name;
        this.allSalary = allSalary;
        this.basicSalary = basicSalary;
        this.pSalary = pSalary;
        this.overtimeSalary = overtimeSalary;
        this.checkSalry = checkSalry;
        this.socialSalary = socialSalary;
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

    public double getAllSalary() {
        return allSalary;
    }

    public void setAllSalary(double allSalary) {
        this.allSalary = allSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getpSalary() {
        return pSalary;
    }

    public void setpSalary(double pSalary) {
        this.pSalary = pSalary;
    }

    public double getOvertimeSalary() {
        return overtimeSalary;
    }

    public void setOvertimeSalary(double overtimeSalary) {
        this.overtimeSalary = overtimeSalary;
    }

    public double getCheckSalry() {
        return checkSalry;
    }

    public void setCheckSalry(double checkSalry) {
        this.checkSalry = checkSalry;
    }

    public double getSocialSalary() {
        return socialSalary;
    }

    public void setSocialSalary(double socialSalary) {
        this.socialSalary = socialSalary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", allSalary=" + allSalary +
                ", basicSalary=" + basicSalary +
                ", pSalary=" + pSalary +
                ", overtimeSalary=" + overtimeSalary +
                ", checkSalry=" + checkSalry +
                ", socialSalary=" + socialSalary +
                ", date='" + date + '\'' +
                '}';
    }
}
