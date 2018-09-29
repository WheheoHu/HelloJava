package com.company;

public class Student {
    private int idnumber;
    private int inclass;
    private  String name;
    private  String gender;
    private  int age;

    public int getIdnumber(){
        return idnumber;
    }

    public int getInclass() {
        return inclass;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
