package com.cuileikun.androidbase.activity.eight;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.cuileikun.androidbase.R;
import com.example.remoteserviceapp.PayAidlInterface;
import com.qk.applibrary.util.CommonUtil;

/**
 * Created by Admin on 2017/4/29.
 */

public class LocalServiceActivity extends Activity {
    private PayAidlInterface iservice; //这个是我们定义的中间人对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_service);
        //[1]调用bindservice 目的是为了获取中间人对象
//        Intent intent = new Intent();
//        intent.setAction("com.itheima.remoteservice");
//        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
        //使用意图对象绑定开启服务
        Intent intent = new Intent();
//在5.0及以上版本必须要加上这个
        intent.setPackage("com.example.remoteserviceapp");
        intent.setAction("com.itheima.remoteservice");//这个是上面service的action
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

    }

    //点击按钮 实现调用远程服务里面的方法
    public void click(View v) {
        try {
            int calculation = iservice.calculation(3, 4);
            CommonUtil.sendToast(LocalServiceActivity.this,"调用远程服务  aidl"+calculation);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        //当Activity销毁的时候 解绑服务
        unbindService(mServiceConnection);
        super.onDestroy();
    }

    //定义类 用于监听服务的状态
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            Log.e("123", "onServiceDisconnected:" + arg0.getPackageName());
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Log.e("123", "onServiceConnected:" + name.getPackageName());
            // 获取远程Service的onBinder方法返回的对象代理
            iservice = PayAidlInterface.Stub.asInterface(binder);
        }
    };
}
