package com.cuileikun.androidbase.javaactivity.twentyone.day21_IO_test.aaaaaaaa;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Admin on 2017/6/18.
 */

public class MyLineNumberReaderTest {
    public static void main(String[] args) throws IOException {
        // MyLineNumberReader mlnr = new MyLineNumberReader(new FileReader(
        // "my.txt"));

        MyLineNumberReader2 mlnr = new MyLineNumberReader2(new FileReader(
                "my.txt"));

        // mlnr.setLineNumber(10);

        // System.out.println(mlnr.getLineNumber());
        // System.out.println(mlnr.getLineNumber());
        // System.out.println(mlnr.getLineNumber());

        String line = null;
        while ((line = mlnr.readLine()) != null) {
            System.out.println(mlnr.getLineNumber() + ":" + line);
        }

        mlnr.close();
    }
}
