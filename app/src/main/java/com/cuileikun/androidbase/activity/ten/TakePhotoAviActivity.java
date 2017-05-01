package com.cuileikun.androidbase.activity.ten;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.cuileikun.androidbase.R;

import java.io.File;

/**
 * Created by Admin on 2017/4/29.
 */

public class TakePhotoAviActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo_avi);
    }

    //点击按钮实现照相和录像
    public void click1(View v) {
        //[1]创建意图  设置action 开启系统的照相机应用
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //[2]照相后保存 图片  把图片保存到sd上
//        File file = new File(Environment.getExternalStorageDirectory().getPath(),"test1.png");
        File file = new File("mnt/sdcard","test1.png");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file)); // set the image file name

        //[3]开启一个Activity 想要另外一个界面结果
        startActivityForResult(intent, 1);


    }



    //点击按钮实现照相和录像
    public void click2(View v) {
        //[1]创建意图  设置action 开启系统的照相机应用
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        //[2]照相后保存 图片  把图片保存到sd上
//        File file = new File(Environment.getExternalStorageDirectory().getPath(),"test1.3gp");
        File file = new File("mnt/sdcard/","test1.3gp");

        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file)); // set the image file name

        //[3]开启一个Activity 想要另外一个界面结果
        startActivityForResult(intent, 1);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
    }


}
