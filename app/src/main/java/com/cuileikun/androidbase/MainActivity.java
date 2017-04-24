package com.cuileikun.androidbase;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cuileikun.androidbase.activity.AndroidBaseActivity;
import com.qk.applibrary.activity.QkActivity;

public class MainActivity extends QkActivity implements View.OnClickListener {
    public static MainActivity mInstace = null;
    private Context mContext;
    private RelativeLayout topbarView;
    private RelativeLayout androidBaseRl;  //2Android基础



    /**
     * 加载布局
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        mInstace = this;
        mContext = this;
        topbarView = (RelativeLayout) findViewById(R.id.rl_top_bar_view);
        androidBaseRl = (RelativeLayout) findViewById(R.id.android_base_rl);

    }

    @Override
    public void initData() {

    }

    @Override
    public void addListeners() {
        androidBaseRl.setOnClickListener(MainActivity.this);


    }

    private long mExitTime = 0;

    // 程序退出时的操作
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                // Object mHelperUtils;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                MainActivity.mInstace.finish();
                android.os.Process.killProcess(android.os.Process.myPid());

            }

        }
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.android_base_rl:
                startActivity(new Intent(mContext,AndroidBaseActivity.class));
                break;

        }

    }
}
