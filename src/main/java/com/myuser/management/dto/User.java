package com.myuser.management.dto;

public class User {
    String name;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public User(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    int rollNo;

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }
}
