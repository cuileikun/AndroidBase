package com.cuileikun.androidbase.javaactivity.six.面向对象;

//这是学生测试类

public class StudentDemo {
    public static void main(String[] args) {
        //类名 对象名 = new 类名();
        Student s = new Student();

        //输出成员变量值
        //System.out.println(s.name);
        //System.out.println(s.age);
        //System.out.println(s.address);
        //改进写法
        System.out.println(s.name+"---"+s.age+"---"+s.address);


        //给成员变量赋值
        s.name = "林青霞";
        s.age = 27;
        s.address = "北京";
        //赋值后的输出
        System.out.println(s.name+"---"+s.age+"---"+s.address);

        //调用方法
        s.study();
        s.eat();
        s.sleep();
    }
}
