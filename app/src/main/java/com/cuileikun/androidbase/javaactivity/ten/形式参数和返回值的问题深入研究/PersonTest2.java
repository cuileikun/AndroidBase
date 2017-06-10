package com.cuileikun.androidbase.javaactivity.ten.形式参数和返回值的问题深入研究;
/*
	返回值类型
		基本类型:(基本类型太简单，我不准备讲解)
		引用类型：
			类:返回的是该类的对象
			抽象类:返回的是该抽象类的子类对象
			接口:
*/
abstract class PersonS {
    public abstract void study();
}

class PersonDemoS {
    public PersonS getPersonS() {
        //Person p = new Student();
        //return p;

        return new StudentS();
    }
}

class StudentS extends PersonS {
    public void study() {
        System.out.println("Good Good Study,Day Day Up");
    }
}

public class PersonTest2 {
    public static void main(String[] args) {
        //需求：我要测试Person类中的study()方法
        PersonDemoS pd = new PersonDemoS();
        PersonS p = pd.getPersonS(); //new Student();  Person p = new Student(); 多态
        p.study();
    }
}
