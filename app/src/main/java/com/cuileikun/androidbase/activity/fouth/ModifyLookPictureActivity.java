package com.cuileikun.androidbase.activity.fouth;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cuileikun.androidbase.R;
import com.qk.applibrary.activity.QkActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 作者：popular cui
 * 时间：2017/4/24 17:19
 * 功能:4_使用runonuiThread修改图片查看器
 */
public class ModifyLookPictureActivity extends QkActivity {
    protected static final int REQUESTSUCESS = 0; // ctrl + shift + X(变大写)
    // +y(变小写)
    protected static final int REQUESTAIL = 1;
    protected static final int REQUESTEXCEPTION = 2;
    protected static final int CACHESUCESS = 3;

    private EditText et_path;
    private ImageView iv;

    @Override
    public void initViews() {
        super.initViews();
        // [1]找到我们关心的控件

        et_path = (EditText) findViewById(R.id.et_path);
        // 用来显示我们图片的内容
        iv = (ImageView) findViewById(R.id.iv);
    }

    // [2]实现按钮点击事件 获取我们路径下的图片 展示到iv上
    public void click(View v) {

        // 创建一个子线程
        new Thread() {
            public void run() {

                File file = new File(getCacheDir(), "test.png");
                if (file.exists() && file.length() > 0) {

                    //说明图片已经存在
                    System.out.println("使用缓存图片 ");
                    final Bitmap cacheBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

                    runOnUiThread(new Runnable() {
                        public void run() {

                            iv.setImageBitmap(cacheBitmap);
                        }
                    });

                } else {

                    System.out.println("第一次联网获取");

                    //说明图片不存在 联网去获取
                    // [2.1]获取path 地址
                    String path = et_path.getText().toString().trim();
                    // [2]根据你的写的图片的地址 去获取图片的内容吧
                    try {
                        URL url = new URL(path);
                        // [2.1]获取httpurlconnection对象
                        HttpURLConnection conn = (HttpURLConnection) url
                                .openConnection();
                        // [2.2]设置请求的方式 get
                        conn.setRequestMethod("GET");
                        // [2.3]设置连接超时时间
                        conn.setConnectTimeout(5000);
                        // [2.4]获取服务器返回状态码
                        int code = conn.getResponseCode();
                        if (code == 200) {
                            // 请求成功 获取该网址下的图片内容 不管你去服务器取什么数据 都是以流的形式返回
                            InputStream in = conn.getInputStream();


                            //[2.4.1]对图片进行缓存
                            FileOutputStream fos = new FileOutputStream(file);

                            int len = 0;
                            byte buffer[] = new byte[1024];
                            while ((len = in.read(buffer)) != -1) {
                                fos.write(buffer, 0, len);
                            }
                            fos.close();
                            in.close();

                            // [2.5]需要把in转换成bitmap (位图) 矢量图
//							Bitmap bitmap = BitmapFactory.decodeStream(in);
                            final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

                            //这个api 你不管在哪调用  都运行在 主线程
                            runOnUiThread(new Runnable() {
                                public void run() {

                                    iv.setImageBitmap(bitmap);

                                }
                            });


                        } else {
                            // 请求失败 给用户一个友好提示
                            showToast("请求资源不存在");

                        }

                    } catch (Exception e) {
                        e.printStackTrace();

                        showToast("服务器忙");
                    }

                }


            }

        }.start();


    }


    //封装一个显示toast的方法

    public void showToast(final String content) {

        //这个方法指定会运行在ui线程
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_modify_look_picture;
    }
}
