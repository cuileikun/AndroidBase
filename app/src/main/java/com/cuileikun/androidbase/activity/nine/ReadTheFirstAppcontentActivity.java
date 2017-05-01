package com.cuileikun.androidbase.activity.nine;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class ReadTheFirstAppcontentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_the_first_appcontent);
        	/*	//读取 第一个应用数据库的内容
		SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cuileikun.androidbase/databases/Account.db", null, SQLiteDatabase.OPEN_READWRITE);
		//把信息查询出来
		Cursor cursor = db.query("info", null, null, null, null, null, null);
		if (cursor!=null && cursor.getCount()>0) {
			while(cursor.moveToNext()){
				String name = cursor.getString(1);
				String money = cursor.getString(2);
				System.out.println("~~~~~~~name:"+name+"---"+money);
			}

		}*/
    }

    //增加一条记录
    public void click1(View v) {
        //由于第一个应用程序的私有的数据库 已经通过内容提供者暴露来来了 所以该应用可以直接使用内容解析者 去操作数据库
        Uri uri = Uri.parse("content://com.itheima.provider/insert");
        ContentValues values = new ContentValues();
        //key:  对应表的列名
        //value:对应的值
        values.put("name", "王五");
        values.put("money", "20000");
        Uri uri2 = getContentResolver().insert(uri, values);
        System.out.println("uri2:::::"+uri2);


    }

    //删除一条记录
    public void click2(View v) {
        Uri uri = Uri.parse("content://com.itheima.provider/delete");
        int delete = getContentResolver().delete(uri, "name=?", new String[]{"王五"});
        Toast.makeText(getApplicationContext(), "删除了"+delete+"行", Toast.LENGTH_SHORT).show();

    }


    //更新一条记录
    public void click3(View v) {
        Uri uri = Uri.parse("content://com.itheima.provider/update");
        ContentValues values = new ContentValues();
        values.put("money", "2");
        int update = getContentResolver().update(uri, values, "name=?", new String[]{"王五"});
        Toast.makeText(getApplicationContext(), "更新了"+update+"行", Toast.LENGTH_SHORT).show();


    }

    //查询
    public void click4(View v) {
        //二  由于第一个应用程序的私有的数据库 已经通过内容提供者暴露来来了 所以该应用可以直接使用内容解析者 去操作数据库
        //[2.1]获取内容的解析者
        Uri uri = Uri.parse("content://com.itheima.provider/query");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor!=null && cursor.getCount()>0) {
            while(cursor.moveToNext()){
                String name = cursor.getString(1);
                String money = cursor.getString(2);
                System.out.println("~~~~^^^^^^~~~name:"+name+"---"+money);
            }

        }
    }




}
