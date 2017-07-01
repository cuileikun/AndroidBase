package com.cuileikun.androidbase.javaactivity.twentyfour.day24_Pattern.itcast_03;

/**
 * 作者：popular cui
 * 时间：2017/7/1 17:52
 * 功能:
 */
public class TeacherDemo {
    public static void main(String[] args) {
        Teacher t1 = Teacher.getTeacher();
        Teacher t2 = Teacher.getTeacher();
        System.out.println(t1 == t2);
        System.out.println(t1); // cn.itcast_03.Teacher@175078b
        System.out.println(t2);// cn.itcast_03.Teacher@175078b
    }
}
