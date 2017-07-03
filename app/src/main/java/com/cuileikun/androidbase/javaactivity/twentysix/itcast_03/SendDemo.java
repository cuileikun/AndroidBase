package com.cuileikun.androidbase.javaactivity.twentysix.itcast_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 作者：popular cui
 * 时间：2017/7/3 15:05
 * 功能:
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        // 创建发送端的Socket对象
        DatagramSocket ds = new DatagramSocket();

        // 创建数据并打包
        byte[] bys = "helloworld".getBytes();
        DatagramPacket dp = new DatagramPacket(bys, bys.length,
                InetAddress.getByName("192.168.3.121"), 12345);

        // 发送数据
        ds.send(dp);

        // 释放资源
        ds.close();
    }
}
