package com.cuileikun.androidbase.activity.ten;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class TearClothesActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tear_clothes);
        //找到iv
        final ImageView iv = (ImageView) findViewById(R.id.iv);

        //[1]找到我们要操作的原图
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pre19);

        //[2]创建原图的副本   相当于有了一张白纸
        final Bitmap alterBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
        //[2.1]创建一个画笔
        Paint paint = new Paint();
        //[2.2]创建一个画布   相当于把白纸铺到了 画布上
        Canvas canvas = new Canvas(alterBitmap);
        //[2.3]开始作画
        canvas.drawBitmap(srcBitmap, new Matrix(), paint);

        //把alterbitmap显示到 iv上
        iv.setImageBitmap(alterBitmap);

        //[3]给iv设置一个触摸事件
        iv.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_MOVE:  //移动事件
                        for (int i = -8; i < 8; i++) {  //增加X的坐标

                            for (int j = -8; j <8; j++) { //增加Y的坐标

                                //为了良好的用户体验  撕一个圆
                                if (Math.sqrt(i*i+j*j)<8) {
                                    try {
                                        alterBitmap.setPixel((int)event.getX()+i, (int)event.getY()+j, Color.TRANSPARENT);
                                    } catch (Exception e) {
                                    }
                                }

                            }

                        }

                        //更新iv
                        iv.setImageBitmap(alterBitmap);

                        break;
                }


                return true;
            }
        });

    }
}
