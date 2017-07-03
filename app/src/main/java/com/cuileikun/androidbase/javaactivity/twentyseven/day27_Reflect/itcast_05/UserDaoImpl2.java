package com.cuileikun.androidbase.javaactivity.twentyseven.day27_Reflect.itcast_05;

/**
 * 作者：popular cui
 * 时间：2017/7/3 21:35
 * 功能:
 */
public class UserDaoImpl2 implements UserDao {

    @Override
    public void add() {
        System.out.println("权限校验");
        System.out.println("添加功能");
        System.out.println("日志记录");
    }

    @Override
    public void delete() {
        System.out.println("权限校验");
        System.out.println("删除功能");
        System.out.println("日志记录");
    }

    @Override
    public void update() {
        System.out.println("权限校验");
        System.out.println("修改功能");
        System.out.println("日志记录");
    }

    @Override
    public void find() {
        System.out.println("权限校验");
        System.out.println("查找功能");
        System.out.println("日志记录");
    }
}
