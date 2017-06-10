package com.cuileikun.androidbase.javaactivity.nine.多态的概述和讲解;

/*
	看程序写结果:先判断有没有问题，如果没有，写出结果
*/
class FuSeventh {
    public void show() {
        System.out.println("fu show");
    }
}

class ZiSeventh extends FuSeventh {
    public void show() {
        System.out.println("zi show");
    }

    public void method() {
        System.out.println("zi method");
    }
}

public class DuoTaiTest3 {

    public static void main(String[] args) {
        FuSeventh f = new ZiSeventh();
        //找不到符号
//        f.method();
        f.show();
    }
}
