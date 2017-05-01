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

public class CustomContentObserverActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_content_observer);
        //定义内容观察者
        Uri uri = Uri.parse("content://com.itheima.provider/");
        getContentResolver().registerContentObserver(uri, true, new MyContentObserver(new Handler()));

    }


    //定义内容观察者
    private class MyContentObserver extends ContentObserver {

        public MyContentObserver(Handler handler) {
            super(handler);
        }
        //重写onChange 方法
        @Override
        public void onChange(boolean selfChange) {
            System.out.println("哈哈哈  数据库的内容被操作了 ");
            super.onChange(selfChange);
        }

    }
}
