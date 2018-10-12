package com.company;

public abstract class Person {
    private String name;
    private char sex;

    final char getSex() {
        return sex;
    }

    final String getName() {
        return name;
    }
    abstract String getINFO();
}

class Customer extends Person{
    private int custno;

    @Override
    String getINFO() {
     return getName()+getSex()+custno;
    }
}
class Employee extends Person{
    static int c_minSalary;
    private int age;
    private int salary;
    final void upSalary(int inc){
        salary+=inc;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    String getINFO() {
        return getName()+c_minSalary+age+salary;
    }
}
final class VipCust extends Customer{
    static int c_vno;
    private int vipno;

    @Override
    String getINFO() {
        return super.getINFO()+c_vno+vipno;
    }
}


final  class Engineer extends Employee{

    private String title;

    @Override
    String getINFO() {
        return super.getINFO()+title;
    }
}

final class Secretary extends Employee{

    private String office;

    @Override
    String getINFO() {
        return super.getINFO()+office;
    }
}

class Manager extends Employee{

    private int allowance;
    final int upSalary(int inc1,int inc2){return getSalary()+inc1+inc2;
    }

    @Override
    String getINFO() {
        return super.getINFO()+allowance;
    }
}

final  class Director extends Manager{
    private int telephone;
    private  String department;

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getTelephone() {
        return telephone;
    }

    @Override
    String getINFO() {
        return super.getINFO()+telephone+department;
    }
}