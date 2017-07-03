package com.cuileikun.androidbase.javaactivity.twentyseven.day27_Pattern.itcast_02;

/**
 * 作者：popular cui
 * 时间：2017/7/3 21:07
 * 功能:
 */
public class MusicPhoneDecorate extends PhoneDecorate {

    public MusicPhoneDecorate(Phone p) {
        super(p);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("手机可以听音乐");
    }
}
