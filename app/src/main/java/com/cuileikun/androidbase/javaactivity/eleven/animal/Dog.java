package com.cuileikun.androidbase.javaactivity.eleven.animal;

/**
 * Created by Admin on 2017/6/10.
 */

public class Dog extends Animal implements Jump {
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }

    @Override
    public void sleep() {
        System.out.println("狗站着睡觉");
    }

    @Override
    public void jump() {
        System.out.println("会跳高的狗");

    }
}
