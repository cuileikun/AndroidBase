package com.cuileikun.androidbase.javaactivity.twentythree.day23_Thread.itcast_07;

/**
 * Created by Admin on 2017/6/30.
 */

public class SellTicket implements Runnable {
    // 定义100张票
    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "正在出售第"
                        + (tickets--) + "张票");
            }
        }
    }
}
