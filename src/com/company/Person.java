package com.company;

public abstract class Person {
    private String name;
    private char sex;

    public Person(String name, char sex) {
        this.name = name;
        this.sex = sex;
    }

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

    public Customer(String name, char sex, int custno) {
        super(name, sex);
        this.custno = custno;
    }

    @Override
    String getINFO() {
     return getName()+getSex()+custno;
    }
}
class Employee extends Person{
    static int c_minSalary;
    private int age;
    private int salary;

    public Employee(String name, char sex, int age, int salary) {
        super(name, sex);
        this.age = age;
        this.salary = salary;
    }

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

    public VipCust(String name, char sex, int custno, int vipno) {
        super(name, sex, custno);
        this.vipno = vipno;
    }

    @Override
    String getINFO() {
        return super.getINFO()+c_vno+vipno;
    }
}


final  class Engineer extends Employee{

    private String title;

    public Engineer(String name, char sex, int age, int salary, String title) {
        super(name, sex, age, salary);
        this.title = title;
    }

    @Override
    String getINFO() {
        return super.getINFO()+title;
    }
}

final class Secretary extends Employee{

    private String office;

    public Secretary(String name, char sex, int age, int salary, String office) {
        super(name, sex, age, salary);
        this.office = office;
    }

    @Override
    String getINFO() {
        return super.getINFO()+office;
    }
}

class Manager extends Employee{

    private int allowance;

    public Manager(String name, char sex, int age, int salary, int allowance) {
        super(name, sex, age, salary);
        this.allowance = allowance;
    }

    final int upSalary(int inc1, int inc2){return getSalary()+inc1+inc2;
    }

    @Override
    String getINFO() {
        return super.getINFO()+allowance;
    }
}

final  class Director extends Manager{
    private int telephone;
    private  String department;

    public Director(String name, char sex, int age, int salary, int allowance, int telephone, String department) {
        super(name, sex, age, salary, allowance);
        this.telephone = telephone;
        this.department = department;
    }
    
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