package com.cuileikun.androidbase.activity.ten;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class DealImageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_image);

        ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
        ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);

        //[1]把tomcat.png 展示到iv_src上
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tomcat);

        //注意 修改原图  原图不可以修改

        //	srcBitmap.setPixel(30, 40, Color.RED);
        iv_src.setImageBitmap(srcBitmap);

        //[2]创建一个原图的副本
        //[2.1]创建一个模板  大小和原图一样    相当于创建了一张空白的白纸
        Bitmap copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
        //[2.2]作画需要画笔
        Paint paint = new Paint();
        //[2.3]需要一个画布   相当于把白纸铺到了画布上
        Canvas canvas = new Canvas(copyBitmap);
        //[2.4]开始作画
        Matrix matrix = new Matrix();

        //对图片进行旋转
//		matrix.setRotate(20, srcBitmap.getWidth()/2, srcBitmap.getHeight()/2);


        //对图片进行缩放
//		matrix.setScale(0.5f, 0.5f);

        //对图片进行平移
//		matrix.setTranslate(20, 0);

        //实现镜面效果   就是使用缩放和平移的一个组合
//        matrix.setScale(-1.0f, 1.0f);
        //post是在上一次修改的基础上 再次修改  set每次修改都是最新的 会覆盖上一次修改
//        matrix.postTranslate(srcBitmap.getWidth(), 0);
//		matrix.setTranslate();


        //倒影效果
        matrix.setScale(1.0f, -1.0f);
        matrix.postTranslate(0, srcBitmap.getHeight());


        canvas.drawBitmap(srcBitmap, matrix, paint);

        //修改副本  副本可以修改
        //[3]把copybitmap展示到iv_copy上
        iv_copy.setImageBitmap(copyBitmap);


    }
}
