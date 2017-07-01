package com.cuileikun.androidbase.javaactivity.twentyfour.day24_Thread.itcast_07;

/**
 * 作者：popular cui
 * 时间：2017/7/1 18:28
 * 功能:
 */
public class SetThread implements Runnable {

    private Student s;
    private int x = 0;

    public SetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            if (x % 2 == 0) {
                s.set("林青霞", 27);
            } else {
                s.set("刘意", 30);
            }
            x++;
        }
    }
}
