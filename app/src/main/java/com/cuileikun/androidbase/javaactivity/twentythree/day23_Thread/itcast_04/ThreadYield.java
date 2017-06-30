package com.cuileikun.androidbase.javaactivity.twentythree.day23_Thread.itcast_04;

/**
 * Created by Admin on 2017/6/30.
 */

public class ThreadYield extends Thread {
    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(getName() + ":" + x);
            Thread.yield();
        }
    }
}
