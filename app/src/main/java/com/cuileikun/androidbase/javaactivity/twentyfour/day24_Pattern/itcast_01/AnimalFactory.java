package com.cuileikun.androidbase.javaactivity.twentyfour.day24_Pattern.itcast_01;

/**
 * 作者：popular cui
 * 时间：2017/7/1 16:30
 * 功能:动物工厂
 */
public class AnimalFactory {
    private AnimalFactory() {
    }

    // public static Dog createDog() {
    // return new Dog();
    // }
    //
    // public static Cat createCat() {
    // return new Cat();
    // }

    public static Animal createAnimal(String type) {
        if ("dog".equals(type)) {
            return new Dog();
        } else if ("cat".equals(type)) {
            return new Cat();
        } else {
            return null;
        }
    }
}
