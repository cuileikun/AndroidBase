package com.cuileikun.androidbase.javaactivity.nine.多态的概述和讲解;
/*
	ClassCastException:类型转换异常
	一般在多态的向下转型中容易出现
*/
class AnimalFivth {
    public void eat(){}
}

class DogFivth extends AnimalFivth {
    public void eat() {}

    public void lookDoor() {

    }
}

class CatFivth extends AnimalFivth {
    public void eat() {

    }

    public void playGame() {

    }
}

public class DuoTaiDemo5 {
    public static void main(String[] args) {
        //内存中的是狗
        AnimalFivth a = new DogFivth();
        DogFivth d = (DogFivth)a;

        //内存中是猫
        a = new CatFivth();
        CatFivth c = (CatFivth)a;

        //内存中是猫
        DogFivth dd = (DogFivth)a; //ClassCastException
    }
}
