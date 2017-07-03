package com.cuileikun.androidbase.javaactivity.twentysix.itcast_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 作者：popular cui
 * 时间：2017/7/3 17:48
 * 功能:
 */
public class SendThread implements Runnable {

    private DatagramSocket ds;

    public SendThread(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            // 封装键盘录入数据
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    System.in));
            String line = null;
            while ((line = br.readLine()) != null) {
                if ("886".equals(line)) {
                    break;
                }

                // 创建数据并打包
                byte[] bys = line.getBytes();
                // DatagramPacket dp = new DatagramPacket(bys, bys.length,
                // InetAddress.getByName("192.168.12.92"), 12345);
                DatagramPacket dp = new DatagramPacket(bys, bys.length,
                        InetAddress.getByName("192.168.3.121"), 12306);

                // 发送数据
                ds.send(dp);
            }

            // 释放资源
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
