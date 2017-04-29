package com.cuileikun.androidbase.activity.seventh;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class DialogActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    // 点击按钮 实现一个普通对话框
    public void click1(View v) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("警告");
        dialog.setMessage("世界上最遥远的距离是没有网络");
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("点击了确定按钮");
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("说明你点击了取消按钮 ");
            }
        });
        // 最后一步 和Toast一样 一定要记得show出来
        dialog.show();

    }

    // 点击按钮 实现一个单选对话框
    public void click2(View v) {

        // 构造对话框
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("请选择您喜欢的课程");

        final String items[] = { "Android", "C语言", "html", "css", "js", "ios" };
        // 设置单选条目
        dialog.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // [1]把你选中的条目的数据取出来
                String item = items[which];
                // [2]关闭对话框
                dialog.dismiss();

                // [3]弹出土司
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();

            }
        });

        // 最后一步 和Toast一样 一定要记得show出来
        dialog.show();

    }

    // 点击按钮 实现一个多选对话框
    public void click3(View v) {
        // 构造对话框
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("选择您喜欢的水果");

        final String[] items = {"香蕉","苹果","黄瓜","榴莲","胡萝卜","火龙果","西瓜"};
        final boolean[] checkedItems = {true,false,false,false,false,false,true};
        dialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });

        //添加一个确定按钮
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuffer sb = new StringBuffer();
                //[1]获取 选中的水果
                for (int i = 0; i < checkedItems.length; i++) {
                    if (checkedItems[i]) {

                        String fruit = items[i];
                        sb.append(fruit+" ");
                    }


                }
                //关闭对话框
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();


            }
        });

        // 最后一步 和Toast一样 一定要记得show出来
        dialog.show();

    }

    //点击按钮 弹出进度条对话框
    public void click4(View v){
        final ProgressDialog dialog = new ProgressDialog(this);
        //设置进度条的样式
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        dialog.setMessage("正在玩命加载ing");
        dialog.show();

        //注意 与进度相关的控件都可以直接在子线程更新ui
        //创建一个子线程
        new Thread() {
            public void run() {

                //设置进度条总进度
                dialog.setMax(100);

                for (int i = 0; i <= 100; i++) {

                    //睡眠50毫秒
                    SystemClock.sleep(50);
                    //设置当前进度
                    dialog.setProgress(i);

                }
                //关闭对话框
                dialog.dismiss();


            };
        }.start();


    }
}
