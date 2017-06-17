package com.cuileikun.androidbase.javaactivity.sixteen.day16_Generic.aaaa;

/**
 * Created by Admin on 2017/6/17.
 */

public class ObjectToolDemo {
    public static void main(String[] args) {
        // ObjectTool ot = new ObjectTool();
        // ot.show("hello");
        // ot.show(100);
        // ot.show(true);

        // ObjectTool<String> ot = new ObjectTool<String>();
        // ot.show("hello");
        //
        // ObjectTool<Integer> ot2 = new ObjectTool<Integer>();
        // ot2.show(100);
        //
        // ObjectTool<Boolean> ot3 = new ObjectTool<Boolean>();
        // ot3.show(true);

        // 如果还听得懂，那就说明泛型类是没有问题的
        // 但是呢，谁说了我的方法一定要和类的类型的一致呢?
        // 我要是类上没有泛型的话，方法还能不能接收任意类型的参数了呢?

        // 定义泛型方法后
        ObjectTool ot = new ObjectTool();
        ot.show("hello");
        ot.show(100);
        ot.show(true);
    }
}
