package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cuileikun.androidbase.R;

/**
 * 作者：popular cui
 * 时间：2017/4/27 21:00
 * 功能:
 */
public class RenPinCalculatorActivity extends Activity {
    private EditText et_name;
    private RadioGroup rg_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ren_pin);

        // [1]找到我们的控件

        et_name = (EditText) findViewById(R.id.et_name);
        rg_group = (RadioGroup) findViewById(R.id.radioGroup1);

    }

    // 点击按钮 实现获取数据 实现页面跳转
    public void click(View v) {
        // [1]获取name
        String name = et_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "name不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // [2]判断选择是哪个性别
        int checkedRadioButtonId = rg_group.getCheckedRadioButtonId();
        int sex = 0; //默认值
        switch (checkedRadioButtonId) {
            case R.id.rb_male: // 选中的是男

                sex = 1;
                break;

            case R.id.rb_female: // 选中的是女

                sex = 2;
                break;

            case R.id.rb_other: // 选中的人妖

                sex =3 ;
                break;

        }
        if (sex == 0) {
            //说明这个哥们 没有选中 性别
            Toast.makeText(getApplicationContext(), "请选择性别", Toast.LENGTH_SHORT).show();
            return;
        }

        //[3]跳转到结果页面
        Intent intent = new Intent(this,ResultActivity.class);

        //[3.1]把name 和 sex 传递到ResultActivity
        intent.putExtra("name", name);  //实际上就是通过map传递的
        intent.putExtra("sex", sex);
        //[3]开启Activity
        startActivity(intent);


    }

}
