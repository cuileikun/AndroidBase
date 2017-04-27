package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cuileikun.androidbase.R;

/**
 * 作者：popular cui
 * 时间：2017/4/27 21:01
 * 功能:
 */
public class LifeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        System.out.println("onCreate");
    }

    //点击按钮 跳转到TestActivity
    public void click(View v) {
        Intent intent = new Intent(this,TestActivit.class);
        startActivity(intent);

    }

    //当activity销毁的时候调用
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

    //当activity 变成可视
    @Override
    protected void onStart() {
        System.out.println("onStart");
        super.onStart();
    }

    //当界面不可以
    @Override
    protected void onStop() {
        System.out.println("onStop");
        super.onStop();
    }

    //当activity 获取焦点  当 界面上的按钮可以被点击了
    @Override
    protected void onResume() {
        System.out.println("onResume");
        super.onResume();
    }

    //当activity 失去焦点  当界面上的按钮不要可以被点击
    @Override
    protected void onPause() {
        System.out.println("onPause");
        super.onPause();
    }

    //当界面重新启动
    @Override
    protected void onRestart() {
        System.out.println("onRestart");
        super.onRestart();
    }

}
