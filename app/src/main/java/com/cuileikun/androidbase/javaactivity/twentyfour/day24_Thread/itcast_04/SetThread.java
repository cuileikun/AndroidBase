package com.cuileikun.androidbase.javaactivity.twentyfour.day24_Thread.itcast_04;

/**
 * 作者：popular cui
 * 时间：2017/7/1 18:05
 * 功能:
 */
public class SetThread implements Runnable {

        private Student s;
        private int x = 0;

        public SetThread(Student s) {
            this.s = s;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (s) {
                    if (x % 2 == 0) {
                        s.name = "林青霞";//刚走到这里，就被别人抢到了执行权
                        s.age = 27;
                    } else {
                        s.name = "刘意"; //刚走到这里，就被别人抢到了执行权
                        s.age = 30;
                    }
                    x++;
                }
            }
        }
}
