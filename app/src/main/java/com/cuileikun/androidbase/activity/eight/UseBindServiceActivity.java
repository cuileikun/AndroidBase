package com.cuileikun.androidbase.activity.eight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.service.TestService;

/**
 * Created by Admin on 2017/4/29.
 */

public class UseBindServiceActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_bind_service);
        Intent intent = new Intent(this,TestService.class);
        startService(intent);


    }

    //点击按钮 调用testService服务里面的方法 testService方法
    public void click(View v){
        //如果这个对象 直接new 那么现在这个对象使用的条件就脱了了谷歌的框架  相当于是一个普通的java对象  没有上下文的环境
        TestService testService = new TestService();
        testService.testService();

    }
}
