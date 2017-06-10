package com.cuileikun.androidbase.javaactivity.ten.内部类概述和讲解;

/*
	匿名内部类面试题：
		按照要求，补齐代码
			interface Inter { void show(); }
			class Outer { //补齐代码 }
			class OuterDemo {
				public static void main(String[] args) {
					  Outer.method().show();
				  }
			}
			要求在控制台输出”HelloWorld”
*/
interface Interss {
    void show();
    //public abstract
}

class Outerss {
    //补齐代码
    public static Interss method() {
        //子类对象 -- 子类匿名对象
        return new Interss() {
            public void show() {
                System.out.println("HelloWorld");
            }
        };
    }
}

public class OuterDemo {
    public static void main(String[] args) {
        Outerss.method().show();
		/*
			1:Outer.method()可以看出method()应该是Outer中的一个静态方法。
			2:Outer.method().show()可以看出method()方法的返回值是一个对象。
				又由于接口Inter中有一个show()方法,所以我认为method()方法的返回值类型是一个接口。
		*/
    }
}
