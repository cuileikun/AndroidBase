package com.cuileikun.androidbase.javaactivity.twentyfour.day24_Thread.itcast_02;

/**
 * 作者：popular cui
 * 时间：2017/7/1 17:58
 * 功能:
 */
public class DieLock extends Thread {

    private boolean flag;

    public DieLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (MyLock.objA) {
                System.out.println("if objA");
                synchronized (MyLock.objB) {
                    System.out.println("if objB");
                }
            }
        } else {
            synchronized (MyLock.objB) {
                System.out.println("else objB");
                synchronized (MyLock.objA) {
                    System.out.println("else objA");
                }
            }
        }
    }
}
