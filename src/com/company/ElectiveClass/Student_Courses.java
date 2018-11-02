package com.company.ElectiveClass;



public class Student_Courses {
    private String course_no;
    private String stu_no;
    private boolean approved;
    private int score;

    public Student_Courses(String course_no, String stu_no, boolean approved, int score) {
        this.course_no = course_no;
        this.stu_no = stu_no;
        this.approved = approved;
        this.score = score;
    }

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

    public int getScore() {
        return score;
    }

    public String getCourse_no() {
        return course_no;
    }

    public String getStu_no() {
        return stu_no;
    }
}
