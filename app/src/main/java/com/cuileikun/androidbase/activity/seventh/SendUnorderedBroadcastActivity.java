package com.cuileikun.androidbase.activity.seventh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class SendUnorderedBroadcastActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_unordered_broadcast);
    }
    //点击按钮 发送无序广播
    public void click(View v) {

        //创建意图对象
        Intent intent = new Intent();
        intent.setAction("com.itheima.custom");
        intent.putExtra("name", "新闻联播每天晚上7点准时开整!!!");
        //发送无序广播
        sendBroadcast(intent);

    }
}
