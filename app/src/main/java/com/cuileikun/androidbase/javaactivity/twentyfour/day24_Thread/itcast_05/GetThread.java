package com.cuileikun.androidbase.javaactivity.twentyfour.day24_Thread.itcast_05;

/**
 * 作者：popular cui
 * 时间：2017/7/1 18:09
 * 功能:
 */
public class GetThread implements Runnable {
    private Student s;

    public GetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (s) {
                if(!s.flag){
                    try {
                        s.wait(); //t2就等待了。立即释放锁。将来醒过来的时候，是从这里醒过来的时候
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(s.name + "---" + s.age);
                //林青霞---27
                //刘意---30

                //修改标记
                s.flag = false;
                //唤醒线程
                s.notify(); //唤醒t1
            }
        }
    }
}
