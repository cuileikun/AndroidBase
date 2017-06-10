package com.cuileikun.androidbase.javaactivity.ten.包的概述和讲解;

/**
 * Created by Admin on 2017/6/10.
 */

public class Test {
    public static void main(String[] args) {
        //Demo d = new Demo();
		/*
		com.liuyi.Demo d = new com.liuyi.Demo();
		System.out.println(d.sum(10,20));

		com.liuyi.Demo d2 = new com.liuyi.Demo();
		System.out.println(d2.sum(10,20));

		com.liuyi.Demo d3 = new com.liuyi.Demo();
		System.out.println(d3.sum(10,20));

		com.liuyi.Demo d4 = new com.liuyi.Demo();

		System.out.println(d4.sum(10,20));
		*/

        Demo d = new Demo();
        System.out.println(d.sum(10,20));
    }
}


/*
	第一个问题：找不到Demo

	第二个问题：程序包com.liuyi不存在

	第三个问题： Demo在com.liuyi中不是公共的; 无法从外部程序包中对其进行访问
*/
