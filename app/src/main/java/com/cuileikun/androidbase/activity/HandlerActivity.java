package com.cuileikun.androidbase.activity;

import android.widget.TextView;

import com.cuileikun.androidbase.R;
import com.qk.applibrary.activity.QkActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 作者：popular cui
 * 时间：2017/4/24 17:19
 * 功能:5_handler_api
 */
public class HandlerActivity extends QkActivity {
    private Timer timer;
    private TimerTask task;
    private TextView tv;

    @Override
    public void initViews() {
        super.initViews();
        tv = (TextView) findViewById(R.id.tv);


        //3秒钟后执行 run方法
    /*	new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				tv.setText("哈哈哈");

			}
		}, 5000);*/

        timer = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    public void run() {
                        tv.setText("哈哈哈呵呵呵 嘿嘿");
                    }
                });


            }
        };
        //5秒钟后 执行run方法
        timer.schedule(task, 5000);


    }

    //当Activity销毁的时候执行
    @Override
    protected void onDestroy() {
        timer.cancel();
        task.cancel();

        super.onDestroy();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_handler;
    }
}
