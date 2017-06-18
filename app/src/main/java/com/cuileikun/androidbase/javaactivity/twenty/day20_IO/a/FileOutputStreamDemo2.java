package com.cuileikun.androidbase.javaactivity.twenty.day20_IO.a;

/*
 * 字节输出流操作步骤：
 * A:创建字节输出流对象
 * B:调用write()方法
 * C:释放资源
 *
 * public void write(int b):写一个字节
 * public void write(byte[] b):写一个字节数组
 * public void write(byte[] b,int off,int len):写一个字节数组的一部分
 */

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        // 创建字节输出流对象
        // 多态方式1
        // OutputStream os = new FileOutputStream("fos2");
        FileOutputStream fos = new FileOutputStream("fos2");
        // 调用write()方法 public void write(int b):写一个字节
        fos.write(97);
        fos.write(90);

        // public void write(byte[] b):写一个字节数组
        byte[] bytes = { 1, 3, 4, 5, 6, 7 };
        fos.write(bytes);


        // public void write(byte[] b,int off,int len):写一个字节数组的一部分
        fos.write(bytes,2,3);

        // 释放资源
        try {
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
