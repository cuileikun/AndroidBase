package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.cuileikun.androidbase.R;

/**
 * 作者：popular cui
 * 时间：2017/4/28 17:52
 * 功能:
 */
public class TestFindViewByMe extends Activity {
    private TextView tv5;
    private TextView tv4;
    private TextView tv8;
    private TextView tv1;
    private TextView tv3;
    private TextView tv2;
    private TextView tv9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_view_me);
        initView();
    }

    private void initView() {
        tv5 = (TextView) findViewById(R.id.tv_5);
        tv4 = (TextView) findViewById(R.id.tv_4);
        tv8 = (TextView) findViewById(R.id.tv_8);
        tv1 = (TextView) findViewById(R.id.tv_1);
        tv3 = (TextView) findViewById(R.id.tv_3);
        tv2 = (TextView) findViewById(R.id.tv_2);
        tv9 = (TextView) findViewById(R.id.tv_9);
    }
}
