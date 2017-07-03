package com.cuileikun.androidbase.javaactivity.twentyseven.day27_Pattern.itcast_02;

public class RingPhoneDecorate extends PhoneDecorate {

    public RingPhoneDecorate(Phone p) {
        super(p);
    }

    @Override
    public void call() {
        System.out.println("手机可以听彩铃");
        super.call();
    }
}

