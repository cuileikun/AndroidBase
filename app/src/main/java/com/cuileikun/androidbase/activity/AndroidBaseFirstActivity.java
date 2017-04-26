package com.cuileikun.androidbase.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.utils.PermissionUtil;
import com.cuileikun.androidbase.utils.PermissionsChecker;
import com.qk.applibrary.activity.QkActivity;
import com.qk.applibrary.util.CommonUtil;

import java.util.ArrayList;

/**
 * 作者：popular cui
 * 时间：2017/4/17 15:49
 * 功能:AndroidBase 01
 */
public class AndroidBaseFirstActivity extends QkActivity implements View.OnClickListener {
    private Context mContext;
    private Button btn_call_phone;
    private Button btn_send_message;
    private Button btn_click;
    private EditText et_num;
    private EditText et_num_second;
    private EditText et_sms;
    private EditText et_num_third;
    private Button btn_call_phone_dial;

    @Override
    public void initViews() {
        mContext = this;
        // 6.0动态权限三部曲第一步 拨打电话的权限
        grantPermission();
        et_num = (EditText) findViewById(R.id.et_num);
        btn_call_phone = (Button) findViewById(R.id.btn_call_phone);

        et_num_second = (EditText) findViewById(R.id.et_num_second);
        et_sms = (EditText) findViewById(R.id.et_sms);
        btn_send_message = (Button) findViewById(R.id.btn_send_message);

        btn_click = (Button) findViewById(R.id.btn_click);

        et_num_third = (EditText) findViewById(R.id.et_num_third);
        btn_call_phone_dial = (Button) findViewById(R.id.btn_call_phone_dial);

    }


    @Override
    public void addListeners() {
        btn_call_phone.setOnClickListener(AndroidBaseFirstActivity.this);
        btn_send_message.setOnClickListener(AndroidBaseFirstActivity.this);
        btn_click.setOnClickListener(AndroidBaseFirstActivity.this);
        btn_call_phone_dial.setOnClickListener(AndroidBaseFirstActivity.this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_android_base_first;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_call_phone:
                doCallPhone();
                break;
            case R.id.btn_call_phone_dial:
                doCallPhoneDial();
                break;

            case R.id.btn_send_message:

                String phonenum = et_num_second.getText().toString().trim();
                String sms = et_sms.getText().toString();
                if (TextUtils.isEmpty(phonenum) || TextUtils.isEmpty(sms)) {
                    //提示用户
                    Toast.makeText(AndroidBaseFirstActivity.this, "电话或者短信不能为空!", Toast.LENGTH_SHORT).show();
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
                CommonUtil.sendToast(mContext, "短信已发送");
                break;

//            case R.id.btn_click:
//
//                break;

        }


    }

    /**
     * ACTION_DIAL
     * ACTION_DIAL 拨打一个指定的号码，显示一个带有号码的用户界面，允许用户去启动呼叫
     * ACTION_CALL 根据指定的数据执行一次呼叫
     * ACTION_CALL_PRIVILEGED 我只知道是系统专属，是个private API，程序员几乎不用……
     * （ACTION_CALL在应用中启动一次呼叫有缺陷，多数应用ACTION_DIAL，ACTION_CALL不能用在紧急呼叫上，紧急呼叫可以用ACTION_DIAL来实现）
     */
    private void doCallPhoneDial() {
        String num = et_num_third.getText().toString().trim();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * ACTION_CALL
     * ACTION_DIAL 拨打一个指定的号码，显示一个带有号码的用户界面，允许用户去启动呼叫
     * ACTION_CALL 根据指定的数据执行一次呼叫
     * ACTION_CALL_PRIVILEGED 我只知道是系统专属，是个private API，程序员几乎不用……
     * （ACTION_CALL在应用中启动一次呼叫有缺陷，多数应用ACTION_DIAL，ACTION_CALL不能用在紧急呼叫上，紧急呼叫可以用ACTION_DIAL来实现）
     */
    private void doCallPhone() {

        /**
         * 需要打电话的时候再调用这个方法
         * 6.0动态申请权限第三步
         */
        if (PermissionsChecker.checkIsLacksPermission(mContext, Manifest.permission.CALL_PHONE)) {
            CommonUtil.sendToast(mContext, "请打开拨打电话的权限");
            return;
        }
        String num = et_num.getText().toString().trim();
        //创建一个Intent
        Intent intent = new Intent();
        //设置我们的动作(Action)
        intent.setAction(Intent.ACTION_CALL);
        //设置数据URL :http://www.baidu.com
        Uri data = Uri.parse("tel:" + num);
        intent.setData(data);//uri
        //启动Activity
        startActivity(intent);
    }


    /**
     * 1. 访问权限修饰符必须是public
     * 2. 形参必须是View
     * 3. 方法名必须跟  android:onClick="xxxx"中的xxxx保持一致
     *
     * @param view
     */
    public void btnClick(View view) {
        Toast.makeText(this, "第四种方式我被点击了=" + view, Toast.LENGTH_LONG).show();
    }

    /**
     * 6.0动态申请权限第一步
     */
    private void grantPermission() {
        PermissionUtil.requestPermissions(this,
                new String[]{
                        Manifest.permission.CALL_PHONE,
                });
    }

    /**
     * 6.0动态申请权限第二步
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i = 0; i < permissions.length; i++) {
            if (permissions[i] == Manifest.permission.CALL_PHONE) {
                if (grantResults[i] != 0) {
                    CommonUtil.sendToast(mContext, "请打开拨打电话的权限");
                }
            }
        }
    }
}
