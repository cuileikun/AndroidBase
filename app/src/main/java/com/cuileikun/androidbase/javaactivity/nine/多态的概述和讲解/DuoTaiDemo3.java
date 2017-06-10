package com.cuileikun.androidbase.javaactivity.nine.多态的概述和讲解;

/*
	多态的弊端：
		不能使用子类的特有功能。
*/
class FuThird {
    public void show() {
        System.out.println("show fu");
    }
}

class ZiThird extends FuThird {
    public void show() {
        System.out.println("show zi");
    }

    public void method() {
        System.out.println("method zi");
    }

}

public class DuoTaiDemo3 {

    public static void main(String[] args) {
        //测试
        FuThird f = new ZiThird();
        f.show();
//        f.method();
    }
}
