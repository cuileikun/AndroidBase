package com.cuileikun.androidbase.javaactivity.ten.内部类概述和讲解;

/*
	成员内部类:
		如何直接访问内部类的成员。
		外部类名.内部类名 对象名 = 外部类对象.内部类对象;
*/
class OuterSS {
    private int num = 10;

    class InnerSS {
        public void show() {
            System.out.println(num);
        }
    }
}

public class InnerClassDemo3 {
    public static void main(String[] args) {
        //需求：我要访问Inner类的show()方法
        //Inner i = new Inner();
        //i.show();

        //格式：外部类名.内部类名 对象名 = 外部类对象.内部类对象;
        OuterSS.InnerSS oi = new OuterSS().new InnerSS();
        oi.show();
    }
}
