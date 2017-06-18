package com.cuileikun.androidbase.javaactivity.twentyone.day21_IO.aaa;

/*
 * 需求：把c:\\a.txt内容复制到d:\\b.txt中
 *
 * 数据源：
 * 		c:\\a.txt -- FileReader
 * 目的地:
 * 		d:\\b.txt -- FileWriter
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo3 {
    public static void main(String[] args) throws IOException {
        // 封装数据源
        FileReader fr = new FileReader("c:\\a.txt");
        // 封装目的地
        FileWriter fw = new FileWriter("d:\\b.txt");

        // 读写数据
        // int ch = 0;
        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        //释放资源
        fw.close();
        fr.close();
    }
}
