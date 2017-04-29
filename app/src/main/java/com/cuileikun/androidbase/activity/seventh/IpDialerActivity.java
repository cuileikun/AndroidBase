package com.cuileikun.androidbase.activity.seventh;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class IpDialerActivity extends Activity {
    private EditText et_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_dialer);
        initView();
    }

    private void initView() {
        et_number = (EditText) findViewById(R.id.et_ipnumber);
    }

    //点击按钮  保存ipnumber
    public void click(View v) {
        //[1]获取number
        String ipNumber = et_number.getText().toString().trim();

        //[2]把ipnumber存起来   获取sp实例
        SharedPreferences sp = getSharedPreferences("config", 0);
        //[2.1]获取sp的编辑器
        sp.edit().putString("ipnumber", ipNumber).commit();
        Toast.makeText(getApplicationContext(), "保存成功", 1).show();

    }


}
