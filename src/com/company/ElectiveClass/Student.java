package com.company.ElectiveClass;

import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String stu_no;
    private String name;
    private String sex;
    private String class_no;
    private String major;
    private List sc=new ArrayList();
    void Select_Course(Student_Courses student_courses){
        sc.add( student_courses);
    }
    void Delete_Course(Courses courses){
    }
    void Disp_Score(){

    }
}
