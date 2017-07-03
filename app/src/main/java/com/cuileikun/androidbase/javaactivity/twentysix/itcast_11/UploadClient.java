package com.cuileikun.androidbase.javaactivity.twentysix.itcast_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 作者：popular cui
 * 时间：2017/7/3 20:15
 * 功能:
 */
public class UploadClient {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket s = new Socket("192.168.3.121", 11111);

        // 封装文本文件
        BufferedReader br = new BufferedReader(new FileReader(
                "InetAddressDemo.java"));
        // 封装通道内流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                s.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        // 释放资源
        br.close();
        s.close();
    }
}
