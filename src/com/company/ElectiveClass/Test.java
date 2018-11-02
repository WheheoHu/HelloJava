package com.company.ElectiveClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    static List<Courses> coursesList = new ArrayList<Courses>();
    static List<Student> studentList = new ArrayList<Student>();
    static List<Teachers> teachersList = new ArrayList<Teachers>();

    static Courses math = new Courses("1", "math", "PB");
    static Courses forlang = new Courses("2", "forlang", "PB");
    static Courses java = new Courses("3", "java", "CS");

    static Teachers tea1 = new Teachers("0001", "TEA1", "Man", "A");
    static Teachers tea2 = new Teachers("0002", "TEA2", "Man", "B");
    static Teachers tea3 = new Teachers("0003", "TEA3", "Man", "C");

    static void AddStudent() {
        System.out.println("请输入学生信息，用空格分开顺序为 学号 姓名 性别 班级 专业");

            Scanner inputstu=new Scanner(System.in);
            String[] stu_info=inputstu.next().split("\\s+");
        for (int i = 0; i < stu_info.length; i++) {
            System.out.println(stu_info[i]);
        }
           // Student st = new Student(stu_info[0], stu_info[1], stu_info[2], stu_info[3], stu_info[4]);
            //studentList.add(st);
            System.out.println(studentList.size());

    }
    static void InitCourseList() {
        coursesList.add(math);
        coursesList.add(forlang);
        coursesList.add(java);
    }
    static void InitTeacherList() {
        tea1.setCourses(math);
        teachersList.add(tea1);
        tea2.setCourses(forlang);
        teachersList.add(tea2);
        tea3.setCourses(java);
        teachersList.add(tea3);
    }
    static void EleClass(){
        System.out.println(studentList.size());
        for (int i = 0; i <studentList.size(); i++) {
            System.out.println((i+1));
            //+". "+studentList.get(i).getName()+" "+studentList.get(i).getStu_no()
        }
    }
    static private boolean EXIT = false;

    public static void main(String[] args) {
        InitCourseList();
        InitTeacherList();
        Scanner inputindex_num = new Scanner(System.in);
        while (!EXIT) {
            System.out.println("1.添加学生信息（非选课）");
            System.out.println("2.学生选课");
            System.out.println("3.教师系统");
            System.out.println("4.退出");
            int index_num = inputindex_num.nextInt();
            switch (index_num) {
                case 1:
                    AddStudent();
                    break;
                case 2:
                    EleClass();
                    break;
                case 3:

                    break;
                case 4:
                    EXIT = true;
            }
        }
    }
}
