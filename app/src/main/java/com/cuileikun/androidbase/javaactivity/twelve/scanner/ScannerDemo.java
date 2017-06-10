package com.cuileikun.androidbase.javaactivity.twelve.scanner;

import java.util.Scanner;

/**
 * Created by Admin on 2017/6/10.
 */

public class ScannerDemo {
    public static void main(String[] args) {
        // 创建对象
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        System.out.println("x:" + x);
    }
}
