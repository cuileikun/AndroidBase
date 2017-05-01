package com.cuileikun.androidbase.activity.eleven;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class NoticationActivity extends Activity {
    private NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notication);
        //[1]获取NotificationManager 管理者的实例
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    //点击按钮  发送一条通知
    public void click1(View v) {

        //链式调用

        Notification noti = new Notification.Builder(this)
                .setContentTitle("我是大标题")
                .setContentText("我是标题的内容")
                .setSmallIcon(R.drawable.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
                .build();


        //兼容低版本的写法   就是使用过时的方法
//        Notification noti = new Notification(R.drawable.ic_launcher, "收到一条通知", System.currentTimeMillis());
//
//
//        //收到通知后 让手机震动一下  并且加上呼吸灯
        noti.defaults = Notification.DEFAULT_ALL;
//
//        //不让通知删除  设置flag
        noti.flags = Notification.FLAG_NO_CLEAR;
//
//
//        //创建意图对象  实现打电话的功能
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + 119));
//
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
////        //点击这条通知 做的事情
//        noti.setLatestEventInfo(this, "小芳", "老地方见", pendingIntent);

        nm.notify(10, noti);

    }

    //点击按钮取消通知
    public void click2(View v) {

        nm.cancel(10);
    }


}
