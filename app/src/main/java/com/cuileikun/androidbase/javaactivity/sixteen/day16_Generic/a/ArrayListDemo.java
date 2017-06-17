package com.cuileikun.androidbase.javaactivity.sixteen.day16_Generic.a;
/*
 * 泛型在哪些地方使用呢?
 * 		看API，如果类，接口，抽象类后面跟的有<E>就说要使用泛型。一般来说就是在集合中使用。
 */

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        // 用ArrayList存储字符串元素，并遍历。用泛型改进代码
        ArrayList<String> array = new ArrayList<String>();

        array.add("hello");
        array.add("world");
        array.add("java");

        Iterator<String> it = array.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("-----------------");

        for (int x = 0; x < array.size(); x++) {
            String s = array.get(x);
            System.out.println(s);
        }
    }
}
