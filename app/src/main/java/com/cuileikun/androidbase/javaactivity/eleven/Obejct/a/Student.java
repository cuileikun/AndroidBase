package com.cuileikun.androidbase.javaactivity.eleven.Obejct.a;

/**
 * Created by Admin on 2017/6/10.
 */

public class Student {
    private String name;
    private int age;

    public Student() {
        super();
    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    // @Override
    // public String toString() {
    // // return super.toString();
    // // return "hello";
    // return "姓名:" + name + ",年龄:" + age;
    // }
}
