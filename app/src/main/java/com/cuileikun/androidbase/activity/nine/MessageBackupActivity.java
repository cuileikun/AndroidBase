package com.cuileikun.androidbase.activity.nine;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Xml;
import android.view.View;
import android.widget.Toast;

import com.cuileikun.androidbase.R;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Admin on 2017/4/29.
 */

public class MessageBackupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_backup);
    }
    //点击按钮实现 短信的备份
    public void click1(View v) {

        try {
            //[1]获取xml序列化器
            XmlSerializer serializer = Xml.newSerializer();
            //[2]设置序列化器的参数
            File file = new File(Environment.getExternalStorageDirectory().getPath(),"smsBackUp.xml");
            FileOutputStream fos = new FileOutputStream(file);
            serializer.setOutput(fos, "utf-8");
            //[3]设置xml文档的开头
            serializer.startDocument("utf-8", true);
            //[4]写xml 的根节点
            serializer.startTag(null, "smss");
            //[5]由于短信数据库 系统以及通过内容提供者暴露出来 所以 我们可以直接通过内容解析者操作数据库
            Uri uri = Uri.parse("content://sms/");
            //projection 查询的列
            Cursor cursor = getContentResolver().query(uri, new String[]{"address","date","body"}, null, null, null);
            while(cursor.moveToNext()){
                String address = cursor.getString(0);
                String date = cursor.getString(1);
                String body = cursor.getString(2);
                //[6]写xml的 sms节点
                serializer.startTag(null, "sms");
                //[7]写address 节点
                serializer.startTag(null, "address");
                serializer.text(address);  //这里的内容就是从数据库里面查询出来的吧
                serializer.endTag(null, "address");


                //[8]写body 节点
                serializer.startTag(null, "body");
                serializer.text(body);  //这里的内容就是从数据库里面查询出来的吧
                serializer.endTag(null, "body");

                //[9]写date 节点
                serializer.startTag(null, "date");
                serializer.text(date);  //这里的内容就是从数据库里面查询出来的吧
                serializer.endTag(null, "date");

                serializer.endTag(null, "sms");
            }

            serializer.endTag(null, "smss");
            serializer.endDocument();
            fos.close(); //关闭流

            Toast.makeText(getApplicationContext(), "备份成功", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "备份失败", Toast.LENGTH_SHORT).show();
        }

    }

    //点击按钮 往短信数据库里面插入数据
    public void click2(View v) {
        //短信的数据库 系统以及通过内容的提供者把数据暴露出来 所以我们可以直接通过内容解析者去操作数据库
        Uri uri = Uri.parse("content://sms/");
        ContentValues values = new ContentValues();
        values.put("address", "110");
        values.put("body", "请你马上过来一趟 ....");
        values.put("date", System.currentTimeMillis());
        getContentResolver().insert(uri, values);

        //TODO  把还原短信的逻辑给我写写


    }
}
