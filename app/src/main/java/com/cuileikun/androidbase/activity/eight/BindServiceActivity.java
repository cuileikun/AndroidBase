package com.cuileikun.androidbase.activity.eight;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.inteface.IService;
import com.cuileikun.androidbase.service.BanZhengService;

/**
 * Created by Admin on 2017/4/29.
 */

public class BindServiceActivity extends Activity {
    private IService iservice; //他就是我们自己定义的中间人对象
    private MyConn conn;
    //	private MyBinder myBinder;//我们自己定义的中间人对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        Intent intent = new Intent(this,BanZhengService.class);
        //连接到服务
        conn = new MyConn();
        bindService(intent, conn, BIND_AUTO_CREATE);

    }

    //点击按钮 调用服务里面的方法  办证方法
    public void click(View v) {
        //调用服务里面的方法
//		myBinder.callBanZheng(501);
//		myBinder.callPlayMajiang();
//		myBinder.callXiSangNa();

        iservice.callBanZheng(501);
        iservice.callPlayMajiang();


    }


    @Override
    protected void onDestroy() {
        //当Activity销毁的时候调用解绑服务
        unbindService(conn);

        super.onDestroy();
    }

    //定义一个类 用于监视服务的状态
    private class MyConn implements ServiceConnection {

        //当服务连接成功后调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //获取我们定义的中间人对象

//			myBinder = (MyBinder) service;

            iservice = (IService) service;


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

    }
}
