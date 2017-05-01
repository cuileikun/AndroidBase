package com.cuileikun.androidbase.activity.ten;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class LoadBigImageActivity extends Activity {
    private ImageView iv;
    private int width;
    private int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_big_image);
        // 用来显示大图片
        iv = (ImageView) findViewById(R.id.iv);

        // [1]获取手机的分辨率
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        //使用新的api 去获取宽和高
		/*Point point = new Point();
		wm.getDefaultDisplay().getSize(point);
		int width = point.x;
		int height = point.y;*/
        System.out.println("手机的宽width:" + width + "--^^^--" + height);
    }

    // 点击按钮 加载大图片
    @SuppressLint("SdCardPath")
    public void click(View v) {
        //[2]创建位图工厂的配置参数
        BitmapFactory.Options opts = new BitmapFactory.Options();
        //不去真正的解析位图  返回null  但是还能够获取图片的宽和高的信息
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile("/mnt/sdcard/ic_launcher.png",opts);

        //[3]获取图片的宽和高
        int imgWidth = opts.outWidth;
        int imgHeight = opts.outHeight;
        System.out.println("图片的宽:"+imgWidth+"----"+imgHeight);

        //[4]计算缩放比
        int scale = 1; //定义变量 就是我们的缩放比
        int scaleX = imgWidth/width;
        int scaleY = imgHeight/height;

        if (scaleX>=scaleY && scaleX>scale) {
            scale = scaleX;
        }
        if (scaleY > scaleX && scaleY >scale) {
            scale = scaleY;
        }
        System.out.println("缩放比为:"+scale);
        //[5]按照我们计算出来的缩放比进行显示
        opts.inSampleSize = scale;

        //[6]开始真正的解析位图
        opts.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile("/mnt/sdcard/ic_launcher.png",opts);

        //[7]显示到iv上
        iv.setImageBitmap(bitmap);

    }
}
