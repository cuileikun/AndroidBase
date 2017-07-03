package com.cuileikun.androidbase.javaactivity.twentyseven.day27_Reflect.itcast_07;

import java.lang.reflect.Field;

/**
 * 作者：popular cui
 * 时间：2017/7/3 21:46
 * 功能:
 */
public class Tool {
    public void setProperty(Object obj, String propertyName, Object value)
            throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        // 根据对象获取字节码文件对象
        Class c = obj.getClass();
        // 获取该对象的propertyName成员变量
        Field field = c.getDeclaredField(propertyName);
        // 取消访问检查
        field.setAccessible(true);
        // 给对象的成员变量赋值为指定的值
        field.set(obj, value);
    }
}
