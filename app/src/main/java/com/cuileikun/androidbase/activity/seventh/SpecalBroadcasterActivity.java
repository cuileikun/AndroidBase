package com.cuileikun.androidbase.activity.seventh;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.receiver.ScreenReceiver;

/**
 * Created by Admin on 2017/4/29.
 */

public class SpecalBroadcasterActivity extends Activity {
    private ScreenReceiver screenReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specal_broadcast);
        //[1]获取receiver的实例

        screenReceiver = new ScreenReceiver();

        //[2]准备intent-filter
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.SCREEN_ON");
        //通过代码动态的去注册
        this.registerReceiver(screenReceiver, filter);
    }

    //当Activity销毁的时候 需要取消注册广播接收者
    @Override
    protected void onDestroy() {
        //取消注册广播接收者
        unregisterReceiver(screenReceiver);

        super.onDestroy();
    }

}
