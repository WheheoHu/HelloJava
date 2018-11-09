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

    void Approve_Course(Student student) {
        for (int i = 0; i < student.sc.size(); i++) {
            if (student.sc.get(i).getStu_no().equals(student.getStu_no())) {
                student.sc.get(i).setApproved(true);
                break;
            }
        }
        courses.AddStudent(student);
    }

    void Score_Course(Student student, int score) {
        for (int i = 0; i < student.sc.size(); i++) {
            if (student.sc.get(i).getStu_no() == student.getStu_no()) {
                student.sc.get(i).setScore(score);
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getCoursesName() {
        return courses.getCourse_name();
    }

    public String getTeacher_no() {
        return teacher_no;
    }

    public String getDepartment() {
        return department;
    }

    public String getSex() {
        return sex;
    }

    public Courses getCourses() {
        return courses;
    }
}
