package com.cuileikun.androidbase.javaactivity.ten.内部类概述和讲解;

/*
	面试题：
		要求请填空分别输出30，20，10。

	注意：
		1:内部类和外部类没有继承关系。
		2:通过外部类名限定this对象
			Outer.this
*/
class Outers {
    public int num = 10;
    class Inners {
        public int num = 20;
        public void show() {
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
            //System.out.println(new Outer().num);
            System.out.println(Outers.this.num);
        }
    }
}

public class InnerClassTest {
    public static void main(String[] args) {
        Outers.Inners oi = new Outers().new Inners();
        oi.show();
    }
}
