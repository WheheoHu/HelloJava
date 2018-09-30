package com.company;

public class Test {
    public static void main(String[] args) {
        Student S_class=new Student(2333,213,404,"fool","unknown");
        System.out.println(S_class.toString());
    }
}


class Student {
    private int idnumber;
    private int inclass;
    private  String name;
    private  String gender;
    private  int age;
    private  String allimfor;
    Student(){}
    Student(int idnumber, int inclass, int age, String name, String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.idnumber=idnumber;
        this.inclass=inclass;
    }
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
    public String toString(){
        allimfor="gender:"+this.gender+" class:"+this.inclass+" idnumber:"+this.idnumber+" age:"+this.age+" name:"+this.name;
        return allimfor;
    }
}