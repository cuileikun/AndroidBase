package com.cuileikun.androidbase.javaactivity.two.变量和数据类型;

/*
    数据类型：Java是一种强类型的语言，针对每一种数据都定义了明确的数据类型。

	数据类型分类：
		A:基本数据类型
		B:引用数据类型(类,接口,数值)

	基本数据类型:4类8种
		A:整数			占用字节数
			byte			1
			short			2
			int				4
			long			8

		B:浮点数
			float 			4
			double 			8

		C:字符
			char			2
		D:布尔
			boolean			1

		注意：
			整数默认是int类型
			浮点数默认是double类型。

			长整型后缀用L或者l标记。建议使用L。
			单精度浮点数用F或者f标记。建议使用F。
*/

public class DataTypeDemo {
    public static void main(String[] args) {
        //定义变量的格式：
        //数据类型 变量名 = 初始化值;

        //定义一个字节变量
        byte b = 10;
        System.out.println(10);
        System.out.println(b);

        //定义一个短整型变量
        short s = 100;
        System.out.println(s);

        //定义一个整型变量
        int i = 1000;
        System.out.println(i);

        //超过了int的范围
        //int j = 1000000000000;
        long j = 1000000000000L;
        //long j = 100L;
        System.out.println(j);
    }
}
