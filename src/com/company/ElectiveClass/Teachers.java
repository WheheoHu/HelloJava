package com.company.ElectiveClass;


public class Teachers {
    private String teacher_no;
    private String name;
    private String sex;
    private String department;

    public Teachers(String teacher_no, String name, String sex, String department) {
        this.teacher_no = teacher_no;
        this.name = name;
        this.sex = sex;
        this.department = department;
    }

    void Approve_Course(Student_Courses student_courses) {
        student_courses.setApproved(true);
        for (int i = 0; i < Test.coursesList.size(); i++) {
            if (Test.coursesList.get(i).getCourse_no()==student_courses.getCourse_no()){

                break;
            }
        }
    }

    void Score_Course() {

    }

}
