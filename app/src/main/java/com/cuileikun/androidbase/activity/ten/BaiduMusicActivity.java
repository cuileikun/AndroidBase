package com.cuileikun.androidbase.activity.ten;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.SeekBar;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.inteface.IIservice;
import com.cuileikun.androidbase.service.MMusicService;

/**
 * Created by Admin on 2017/4/29.
 */

public class BaiduMusicActivity extends Activity {

    private IIservice iservice; //我们定义的中间人对象
    private MyConn conn;
    private static SeekBar seekBar;
    public static Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            //获取 我们携带过来的数据
            Bundle data = msg.getData();
            int duration = data.getInt("duration"); //歌曲总时长
            int currentPosition = data.getInt("currentPosition");  //歌曲当前的进度

            //设置给seekbar
            seekBar.setMax(duration);
            seekBar.setProgress(currentPosition);


        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_du_music);

        // [1]先调用startService方法就可以保证服务在后台长期运行
        Intent intent = new Intent(this,MMusicService.class);
        startService(intent);

        //[2]调用bindService 方法目的是为了获取我们定义的中间人对象
        conn = new MyConn();
        bindService(intent,conn, BIND_AUTO_CREATE);

        //[3]找到seekbar
        seekBar = (SeekBar) findViewById(R.id.seekBar1);

        //[4]给seekbar设置一个改变的监听
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //当拖动停止后 执行的方法
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                iservice.callSeekToPositon(seekBar.getProgress());
            }

            //开始拖动
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            //当拖动状态发生改变
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

            }
        });



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
    private class MyConn implements ServiceConnection {



        //当服务连接成功的时候调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //在这个方法里面获取我们定义的中间人对象

            iservice = (IIservice) service;


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

    }


}
