package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.cuileikun.androidbase.R;

/**
 * 作者：popular cui
 * 时间：2017/4/27 21:00
 * 功能:
 */
public class NewActivity extends Activity {

    // 当activity启动的时候调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 给当前activity加载布局
        setContentView(R.layout.activity_new);
    }

    // 点击按钮 实现拨打电话的功能
    public void click1(View v) {
        // [1]创建意图对象
        Intent intent = new Intent();
        // [2]设置action 拨打的动作
        intent.setAction(Intent.ACTION_CALL);
        // [3]设置data
        intent.setData(Uri.parse("tel:" + 1199));
        // [4]开启Activity
        startActivity(intent);

    }

    // 开启testActivity
    public void click2(View v) {
        // [1]创建意图对象
        Intent intent = new Intent();
        // [2]设置action 拨打的动作  用我自己定义好的action
        intent.setAction("com.itheima.testactivity");
        //[3]设置category
        intent.addCategory("android.intent.category.DEFAULT");

        //[5]设置数据传输的类型 这个方法会自动清除setData方法设置的数据
//				intent.setType("aa/bb");
        //[4]设置data 完成这个意图 更加麻烦一些
//		intent.setData(Uri.parse("itheima:"+111));

        //注意 ☆☆☆☆如果 setData 和 setType方法需要同时使用的时候  应该使用下面这个方法
        intent.setDataAndType(Uri.parse("itheima1:" + 111), "aa/bb1");
        // [6]开启Activity
        startActivity(intent);
    }

    //点击按钮 开启Test2Activity
    public void click3(View v) {
        // [1]创建意图对象
        Intent intent = new Intent(this, Test2Activity.class);
        // [2]指定我要开启Activity的包名 和类名
        //intent.setClassName("com.itheima.newactivity", "com.itheima.newactivity.TestActivity");
        //[3]开启Activity
        startActivity(intent);

    }

}
