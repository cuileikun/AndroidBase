package com.cuileikun.androidbase.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.cuileikun.androidbase.R;
import com.qk.applibrary.activity.QkActivity;

/**
 * 作者：popular cui
 * 时间：2017/4/27 20:46
 * 功能:androidbase six
 */
public class AndroidBaseSixActivity extends QkActivity implements View.OnClickListener {

    private Button btn_new_activity;
    private Button btn_ren_pin_calculator;
    private Button btn_all_message;
    private Button btn_send_message;
    private Button btn_activity_life;
    private Button btn_android_transparent_use;
    private Button btn_activity_start_method;

    @Override
    public void initViews() {
        super.initViews();
        btn_new_activity = (Button) findViewById(R.id.btn_new_activity);
        btn_ren_pin_calculator = (Button) findViewById(R.id.btn_ren_pin_calculator);
        btn_all_message = (Button) findViewById(R.id.btn_all_message);
        btn_send_message = (Button) findViewById(R.id.btn_send_message);
        btn_activity_life = (Button) findViewById(R.id.btn_activity_life);
        btn_android_transparent_use = (Button) findViewById(R.id.btn_android_transparent_use);
        btn_activity_start_method = (Button) findViewById(R.id.btn_activity_start_method);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        btn_new_activity.setOnClickListener(AndroidBaseSixActivity.this);
        btn_ren_pin_calculator.setOnClickListener(AndroidBaseSixActivity.this);
        btn_all_message.setOnClickListener(AndroidBaseSixActivity.this);
        btn_send_message.setOnClickListener(AndroidBaseSixActivity.this);
        btn_activity_life.setOnClickListener(AndroidBaseSixActivity.this);
        btn_android_transparent_use.setOnClickListener(AndroidBaseSixActivity.this);
        btn_activity_start_method.setOnClickListener(AndroidBaseSixActivity.this);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_android_base_six;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_new_activity:
                startActivity(new Intent(AndroidBaseSixActivity.this, NewActivity.class));
                break;
            case R.id.btn_ren_pin_calculator:
                startActivity(new Intent(AndroidBaseSixActivity.this, RenPinCalculatorActivity.class));
                break;
            case R.id.btn_all_message:
                startActivity(new Intent(AndroidBaseSixActivity.this, AllMessageActivity.class));
                break;
            case R.id.btn_send_message:
                startActivity(new Intent(AndroidBaseSixActivity.this, SendMessageActivity.class));
                break;
            case R.id.btn_activity_life:
                startActivity(new Intent(AndroidBaseSixActivity.this, LifeActivity.class));
                break;
            case R.id.btn_android_transparent_use:
                startActivity(new Intent(AndroidBaseSixActivity.this, TransparentUseActivity.class));
                break;
            case R.id.btn_activity_start_method:
                startActivity(new Intent(AndroidBaseSixActivity.this, StartMethodActivity.class));
                break;
        }
    }
}
