package com.lxd.project2.entity;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
public class Recruit {
    private int id;
    private String name;
    private String address;
    private String dept;
    private String position;
    private String salary;

    public Recruit() {
    }

    public Recruit(int id, String name, String address, String dept, String position, String salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dept = dept;
        this.position = position;
        this.salary = salary;
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

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dept='" + dept + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
