package com.cuileikun.androidbase.activity.eight;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.inteface.Iservicess;
import com.cuileikun.androidbase.service.MusicService;

/**
 * Created by Admin on 2017/4/29.
 */

public class BaiduMusiceActivity extends Activity {
    private Iservicess iservice; //我们定义的中间人对象
    private MyConn conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_music);
        // [1]先调用startService方法就可以保证服务在后台长期运行
        Intent intent = new Intent(this,MusicService.class);
        startService(intent);

        //[2]调用bindService 方法目的是为了获取我们定义的中间人对象
        conn = new MyConn();
        bindService(intent,conn, BIND_AUTO_CREATE);

    }

    @Override
    protected void onDestroy() {
        //当Activity销毁的时候  调用解绑服务
        unbindService(conn);
        super.onDestroy();
    }


    // 点击按钮 播放音乐
    public void click1(View v) {

        iservice.callPlayMusic();
    }

    // 点击按钮 暂停音乐
    public void click2(View v) {

        iservice.callPauseMusic();
    }

    // 点击按钮 继续播放
    public void click3(View v) {

        iservice.callReplayMusic();
    }


    //监视服务的状态
    private class MyConn implements ServiceConnection{



        //当服务连接成功的时候调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //在这个方法里面获取我们定义的中间人对象

            iservice = (Iservicess) service;


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

    }


}
