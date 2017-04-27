package com.cuileikun.androidbase.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.cuileikun.androidbase.R;
import com.qk.applibrary.activity.QkActivity;

/**
 * 作者：popular cui
 * 时间：2017/4/27 19:22
 * 功能:androidbase five
 */
public class AndroidBaseFivthActivity extends QkActivity implements View.OnClickListener {

    private Button btn_login;
    private Button btn_http_client;
    private Button btn_async_http_client;
    private Button btn_android_more_thread;
    private Button btn_kai_yuan_more_thread;

    @Override
    public void initViews() {
        super.initViews();
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_http_client = (Button) findViewById(R.id.btn_http_client);
        btn_async_http_client = (Button) findViewById(R.id.btn_async_http_client);
        btn_android_more_thread = (Button) findViewById(R.id.btn_android_more_thread);
        btn_kai_yuan_more_thread = (Button) findViewById(R.id.btn_kai_yuan_more_thread);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        btn_login.setOnClickListener(AndroidBaseFivthActivity.this);
        btn_http_client.setOnClickListener(AndroidBaseFivthActivity.this);
        btn_async_http_client.setOnClickListener(AndroidBaseFivthActivity.this);
        btn_android_more_thread.setOnClickListener(AndroidBaseFivthActivity.this);
        btn_kai_yuan_more_thread.setOnClickListener(AndroidBaseFivthActivity.this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_android_base_fivth;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                startActivity(new Intent(AndroidBaseFivthActivity.this,LoginActivity.class));
                break;
            case R.id.btn_http_client:
                startActivity(new Intent(AndroidBaseFivthActivity.this,HttpClientActivity.class));
                break;
            case R.id.btn_async_http_client:
                startActivity(new Intent(AndroidBaseFivthActivity.this,AsyncHttpClientActivity.class));
                break;
            case R.id.btn_android_more_thread:
                startActivity(new Intent(AndroidBaseFivthActivity.this,MoreThreadActivity.class));
                break;
            case R.id.btn_kai_yuan_more_thread:
                startActivity(new Intent(AndroidBaseFivthActivity.this,FreeMoreThreadActivity.class));
                break;


        }


    }
}
