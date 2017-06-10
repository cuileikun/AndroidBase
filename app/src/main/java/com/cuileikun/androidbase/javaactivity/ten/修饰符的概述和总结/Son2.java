package com.cuileikun.androidbase.javaactivity.ten.修饰符的概述和总结;

/**
 * Created by Admin on 2017/6/10.
 */

public class Son2 extends Father{
    public static void main(String[] args) {
        Father f = new Father();
        //f.show();
        //f.show2();
        //f.show3();
        f.show4();
        System.out.println("--------------");

        Son2 s = new Son2();
        //s.show();
        //s.show2();
        s.show3();
        s.show4();
    }
}
