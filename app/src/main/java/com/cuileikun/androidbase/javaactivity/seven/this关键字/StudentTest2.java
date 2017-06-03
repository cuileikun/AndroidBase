package com.cuileikun.androidbase.javaactivity.seven.this关键字;

/*
	标准的代码改进版

	this:哪个对象调用那个方法，this就代表那个对象
*/
class StudentThird {
    private String name;
    private int age;

    public String getName() {
        return name; //这里其实是隐含了this
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class StudentTest2 {
    public static void main(String[] args) {
        //创建一个对象
        StudentThird s1 = new StudentThird();
        s1.setName("林青霞");
        s1.setAge(27);
        System.out.println(s1.getName()+"---"+s1.getAge());

        //创建第二个对象
        StudentThird s2 = new StudentThird();
        s2.setName("刘意");
        s2.setAge(30);
        System.out.println(s2.getName()+"---"+s2.getAge());
    }
}
