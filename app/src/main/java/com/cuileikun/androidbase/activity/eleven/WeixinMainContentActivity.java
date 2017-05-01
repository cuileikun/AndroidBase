package com.cuileikun.androidbase.activity.eleven;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.fragment.ContactFragment;
import com.cuileikun.androidbase.fragment.DiscoverFragment;
import com.cuileikun.androidbase.fragment.MeFragment;
import com.cuileikun.androidbase.fragment.WxFragment;

/**
 * Created by Admin on 2017/4/29.
 */

public class WeixinMainContentActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wei_xin_main_content);
        // [1]找到我们关心的控件
        Button btn_wx = (Button) findViewById(R.id.btn_wx);
        Button btn_contact = (Button) findViewById(R.id.btn_contact);
        Button btn_discover = (Button) findViewById(R.id.btn_discover);
        Button btn_me = (Button) findViewById(R.id.btn_me);
        // [2]给按钮设置点击事件
        btn_contact.setOnClickListener(this);
        btn_discover.setOnClickListener(this);
        btn_me.setOnClickListener(this);
        btn_wx.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // [3]具体判断一下点击的是哪个按钮


        //[4]获取Fragment的管理者
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.btn_wx: // 说明点击了微信按钮

                beginTransaction.replace(R.id.ll, new WxFragment());
                break;

            case R.id.btn_contact: // 说明点击了通讯录
                beginTransaction.replace(R.id.ll, new ContactFragment());
                break;

            case R.id.btn_discover: // 说明点击了发现
                beginTransaction.replace(R.id.ll, new DiscoverFragment());
                break;

            case R.id.btn_me: // 说明点击了我
                beginTransaction.replace(R.id.ll, new MeFragment());
                break;
            default:
                beginTransaction.replace(R.id.ll, new WxFragment());
                break;


        }

        //最后一步 记得commit
        beginTransaction.commit();


    }
}
