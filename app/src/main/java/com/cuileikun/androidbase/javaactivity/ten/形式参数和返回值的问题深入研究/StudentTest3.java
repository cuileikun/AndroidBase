package com.cuileikun.androidbase.javaactivity.ten.形式参数和返回值的问题深入研究;
/*
	链式编程。
		每次调用完毕方法后，返回的是一个对象。
*/
class StudentSSSS {
    public void study() {
        System.out.println("Good Good Study,Day Day Up");
    }
}

class StudentDemoSSSS {
    public StudentSSSS getStudentSSSS() {
        return new StudentSSSS();
    }
}

public class StudentTest3 {
    public static void main(String[] args) {
        //如何调用的呢?
        StudentDemoSSSS sd = new StudentDemoSSSS();
        //Student s = sd.getStudent();
        //s.study();

        //大家注意了
        sd.getStudentSSSS().study();
    }
}
