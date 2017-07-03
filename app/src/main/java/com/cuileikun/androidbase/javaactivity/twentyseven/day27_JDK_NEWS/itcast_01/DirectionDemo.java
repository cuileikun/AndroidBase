package com.cuileikun.androidbase.javaactivity.twentyseven.day27_JDK_NEWS.itcast_01;

/**
 * 作者：popular cui
 * 时间：2017/7/3 20:53
 * 功能:
 */
public class DirectionDemo {
    public static void main(String[] args) {
        Direction d = Direction.FRONT;
        System.out.println(d); // cn.itcast_01.Direction@175078b
        System.out.println("------------------------------------");
        Direction2 d2 = Direction2.FRONT;
        System.out.println(d2);// cn.itcast_01.Direction2@11563ff
        System.out.println(d2.getName());
        d2 = Direction2.RIGHT;
        System.out.println(d2);
        System.out.println(d2.getName());
        System.out.println("------------------------------------");
        Direction3 d3 = Direction3.FRONT;
        System.out.println(d3);
        System.out.println(d3.getName());
        d3.show();

        d3 = Direction3.LEFT;
        System.out.println(d3);
        System.out.println(d3.getName());
        d3.show();
    }
}
