package com.cuileikun.androidbase.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.activity.eight.BaiduMusiceActivity;
import com.cuileikun.androidbase.activity.eight.BaseServiceActivity;
import com.cuileikun.androidbase.activity.eight.BindServiceActivity;
import com.cuileikun.androidbase.activity.eight.ListenCallActivity;
import com.cuileikun.androidbase.activity.eight.LocalServiceActivity;
import com.cuileikun.androidbase.activity.eight.RemoteServiceActivity;
import com.cuileikun.androidbase.activity.eight.ServiceBrocastActivity;
import com.cuileikun.androidbase.activity.eight.UseBindServiceActivity;
import com.cuileikun.androidbase.activity.eight.ZhifubaoActivity;

/**
 * Created by Admin on 2017/4/29.
 */

public class AndroidBaseEightActivity extends Activity implements View.OnClickListener {
    private Button btnBaseService;
    private Button btnListenCall;
    private Button btnServiceBrocast;
    private Button btnUseBindService;
    private Button btnBindService;
    private Button btnBaiduMusice;
    private Button btnRemoteService;
    private Button btnLocalService;
    private Button btnZhifubao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_base_eight);
        initView();
    }

    private void initView() {
        btnBaseService = (Button) findViewById(R.id.btn_base_service);
        btnListenCall = (Button) findViewById(R.id.btn_listen_call);
        btnServiceBrocast = (Button) findViewById(R.id.btn_service_brocast);
        btnUseBindService = (Button) findViewById(R.id.btn_use_bind_service);
        btnBindService = (Button) findViewById(R.id.btn_bind_service);
        btnBaiduMusice = (Button) findViewById(R.id.btn_baidu_musice);
        btnRemoteService = (Button) findViewById(R.id.btn_remote_service);
        btnLocalService = (Button) findViewById(R.id.btn_local_service);
        btnZhifubao = (Button) findViewById(R.id.btn_zhifubao);
        addListener();
    }

    private void addListener() {
        btnBaseService.setOnClickListener(AndroidBaseEightActivity.this);
        btnListenCall.setOnClickListener(AndroidBaseEightActivity.this);
        btnServiceBrocast.setOnClickListener(AndroidBaseEightActivity.this);
        btnUseBindService.setOnClickListener(AndroidBaseEightActivity.this);
        btnBaiduMusice.setOnClickListener(AndroidBaseEightActivity.this);
        btnRemoteService.setOnClickListener(AndroidBaseEightActivity.this);
        btnLocalService.setOnClickListener(AndroidBaseEightActivity.this);
        btnZhifubao.setOnClickListener(AndroidBaseEightActivity.this);
        btnBindService.setOnClickListener(AndroidBaseEightActivity.this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_base_service:
                startActivity(new Intent(AndroidBaseEightActivity.this,BaseServiceActivity.class));
                break;
            case R.id.btn_listen_call:
                startActivity(new Intent(AndroidBaseEightActivity.this,ListenCallActivity.class));
                break;
            case R.id.btn_service_brocast:
                startActivity(new Intent(AndroidBaseEightActivity.this,ServiceBrocastActivity.class));
                break;
            case R.id.btn_use_bind_service:
                startActivity(new Intent(AndroidBaseEightActivity.this,UseBindServiceActivity.class));
                break;
            case R.id.btn_bind_service:
                startActivity(new Intent(AndroidBaseEightActivity.this,BindServiceActivity.class));
                break;
            case R.id.btn_baidu_musice:
                startActivity(new Intent(AndroidBaseEightActivity.this,BaiduMusiceActivity.class));
                break;
            case R.id.btn_remote_service:
                startActivity(new Intent(AndroidBaseEightActivity.this,RemoteServiceActivity.class));
                break;
            case R.id.btn_local_service:
                startActivity(new Intent(AndroidBaseEightActivity.this,LocalServiceActivity.class));
                break;
            case R.id.btn_zhifubao:
                startActivity(new Intent(AndroidBaseEightActivity.this,ZhifubaoActivity.class));
                break;
        }

    }
}
