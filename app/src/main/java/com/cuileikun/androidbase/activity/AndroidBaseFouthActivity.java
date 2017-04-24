package com.cuileikun.androidbase.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.cuileikun.androidbase.R;
import com.qk.applibrary.activity.QkActivity;

/**
 * 作者：popular cui
 * 时间：2017/4/24 17:02
 * 功能:androidbase day04
 */
public class AndroidBaseFouthActivity extends QkActivity implements View.OnClickListener {

    private Button btn_yuan_ma;//1_源码查看器
    private Button btn_anr;//2_演示anr
    private Button btn_look_picture;//3_图片查看器
    private Button btn_modify_look_picture;//4_使用runonuiThread修改图片查看器
    private Button btn_handler_api;//5_handler_api
    private Button btn_news;//6_新闻客户端
    private Button btn_smartimageview;//7_自定义smartimageview

    @Override
    public void initViews() {
        super.initViews();
        btn_yuan_ma = (Button) findViewById(R.id.btn_yuan_ma);
        btn_anr = (Button) findViewById(R.id.btn_anr);
        btn_look_picture = (Button) findViewById(R.id.btn_look_picture);
        btn_modify_look_picture = (Button) findViewById(R.id.btn_modify_look_picture);
        btn_handler_api = (Button) findViewById(R.id.btn_handler_api);
        btn_news = (Button) findViewById(R.id.btn_news);
        btn_smartimageview = (Button) findViewById(R.id.btn_smartimageview);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_yuan_ma:
                startActivity(new Intent(AndroidBaseFouthActivity.this,YuanMaActivity.class));
                break;
            case R.id.btn_anr:
                startActivity(new Intent(AndroidBaseFouthActivity.this,AnrActivity.class));
                break;
            case R.id.btn_look_picture:
                startActivity(new Intent(AndroidBaseFouthActivity.this,LookPictureActivity.class));
                break;
            case R.id.btn_modify_look_picture:
                startActivity(new Intent(AndroidBaseFouthActivity.this,ModifyLookPictureActivity.class));
                break;
            case R.id.btn_handler_api:
                startActivity(new Intent(AndroidBaseFouthActivity.this,HandlerActivity.class));
                break;
            case R.id.btn_news:
                startActivity(new Intent(AndroidBaseFouthActivity.this,NewsActivity.class));
                break;
            case R.id.btn_smartimageview:
                startActivity(new Intent(AndroidBaseFouthActivity.this,SmartImageViewActivity.class));
                break;
        }
    }

    @Override
    public void addListeners() {
        super.addListeners();
        btn_yuan_ma.setOnClickListener(AndroidBaseFouthActivity.this);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_android_base_fouth;
    }


}
