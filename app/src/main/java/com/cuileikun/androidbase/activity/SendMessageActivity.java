package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cuileikun.androidbase.R;
import com.qk.applibrary.util.CommonUtil;

import java.util.ArrayList;

/**
 * 作者：popular cui
 * 时间：2017/4/27 21:01
 * 功能:
 */
public class SendMessageActivity extends Activity {
    private EditText et_name;
    private EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        //[1]找到我们关心的控件

        et_name = (EditText) findViewById(R.id.et_name);
        et_content = (EditText) findViewById(R.id.et_content);
    }


    //点击按钮跳转到 ContactActivity 页面  用显示意图
    public void add(View v) {
        //[1]创建意图
        Intent intent = new Intent(this, ContactActivityThird.class);
        //[2]注意 当开启一个Activity  我需要开启这个Activity的数据  应该使用下面这个方法
        startActivityForResult(intent, 1);

    }

    //点击按钮跳转到 短信模板页面
    public void insert(View v) {
        Intent intent = new Intent(this, SmsTempleateActivity.class);
        startActivityForResult(intent, 2);

    }

    public void send(View view) {
        String phonenum = et_name.getText().toString().trim();
        String sms = et_content.getText().toString();
        if (TextUtils.isEmpty(phonenum) || TextUtils.isEmpty(sms)) {
            //提示用户
            Toast.makeText(SendMessageActivity.this, "电话或者短信不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        //获取SmsManager对象
        SmsManager smsManager = SmsManager.getDefault();
        //拆分短信
        ArrayList<String> divideMessage = smsManager.divideMessage(sms);
        //发送
                /*
                 * 参数1:对方的号码
				 * 参数2:短信中心号码
				 * 参数3:短信内容
				 * 参数4:是否发送成功
				 * 参数5:是否接收到
				 */
        smsManager.sendMultipartTextMessage(phonenum, null, divideMessage, null, null);
        CommonUtil.sendToast(SendMessageActivity.this, "短信已发送");


    }

    //这个方法当startActivityForResult开启的Activity 的页面关闭的时候 就调用这个方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            /*if (resultCode == 10) {
                //说明结果数据 来源于联系人页面
				String phone = data.getStringExtra("phone");
				//把phone设置到 editText上
				et_name.setText(phone);
			}else if (resultCode == 20) {
				//说明结果数据来源于 短信模板页面
				String smscontent = data.getStringExtra("smscontent");
				et_content.setText(smscontent);
			}
			*/


        if (requestCode == 1) {
            //说明 我要请求联系人页面的数据
            //说明结果数据 来源于联系人页面
            String phone = data.getStringExtra("phone");
            //把phone设置到 editText上
            et_name.setText(phone);
        } else if (requestCode == 2) {
            //说明 我要请求短信模板页面的数据
            String smscontent = data.getStringExtra("smscontent");
            et_content.setText(smscontent);
        }


    }

}
