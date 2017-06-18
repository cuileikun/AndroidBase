package com.cuileikun.androidbase.javaactivity.twenty.day20_IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Admin on 2017/6/18.
 */

public class Demo {
    public static void main(String[] args) {
        FileWriter fw=null;
        try {
            fw = new FileWriter("k.txt");
            fw.write("hello");
            fw.flush();
        } catch (IOException e) {

            e.printStackTrace();
        }finally{
            if(fw!=null)
                try {

                    fw.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
        }

    }
}
