package com.cuileikun.androidbase.javaactivity.twentyseven.day27_Reflect.itcast_05;

/**
 * 作者：popular cui
 * 时间：2017/7/3 21:34
 * 功能:
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("添加功能");
    }

    @Override
    public void delete() {
        System.out.println("删除功能");
    }

    @Override
    public void update() {
        System.out.println("修改功能");
    }

    @Override
    public void find() {
        System.out.println("查找功能");
    }
}
