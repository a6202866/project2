package com.lxd.project2.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/16 0016.
 */
public class Employee {
    private int id;
    private String username;
    private String name;
    private String sex;
    private int age;
    private String school;
    private int pnumber;
    private String email;
    private Date date;
    private String dept;
    private String position;
    private String state;

    public Employee(String username, String name, String sex, int age, String school, int pnumber, String email, Date date, String dept, String position) {
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.school = school;
        this.pnumber = pnumber;
        this.email = email;
        this.date = date;
        this.dept = dept;
        this.position = position;
    }

    public Employee() {
    }

    public Employee(int id, String username, String name, String sex, int age, String school, int pnumber, String email, Date date, String dept, String position, String state) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.school = school;
        this.pnumber = pnumber;
        this.email = email;
        this.date = date;
        this.dept = dept;
        this.position = position;
        this.state = state;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getPnumber() {
        return pnumber;
    }

    public void setPnumber(int pnumber) {
        this.pnumber = pnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Employee(String username, String name, String sex, int age, String school, int pnumber, String email, Date date, String dept, String position, String state) {
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.school = school;
        this.pnumber = pnumber;
        this.email = email;
        this.date = date;
        this.dept = dept;
        this.position = position;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", pnumber=" + pnumber +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", dept='" + dept + '\'' +
                ", position='" + position + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
