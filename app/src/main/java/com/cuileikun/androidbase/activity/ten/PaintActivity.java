package com.cuileikun.androidbase.activity.ten;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.cuileikun.androidbase.R;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Admin on 2017/4/29.
 */

public class PaintActivity extends Activity {
    private Bitmap srcbiBitmap;
    private Bitmap alterBitmap;
    private Paint paint;
    private Canvas canvas;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        iv = (ImageView) findViewById(R.id.iv);
        //[1]获取原图
        srcbiBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        //[2]创建副本   相当于你创建了一个空白的白纸
        alterBitmap = Bitmap.createBitmap(srcbiBitmap.getWidth(), srcbiBitmap.getHeight(), srcbiBitmap.getConfig());
        //[2.1]想要作画 需要一个画笔
        paint = new Paint();
        //[2.2]需要一个画布  把白纸铺到画布上
        canvas = new Canvas(alterBitmap);
        //[2.3]开始作画
        canvas.drawBitmap(srcbiBitmap, new Matrix(), paint);

        //[2.3.1]画一条线
        //canvas.drawLine(30, 40, 70, 80, paint);

        //[3]把alterbitmap显示到iv上
        iv.setImageBitmap(alterBitmap);

        //[4]给iv设置一个触摸的事件
        iv.setOnTouchListener(new View.OnTouchListener() {
            int startX = 0;
            int startY = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //[5]监听手指的触摸事件
                int action = event.getAction();
                //[6]具体判断一下 是什么事件
                switch (action) {
                    case MotionEvent.ACTION_DOWN: //按下


                        startX = (int) event.getX();
                        startY = (int) event.getY();
                        System.out.println("手指按下了.."+startX+"----"+startY);

                        break;

                    case MotionEvent.ACTION_MOVE: //移动


                        int stopX = (int) event.getX();
                        int stopY = (int) event.getY();

                        canvas.drawLine(startX, startY, stopX, stopY, paint);

                        //要更新一下 iv
                        iv.setImageBitmap(alterBitmap);
                        //改变一下起始点的坐标
                        startX = stopX;
                        startY = stopY;


                        break;

                    case MotionEvent.ACTION_UP:   //抬起

                        break;
                }


                //True if the listener has consumed the event, false otherwise.
                return true;
            }
        });



    }

    //点击按钮 实现画笔变红色
    public void click1(View v) {

        //设置画笔为红色
        paint.setColor(Color.RED);
    }

    //点击按钮 设置画笔加粗
    public void click2(View v) {
        paint.setStrokeWidth(20);
    }

    //点击按钮 保存图片
    public void click3(View v) {
        try {
            //注意 我们画的东西 都在alterbitmap里面   format保存图片的格式   quality质量   SystemClock.uptimeMillis()系统的开机时间
            File file = new File(Environment.getExternalStorageDirectory().getPath(), SystemClock.uptimeMillis()+".png");
            FileOutputStream fos = new FileOutputStream(file);
            alterBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();//关闭流
            //发送一条关闭 欺骗一下系统图库应用 说sd卡被挂载了 你去加载图片吧
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
            intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
            sendBroadcast(intent);//发送广播


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
