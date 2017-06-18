package com.cuileikun.androidbase.javaactivity.twentyone.day21_IO;

/*
 * 字节流读取中文可能出现的小问题：
 */

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流对象
        FileInputStream fis = new FileInputStream("a.txt");

        // 读取数据
        // int by = 0;
        // while ((by = fis.read()) != -1) {
        // System.out.print((char) by);
        // }

        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = fis.read(bys)) != -1) {
            System.out.print(new String(bys, 0, len));
        }

        // 释放资源
        fis.close();
    }
}
