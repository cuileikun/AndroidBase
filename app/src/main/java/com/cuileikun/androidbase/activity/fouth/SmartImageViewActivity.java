package com.cuileikun.androidbase.activity.fouth;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.view.MySmartImageView;
import com.qk.applibrary.activity.QkActivity;

/**
 * 作者：popular cui
 * 时间：2017/4/24 17:19
 * 功能:7_自定义smartimageview
 */
public class SmartImageViewActivity extends QkActivity{
    @Override
    public void initViews() {
        super.initViews();
        MySmartImageView my_smart_view = (MySmartImageView) findViewById(R.id.my_smart_view);
        my_smart_view.setImageUrl("http://localhost:8080/tomcat.png");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_smart_image_view;
    }

}
