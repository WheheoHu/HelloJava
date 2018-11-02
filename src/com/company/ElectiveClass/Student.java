package com.company.ElectiveClass;


import java.util.ArrayList;
import java.util.List;

public class Student {
    private String stu_no;
    private String name;
    private String sex;
    private String class_no;
    private String major;

    public Student(String stu_no, String name, String sex, int class_no, String major) {
        this.stu_no = stu_no;
        this.name = name;
        this.sex = sex;
        this.class_no = class_no;
        this.major = major;
    }

    private List<Student_Courses> sc = new ArrayList<Student_Courses>();

    void Select_Course(String course_no) {
        Student_Courses newsc = new Student_Courses(course_no, this.stu_no, false, 0);
        sc.add(newsc);
    }

    void Delete_Course() {
    }

    void Disp_Score() {
        for (int i = 0; i < sc.size(); i++) {
            System.out.println(sc.get(i).getScore());
        }
    }
}
