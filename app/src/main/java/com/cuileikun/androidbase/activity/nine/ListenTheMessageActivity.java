package com.cuileikun.androidbase.activity.nine;

import android.app.Activity;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class ListenTheMessageActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_the_message);
        //注册内容观察者
        Uri uri = Uri.parse("content://sms/");
        getContentResolver().registerContentObserver(uri, true, new MyContentObserver(new Handler()));
    }
    //定义内容的观察者
    private class MyContentObserver extends ContentObserver {

        public MyContentObserver(Handler handler) {
            super(handler);
        }
        @Override
        public void onChange(boolean selfChange) {

            System.out.println("哈哈哈  呵呵呵 ");
            //把短信的内容获取出来

            super.onChange(selfChange);
        }

    }
}
