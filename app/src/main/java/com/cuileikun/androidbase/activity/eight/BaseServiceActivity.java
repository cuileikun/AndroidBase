package com.cuileikun.androidbase.activity.eight;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.service.DemoService;

/**
 * Created by Admin on 2017/4/29.
 */

public class BaseServiceActivity extends Activity {
    private MyConn conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_service);
    }
    //点击按钮 开启服务
    public void click1(View v) {

        //开启服务 和开启Activity同理
        Intent intent = new Intent(this,DemoService.class);
        startService(intent);


    }


    //点击按钮 开启服务
    public void click2(View v) {

        //开启服务 和开启Activity同理
        Intent intent = new Intent(this,DemoService.class);
        stopService(intent);

    }

    //点击按钮  使用bindService的方式去连接服务
    public void click3(View v) {

        //创建意图
        Intent intent = new Intent(this,DemoService.class);
        //连接到demoService这个服务

        conn = new MyConn();

        bindService(intent,conn , BIND_AUTO_CREATE);

    }

    public void click4(View v){
        //解绑服务
        unbindService(conn);
    }

    @Override
    protected void onDestroy() {

        //当Activity销毁的是 解绑服务
//		unbindService(conn);

        super.onDestroy();
    }


    //定义一个类 用于监听服务的状态
    private class MyConn implements ServiceConnection {

        //当服务连接成功的时候调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            System.out.println("哈哈哈"+"666666666666666");
        }

        //失去连接的时候调用
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

    }


}
