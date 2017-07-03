package com.cuileikun.androidbase.javaactivity.twentysix.itcast_07;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 作者：popular cui
 * 时间：2017/7/3 17:57
 * 功能:
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket s = new Socket("192.168.3.121", 9999);

        // 获取输出流
        OutputStream os = s.getOutputStream();
        os.write("今天天气很好,适合睡觉".getBytes());

        // 获取输入流
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);// 阻塞
        String client = new String(bys, 0, len);
        System.out.println("client:" + client);

        // 释放资源
        s.close();
    }
}
