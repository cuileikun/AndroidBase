package com.cuileikun.androidbase.javaactivity.two.变量和数据类型;

/*
	byte b = 130;有没有问题?如果我想让赋值正确，可以怎么做?结果是多少呢?

	练习：byte b = (byte)300;
*/

public class DataTypeDemo7 {
    public static void main(String[] args) {
        //因为byte的范围是：-128到127。
        //而130不在此范围内，所以报错。
        //byte b = 130;

        //我们可以使用强制类型转换
        byte b = (byte) 130;

        //结果是多少呢?
        System.out.println(b);
    }
}
