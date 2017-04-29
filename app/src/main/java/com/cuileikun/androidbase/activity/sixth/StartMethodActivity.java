package com.cuileikun.androidbase.activity.sixth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cuileikun.androidbase.R;

/**
 * 作者：popular cui
 * 时间：2017/4/27 21:01
 * 功能:
 */
public class StartMethodActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_method);
    }

    // 点击按钮 开启第一个页面
    public void open1(View v) {
        Intent intent = new Intent(this,StartMethodActivity.class);
        startActivity(intent);
    }

    // 点击按钮 开启第二个页面
    public void open2(View v) {

        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

}
