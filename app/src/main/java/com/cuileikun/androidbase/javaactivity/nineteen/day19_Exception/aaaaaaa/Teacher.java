package com.cuileikun.androidbase.javaactivity.nineteen.day19_Exception.aaaaaaa;

/**
 * Created by Admin on 2017/6/18.
 */

public class Teacher {
    public void check(int score) throws MyException {
        if (score > 100 || score < 0) {
            throw new MyException("分数必须在0-100之间");
        } else {
            System.out.println("分数没有问题");
        }
    }

    // 针对MyException继承自RuntimeException
    // public void check(int score) {
    // if (score > 100 || score < 0) {
    // throw new MyException();
    // } else {
    // System.out.println("分数没有问题");
    // }
    // }
}
