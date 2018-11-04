package com.company.ElectiveClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static List<Courses> coursesList = new ArrayList<>();
    private static List<Student> studentList = new ArrayList<>();
    private static List<Teachers> teachersList = new ArrayList<>();

    private static Courses math = new Courses("1", "math", "PB");
    private static Courses forlang = new Courses("2", "forlang", "PB");
    private static Courses java = new Courses("3", "java", "CS");

    private static Teachers tea1 = new Teachers("0001", "TEA1", "Man", "A");
    private static Teachers tea2 = new Teachers("0002", "TEA2", "Man", "B");
    private static Teachers tea3 = new Teachers("0003", "TEA3", "Man", "C");

    private static void AddStudent() {
        System.out.println("请输入学生信息，用空格分开顺序为 学号 姓名 性别 班级 专业");

        Scanner inputstu = new Scanner(System.in);
        String[] stu_info = inputstu.nextLine().split("\\s+");
        Student st = new Student(stu_info[0], stu_info[1], stu_info[2], stu_info[3], stu_info[4]);
        studentList.add(st);

    }

    private static void InitCourseList() {
        coursesList.add(math);
        coursesList.add(forlang);
        coursesList.add(java);
    }

    private static void InitTeacherList() {
        tea1.setCourses(math);
        teachersList.add(tea1);
        tea2.setCourses(forlang);
        teachersList.add(tea2);
        tea3.setCourses(java);
        teachersList.add(tea3);
    }

    private static void EleClass() {
        System.out.println("请输入学生序号");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + ". 姓名:" + studentList.get(i).getName() + " 学号:" + studentList.get(i).getStu_no());
        }
        Scanner inputindex = new Scanner(System.in);
        int index = inputindex.nextInt();
        while (index > studentList.size() || index < 1) {
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println((i + 1) + ". 姓名:" + studentList.get(i).getName() + " 学号:" + studentList.get(i).getStu_no());
            }
            System.out.println("序号非法重新输入序号：");
            Scanner reinput = new Scanner(System.in);
            index = reinput.nextInt();
        }

        Student stu = studentList.get(index - 1);
        boolean EXIT = false;
        while (!EXIT) {
            System.out.println("选择操作：");
            System.out.println("1.添加课程");
            System.out.println("2.删除课程");
            System.out.println("3.显示成绩");
            System.out.println("4.返回上级");
            int stuop_int = new Scanner(System.in).nextInt();
            switch (stuop_int) {
                case 1:
                    System.out.println("输入课程编码：");
                    for (int i = 0; i < coursesList.size(); i++) {
                        System.out.println(coursesList.get(i).getCourse_no() + " " + coursesList.get(i).getCourse_name());
                    }
                    String class_no_add = new Scanner(System.in).next();
                    stu.Select_Course(class_no_add);
                    break;
                case 2:
                    if (stu.sc.size() == 0) {
                        System.out.println("\n未选课\n");
                        break;
                    }
                    System.out.println("输入课程编码：");
                    for (int i = 0; i < stu.sc.size(); i++) {
                        System.out.println("课程编码:" + stu.sc.get(i).getCourse_no());
                    }
                    String class_no_del = new Scanner(System.in).next();
                    stu.Delete_Course(class_no_del);
                    break;
                case 3:
                    stu.Disp_Score();
                    break;
                case 4:
                    EXIT = true;
                    break;
            }
        }
    }

    private static void TeacherClass() {
        System.out.println("输入教师序号：");
        for (int i = 0; i < teachersList.size(); i++) {
            Teachers temp = teachersList.get(i);
            System.out.println((i + 1) + ".  No:" + temp.getTeacher_no() + " Name:" + temp.getName() + " Course:" + temp.getCoursesName());
        }
        int teacher_index = new Scanner(System.in).nextInt();
        Teachers teachers = teachersList.get(teacher_index - 1);
        boolean EXIT = false;
        while (!EXIT) {
            System.out.println("1.批准选课");
            System.out.println("2.打分");
            System.out.println("3.返回上级");
            int teacher_op = new Scanner(System.in).nextInt();
            switch (teacher_op) {
                case 1:
                    System.out.println("输入批准的学生编号:");

                    Student student = studentList.get(new Scanner(System.in).nextInt() - 1);
                    teachers.Approve_Course(student);
                    break;
                case 2:

                    break;
                case 3:
                    EXIT = true;
                    break;
            }
        }

    }

    static private boolean EXIT = false;

    public static void main(String[] args) {
        InitCourseList();
        InitTeacherList();
        while (!EXIT) {
            System.out.println("1.添加学生信息（非选课）");
            System.out.println("2.学生选课系统");
            System.out.println("3.教师系统");
            System.out.println("4.退出");
            int index_num = new Scanner(System.in).nextInt();
            switch (index_num) {
                case 1:
                    AddStudent();
                    break;
                case 2:
                    EleClass();
                    break;
                case 3:
                    TeacherClass();
                    break;
                case 4:
                    EXIT = true;
            }
        }
    }
}
