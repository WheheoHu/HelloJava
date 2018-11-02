package com.company.ElectiveClass;


public class Teachers {
    private String teacher_no;
    private String name;
    private String sex;
    private String department;
    private Courses courses;
    public Teachers(String teacher_no, String name, String sex, String department) {
        this.teacher_no = teacher_no;
        this.name = name;
        this.sex = sex;
        this.department = department;
    }
    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    void Approve_Course(Student student,boolean approved) {
        for (int i = 0; i < student.sc.size(); i++) {
            if (student.sc.get(i).getStu_no()==student.getStu_no()){
                student.sc.get(i).setApproved(approved);
                break;
            }
        }
        courses.AddStudent(student);
    }

    void Score_Course(Student student,int score) {
        for (int i = 0; i < student.sc.size(); i++) {
            if (student.sc.get(i).getStu_no()==student.getStu_no()){
                student.sc.get(i).setScore(score);
                break;
            }
        }
    }

}
