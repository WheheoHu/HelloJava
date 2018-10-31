package com.company.ElectiveClass;

import java.util.ArrayList;
import java.util.List;

public class Courses {
    private String course_no;
    private String course_name;
    private String major;
    private List Course_Students = new ArrayList();

    void AddStudent(Student student){
        Course_Students.add(student);
    }
    void RemoveStudent(Student student){
        Course_Students.remove(student);
    }
}
