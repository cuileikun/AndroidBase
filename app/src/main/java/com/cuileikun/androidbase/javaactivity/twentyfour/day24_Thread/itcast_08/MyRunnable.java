package com.cuileikun.androidbase.javaactivity.twentyfour.day24_Thread.itcast_08;

/**
 * 作者：popular cui
 * 时间：2017/7/1 18:30
 * 功能:
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(Thread.currentThread().getName() + ":" + x);
        }
    }
}
