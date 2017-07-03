package com.cuileikun.androidbase.javaactivity.twentyseven.day27_JDK_NEWS.itcast_01;

/**
 * 作者：popular cui
 * 时间：2017/7/3 20:51
 * 功能:
 */
public class Direction {
    // 创建几个实例
    public static final Direction FRONT = new Direction();
    public static final Direction BEHIND = new Direction();
    public static final Direction LEFT = new Direction();
    public static final Direction RIGHT = new Direction();

    // 构造私有，别人就不能无限的创建了
    private Direction() {
    }
}
