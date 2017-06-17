package com.cuileikun.androidbase.javaactivity.seventeen.day17_Set_Son.a;

/**
 * Created by Admin on 2017/6/17.
 */

public class Student {
    private String name;
    private int age;

    public Student() {
        super();
    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    // @Override
    // public int hashCode() {
    // // return 0;
    // // 因为成员变量值影响了哈希值，所以我们把成员变量值相加即可
    // // return this.name.hashCode() + this.age;
    // // 看下面
    // // s1:name.hashCode()=40,age=30
    // // s2:name.hashCode()=20,age=50
    // // 尽可能的区分,我们可以把它们乘以一些整数
    // return this.name.hashCode() + this.age * 15;
    // }
    //
    // @Override
    // public boolean equals(Object obj) {
    // // System.out.println(this + "---" + obj);
    // if (this == obj) {
    // return true;
    // }
    //
    // if (!(obj instanceof Student)) {
    // return false;
    // }
    //
    // Student s = (Student) obj;
    // return this.name.equals(s.name) && this.age == s.age;
    // }
    //
    // @Override
    // public String toString() {
    // return "Student [name=" + name + ", age=" + age + "]";
    // }
}
