package com.cuileikun.androidbase.javaactivity.twentyseven.day27_Reflect.itcast_06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 作者：popular cui
 * 时间：2017/7/3 21:36
 * 功能:
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target; // 目标对象

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("权限校验");
        Object result = method.invoke(target, args);
        System.out.println("日志记录");
        return result; // 返回的是代理对象
    }
}
