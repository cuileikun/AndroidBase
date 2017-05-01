package com.cuileikun.androidbase.activity.nine;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class UseNeirongJiexiActivity extends Activity {
    private EditText et_name;
    private EditText et_email;
    private EditText et_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_nei_rong_jiexi);
        // [1]找到我们关心的控件
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
    }

    // 点击按钮 往联系人的数据库 插入联系人的信息
    public void click(View v) {
        // [2]获取数据
        String email = et_email.getText().toString().trim();
        String name = et_name.getText().toString().trim();
        String phone = et_phone.getText().toString().trim();

        // [3] 把name phone email 插入到联系人 的数据库
        Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
        Uri dataUri = Uri.parse("content://com.android.contacts/data");

        // [3.1]往raw_contacts 表插入数据之前 先查询一下 一共有几条数据 +1 就是contact_id的值
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        int count = cursor.getCount();
        int contact_id = count + 1;
        ContentValues values = new ContentValues();
        values.put("contact_id", contact_id);
        getContentResolver().insert(uri, values); // 往raw_contact表 加入联系人id

        // [3.2]把name插入到data表
        ContentValues nameValues = new ContentValues();
        nameValues.put("raw_contact_id", contact_id); // 你插入的数据 属于哪个联系人
        nameValues.put("data1", name); // 把数据插入到data1列
        nameValues.put("mimetype", "vnd.android.cursor.item/name");// 插入的数据
        // 的数据类型
        getContentResolver().insert(dataUri, nameValues);
        // [3.3]插入邮箱
        ContentValues emailValues = new ContentValues();
        emailValues.put("raw_contact_id", contact_id); // 你插入的数据 属于哪个联系人
        emailValues.put("data1", email); // 把数据插入到data1列
        emailValues.put("mimetype", "vnd.android.cursor.item/email_v2");// 插入的数据
        getContentResolver().insert(dataUri, emailValues);

        // [3.3]插入电话号码
        ContentValues phoneValues = new ContentValues();
        phoneValues.put("raw_contact_id", contact_id); // 你插入的数据 属于哪个联系人
        phoneValues.put("data1", phone); // 把数据插入到data1列
        phoneValues.put("mimetype", "vnd.android.cursor.item/phone_v2");// 插入的数据
        getContentResolver().insert(dataUri, phoneValues);


    }



}
