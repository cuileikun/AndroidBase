package com.cuileikun.androidbase.activity.eleven;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class AutoCompleteTextViewActivity extends Activity {
    //[0]准备actv 要显示的内容
    private static final String[] COUNTRIES = new String[] {
            "laoli", "laofang", "laozhang", "laobi", "laofeng","aa","abb","cc"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        //[1]找到控件
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.actv);

        //[2]AutoCompleteTextView 展示数据 也需要一个数据适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);

        //[3]设置数据适配器
        actv.setAdapter(adapter);
    }
}
