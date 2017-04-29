package com.cuileikun.androidbase.activity.eight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.service.ScreenService;

/**
 * Created by Admin on 2017/4/29.
 */

public class ServiceBrocastActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_brocast);
        //启动服务
        Intent intent = new Intent(this,ScreenService.class);
        startService(intent);
    }
}
