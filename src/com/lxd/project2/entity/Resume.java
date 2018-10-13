package com.lxd.project2.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
public class Resume {
    private int id;
    private String username;
    private String name;
    private int age;
    private String sex;
    private String school;
    private int pnumber;
    private String email;
    private String dept;
    private String position;
    private String salary;
    private String skill;
    private String politics;
    private String experience;
    private Date date;

    public Resume() {
    }

    public Resume(int id, String username, String name, int age, String sex, String school, int pnumber, String email, String dept, String position, String salary, String skill, String politics, String experience, Date date) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.school = school;
        this.pnumber = pnumber;
        this.email = email;
        this.dept = dept;
        this.position = position;
        this.salary = salary;
        this.skill = skill;
        this.politics = politics;
        this.experience = experience;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                ", pnumber=" + pnumber +
                ", email='" + email + '\'' +
                ", dept='" + dept + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                ", skill='" + skill + '\'' +
                ", politics='" + politics + '\'' +
                ", experience='" + experience + '\'' +
                ", date=" + date +
                '}';
    }
}
