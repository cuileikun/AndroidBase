package com.cuileikun.androidbase.javaactivity.seven.构造方法;

import com.cuileikun.androidbase.javaactivity.six.面向对象.Student;

/*
	构造方法：
		给对象的数据进行初始化

	格式：
		A:方法名与类名相同
		B:没有返回值类型，连void都没有
		C:没有具体的返回值
*/
class ConstructStudent {
    private String name; //null
    private int age; //0

    public ConstructStudent() {
        System.out.println("这是构造方法");
    }
}

public class ConstructDemo {
    public static void main(String[] args) {
        //创建对象
        ConstructStudent s = new ConstructStudent();
        System.out.println(s); //Student@e5bbd6
    }
}
