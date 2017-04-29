package com.cuileikun.androidbase.activity.seventh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.receiver.FinalReceiver;

/**
 * Created by Admin on 2017/4/29.
 */

public class XidadaFenRiceEightActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xidada_fen_rice);
    }
    //点击按钮 发大米
    public void click(View v) {

        Intent intent = new Intent();
        /**
         * resultReceiver最终receiver 一会详细说
         */
        intent.setAction("com.itheima.rice");

        //发送了一条有序广播
        sendOrderedBroadcast(intent, null, new FinalReceiver(), null, 1, "习大大给每个村民发1000斤大米", null);



    }
}
