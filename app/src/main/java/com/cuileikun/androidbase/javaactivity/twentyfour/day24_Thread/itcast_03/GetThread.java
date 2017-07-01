package com.cuileikun.androidbase.javaactivity.twentyfour.day24_Thread.itcast_03;

/**
 * 作者：popular cui
 * 时间：2017/7/1 18:01
 * 功能:
 */
public class GetThread implements Runnable {
    private Student s;

    public GetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        // Student s = new Student();
        System.out.println(s.name + "---" + s.age);
    }

}
