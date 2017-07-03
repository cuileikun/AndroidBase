package com.cuileikun.androidbase.javaactivity.twentysix.itcast_15;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 作者：popular cui
 * 时间：2017/7/3 20:27
 * 功能:
 */
public class UploadServer {
    public static void main(String[] args) throws IOException {
        // 创建服务器Socket对象
        ServerSocket ss = new ServerSocket(11111);

        while (true) {
            Socket s = ss.accept();
            new Thread(new UserThread(s)).start();
        }
    }
}
