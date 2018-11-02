package com.company.ElectiveClass;

import java.util.ArrayList;
import java.util.List;

public class Courses {
    private String course_no;
    private String course_name;
    private String major;

    public Courses(String course_no, String course_name, String major) {
        this.course_no = course_no;
        this.course_name = course_name;
        this.major = major;
    }

    private List<Student> course_students=new ArrayList<Student>();

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_no() {
        return course_no;
    }

    public String getMajor() {
        return major;
    }

    void AddStudent(Student student) {
        course_students.add(student);
    }

    void RemoveStudent(Student student) {
        course_students.remove(student);
    }

    void setStu_Score(Student stu){

    }

}
