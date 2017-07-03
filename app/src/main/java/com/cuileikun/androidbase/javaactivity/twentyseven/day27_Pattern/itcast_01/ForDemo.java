package com.cuileikun.androidbase.javaactivity.twentyseven.day27_Pattern.itcast_01;

/**
 * 作者：popular cui
 * 时间：2017/7/3 21:01
 * 功能:
 */
public class ForDemo extends GetTime {

    @Override
    public void code() {
        for (int x = 0; x < 100000; x++) {
            System.out.println(x);
        }
    }
}
