package com.cuileikun.androidbase.activity.eleven;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class MenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    // 添加一个menu菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // [1]添加菜单的方式
//		getMenuInflater().inflate(R.menu.main, menu);

        // [2]直接通过代码的方式
        menu.add(0, 1, 0, "前进");
        menu.add(0, 2, 0, "后退");
        menu.add(0, 3, 0, "首页");

        return true;
    }

    //想知道点击的是哪个menu的item 需要重写这个方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1:

                System.out.println("11111");
                break;

            case 2:

                System.out.println("2222");
                break;

            case 3:

                System.out.println("3333");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //小技巧   重写onMenuOpened
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {


        //这个方法里面 实现自己想添加的内容
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提醒");
        builder.setMessage("是否清除旧的短信");
        builder.setPositiveButton("确定清除", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        builder.setNegativeButton("不清除", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //一定要记得 show出来
        builder.show();



        return false;
    }




}
