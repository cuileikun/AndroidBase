package com.cuileikun.androidbase.activity.nine;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.db.MyOpenHeloer;

/**
 * Created by Admin on 2017/4/29.
 */

public class CreatePrivateDbActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_private_db);

        MyOpenHeloer myOpenHeloer = new MyOpenHeloer(getApplicationContext());
        SQLiteDatabase db = myOpenHeloer.getReadableDatabase();

        //把信息查询出来
        Cursor cursor = db.query("info", null, null, null, null, null, null);
        if (cursor!=null && cursor.getCount()>0) {
            while(cursor.moveToNext()){
                String name = cursor.getString(1);
                String money = cursor.getString(2);
                System.out.println("name:"+name+"---"+money);
            }

        }



    }
}
