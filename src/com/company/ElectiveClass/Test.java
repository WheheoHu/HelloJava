package com.company.ElectiveClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    static List<Courses> coursesList=new ArrayList<Courses>();
    static List<Student> studentList=new ArrayList<Student>();
    static List<Teachers> teachersList=new ArrayList<Teachers>();

    static Courses math=new Courses("1","math","PB");
    static Courses forlang=new Courses("2","forlang","PB");
    static Courses java=new Courses("3","java","CS");

    static Teachers tea1=new Teachers("0001","TEA1","Man","A");
    static Teachers tea2=new Teachers("0002","TEA2","Man","B");
    static Teachers tea3=new Teachers("0003","TEA3","Man","C");

    static void AddStudent() {
        System.out.println("请输入学生信息，用空格分开顺序为 学号 姓名 性别 班级 专业");
        try {
            BufferedReader inputstudent=new BufferedReader(new InputStreamReader(System.in));
            String[] stu_info=inputstudent.readLine().split("\\s+");
            Student st=new Student(stu_info[0], stu_info[1], stu_info[2], stu_info[3], stu_info[4]);
            studentList.add(st);
            inputstudent.close();
        }
        catch(Exception e){}finally {

        }

    }

    static void InitCourseList(){
        coursesList.add(math);
        coursesList.add(forlang);
        coursesList.add(java);
    }

    static void InitTeacherList(){
        tea1.setCourses(math);
        teachersList.add(tea1);
        tea2.setCourses(forlang);
        teachersList.add(tea2);
        tea3.setCourses(java);
        teachersList.add(tea3);
    }

    public static void main(String[] args) {
        InitCourseList();
        InitTeacherList();

    }
}
