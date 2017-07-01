package com.cuileikun.androidbase.javaactivity.twentyfour.day24_Pattern.itcast_02;

/**
 * 作者：popular cui
 * 时间：2017/7/1 16:36
 * 功能:
 */
public class DogFactory implements Factory {

    @Override
    public Animal createAnimal() {
        return new Dog();
    }

}
