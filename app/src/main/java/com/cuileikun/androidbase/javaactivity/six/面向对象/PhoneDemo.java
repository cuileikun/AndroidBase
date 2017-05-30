package com.cuileikun.androidbase.javaactivity.six.面向对象;
/*
	手机类的测试
*/

public class PhoneDemo {
    public static void main(String[] args) {
        //创建手机对象
        //类名 对象名 = new 类名();
        Phone p = new Phone();

        //直接输出成员变量值
        System.out.println(p.brand+"---"+p.price+"---"+p.color);

        //给成员变量赋值
        p.brand = "诺基亚";
        p.price = 100;
        p.color = "灰色";
        //再次输出
        System.out.println(p.brand+"---"+p.price+"---"+p.color);

        //调用方法
        p.call("林青霞");
        p.sendMessage();
        p.playGame();
    }
}
