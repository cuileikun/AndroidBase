package com.cuileikun.androidbase.activity.fouth;

import android.view.View;

import com.cuileikun.androidbase.R;
import com.qk.applibrary.activity.QkActivity;

/**
 * 作者：popular cui
 * 时间：2017/4/24 17:19
 * 功能:2_演示anr
 */
public class AnrActivity extends QkActivity {
    //点击按钮演示 anr
    public void click(View v) {

        try {
            Thread.sleep(6000);

            System.out.println("哈哈哈");

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_anr;
    }
}
