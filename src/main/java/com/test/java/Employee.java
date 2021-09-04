package com.test.java;

import java.util.List;

public class Employee {

    int id;
    List<String> phoneNumber;
    int managerId;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Employee(int i, List<String> list, int managerId) {
        this.id = i;
        this.phoneNumber = list;
        this.managerId = managerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
