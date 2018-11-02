package com.company.ElectiveClass;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static List<Courses> coursesList=new ArrayList<Courses>();
    static List<Student> studentList=new ArrayList<Student>();
    static List<Teachers> teachersList=new ArrayList<Teachers>();
    void AddStudent(String stu_no,String name,String sex,int class_no,String major){
        Student st1=new Student(stu_no, name, sex, class_no, major);
        studentList.add(st1);
    }

    public static void main(String[] args) {

    }
}
