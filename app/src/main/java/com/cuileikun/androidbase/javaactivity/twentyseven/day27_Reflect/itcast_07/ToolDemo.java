package com.cuileikun.androidbase.javaactivity.twentyseven.day27_Reflect.itcast_07;

/**
 * 作者：popular cui
 * 时间：2017/7/3 21:46
 * 功能:
 */
public class ToolDemo {
    public static void main(String[] args) throws NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException {
        Person p = new Person();
        Tool t = new Tool();
        t.setProperty(p, "name", "林青霞");
        t.setProperty(p, "age", 27);
        System.out.println(p);
        System.out.println("-----------");

        Dog d = new Dog();

        t.setProperty(d, "sex", '男');
        t.setProperty(d, "price", 12.34f);

        System.out.println(d);
    }
}

class Dog {
    char sex;
    float price;

    @Override
    public String toString() {
        return sex + "---" + price;
    }
}

class Person {
    private String name;
    public int age;

    @Override
    public String toString() {
        return name + "---" + age;
    }
}
