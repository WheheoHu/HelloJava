package com.company;

public class TestPerson {
    public static void main(String[] args) {
        Director Dir=new Director("AAAA",'N',111,100,10,12323,"train station");
        System.out.println(Dir.getTelephone());
        System.out.println(Dir.getSalary());
        Dir.upSalary(12,100);
        System.out.println(Dir.getSalary());
    }
}
