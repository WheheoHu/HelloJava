package com.company.ElectiveClass;

import java.util.ArrayList;
import java.util.List;

public class Student_Courses {
    private String course_no;
    private String stu_no;
    private boolean approved;
    private int score;

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setCourse_no(String course_no) {
        this.course_no = course_no;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStu_no(String stu_no) {
        this.stu_no = stu_no;
    }
}
