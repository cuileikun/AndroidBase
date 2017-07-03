package com.cuileikun.androidbase.javaactivity.twentyseven.day27_Pattern.itcast_01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 作者：popular cui
 * 时间：2017/7/3 21:04
 * 功能:
 */
public class IODemo extends GetTime{

    @Override
    public void code() {
        try {
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream("a.avi"));
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream("b.avi"));
            byte[] bys = new byte[1024];
            int len = 0;
            while ((len = bis.read(bys)) != -1) {
                bos.write(bys, 0, len);
            }
            bos.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
