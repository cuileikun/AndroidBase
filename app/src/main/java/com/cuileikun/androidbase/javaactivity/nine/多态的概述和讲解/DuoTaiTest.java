package com.cuileikun.androidbase.javaactivity.nine.多态的概述和讲解;

/*
	多态练习：猫狗案例
*/
class AnimalSixth {
    public void eat(){
        System.out.println("吃饭");
    }
}

class DogSixth extends AnimalSixth {
    public void eat() {
        System.out.println("狗吃肉");
    }

    public void lookDoor() {
        System.out.println("狗看门");
    }
}

class CatSixth extends AnimalSixth {
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void playGame() {
        System.out.println("猫捉迷藏");
    }
}

public class DuoTaiTest {
    public static void main(String[] args) {
        //定义为狗
        AnimalSixth a = new DogSixth();
        a.eat();
        System.out.println("--------------");
        //还原成狗
        DogSixth d = (DogSixth)a;
        d.eat();
        d.lookDoor();
        System.out.println("--------------");
        //变成猫
        a = new CatSixth();
        a.eat();
        System.out.println("--------------");
        //还原成猫
        CatSixth c = (CatSixth)a;
        c.eat();
        c.playGame();
        System.out.println("--------------");

        //演示错误的内容
        //Dog dd = new Animal();
        //Dog ddd = new Cat();
        //ClassCastException
        //Dog dd = (Dog)a;
    }
}
