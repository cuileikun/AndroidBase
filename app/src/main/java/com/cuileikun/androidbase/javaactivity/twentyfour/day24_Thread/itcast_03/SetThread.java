package com.cuileikun.androidbase.javaactivity.twentyfour.day24_Thread.itcast_03;

/**
 * 作者：popular cui
 * 时间：2017/7/1 18:02
 * 功能:
 */
public class SetThread implements Runnable {

    private Student s;

    public SetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        // Student s = new Student();
        s.name = "林青霞";
        s.age = 27;
    }
}
