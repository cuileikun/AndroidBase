package com.cuileikun.androidbase.javaactivity.twentyfour.day24_Pattern.itcast_03;

/**
 * 作者：popular cui
 * 时间：2017/7/1 16:49
 * 功能:
 */
public class Student {
    // 构造私有
    private Student() {
    }

    // 自己造一个
    // 静态方法只能访问静态成员变量，加静态
    // 为了不让外界直接访问修改这个值，加private
    private static Student s = new Student();

    // 提供公共的访问方式
    // 为了保证外界能够直接使用该方法，加静态
    public static Student getStudent() {
        return s;
    }
}
