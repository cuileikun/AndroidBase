package com.cuileikun.androidbase.activity.third;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cuileikun.androidbase.R;
import com.qk.applibrary.activity.QkActivity;

/**
 * 作者：popular cui
 * 时间：2017/4/19 14:50
 * 功能:ArrayAdapter
 */
public class ArrayAdapterActivity extends QkActivity {
    @Override
    public void initViews() {
        String[] cities  = new String[]{"上海","北京","哈尔滨","广州","杭州","台湾","钓鱼岛","东京","天津","深圳"};
        ListView lv = (ListView) findViewById(R.id.lv);
		/*
		 * 参数1:上下文
		 * 参数2:系统布局资源idandroid.R.layout.simple_list_item_1
		 * 参数3:数组或则集合
		 */
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_array_adapter;
    }
}
