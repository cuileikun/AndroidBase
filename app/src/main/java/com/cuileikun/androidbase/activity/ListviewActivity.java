package com.cuileikun.androidbase.activity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cuileikun.androidbase.R;
import com.qk.applibrary.activity.QkActivity;

import java.util.ArrayList;

/**
 * 作者：popular cui
 * 时间：2017/4/19 14:49
 * 功能:listview
 */
public class ListviewActivity extends QkActivity {
    private ListView lv;
    private ArrayList<String> cities;

    @Override
    public void initViews() {
        //模拟数据

        cities = new ArrayList<String>();
        for(int i=0;i<100000;i++){
            cities.add("上海"+i);
        }

        //1初始化控件
        lv = (ListView) findViewById(R.id.lv);
        //快速滑动条
        lv.setFastScrollEnabled(true);
        //2.设置适配器
        lv.setAdapter(new MyAdapter());
    }
    class MyAdapter extends BaseAdapter {

        /*
         * 返回ListView的条目的个数
         */
        @Override
        public int getCount() {
            return cities.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        /*
         * 参数1:listView条目的位置
         * 参数2:复用的View
         * 参数3:listView本身
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.d("tag", "postion=" + position + "//convertView=" + convertView);
            TextView textView = null;
            if (convertView == null) {
                textView = new TextView(ListviewActivity.this);
            } else {
                textView = (TextView) convertView;
            }
            String city = cities.get(position);
            textView.setText(city);
            return textView;
        }
    }
    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_listview;
    }
}
