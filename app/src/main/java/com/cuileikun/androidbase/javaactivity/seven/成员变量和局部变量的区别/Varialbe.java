package com.cuileikun.androidbase.javaactivity.seven.成员变量和局部变量的区别;

/**
 * Created by Admin on 2017/5/31.
 */

public class Varialbe {
    //成员变量
    //int num = 10;
    int num; //0

    public void show() {
        //int num2 = 20; //局部变量
        //可能尚未初始化变量num2
        //int num2; //没有默认值
        int num2 = 20;
        System.out.println(num2);

        //int num = 100;
        System.out.println(num);
    }
}
