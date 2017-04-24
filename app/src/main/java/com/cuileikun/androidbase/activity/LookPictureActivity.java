package com.cuileikun.androidbase.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
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
 * 功能:2_演示anr
 */
public class LookPictureActivity extends QkActivity {
    protected static final int REQUEST_SUCESS = 0; // ctrl + shift + X(变大写)
    // +y(变小写)
    protected static final int REQUEST_FAIL = 1;
    protected static final int REQUEST_EXCEPTION = 2;
    protected static final int CACHE_SUCESS = 3;

    private EditText et_path;
    private ImageView iv;

    // 创建handler
    private Handler handler = new Handler() {

        // 当 handler 发送消息的时候执行
        public void handleMessage(android.os.Message msg) {

            // 判断一下消息的类型
            switch (msg.what) {
                case REQUEST_SUCESS:  //处理请求成功的逻辑
                    // 在这里更新ui 先获取到携带的消息 (bitmap)
                    Bitmap bitmap = (Bitmap) msg.obj;
                    // 更新ui
                    iv.setImageBitmap(bitmap);
                    break;


                case CACHE_SUCESS://说明使用缓存的图片

                    Bitmap bitmap2 = (Bitmap) msg.obj;
                    iv.setImageBitmap(bitmap2);

                    break;
                case REQUEST_FAIL:   //处理请求失败的逻辑

                    //给用户友好提示
                    Toast.makeText(getApplicationContext(), "图片不存在", Toast.LENGTH_SHORT).show();
                    iv.setImageBitmap(null);

                    break;

                case REQUEST_EXCEPTION: //处理异常
                    Toast.makeText(getApplicationContext(), "服务器忙!请稍后再连接...", Toast.LENGTH_SHORT).show();
                    iv.setImageBitmap(null);
                    break;
            }


        }

    };

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

                File file = new File(getCacheDir(),"test.png");
                if (file.exists()&&file.length()>0) {

                    //说明图片已经存在
                    System.out.println("使用缓存图片 ");
                    Bitmap cacheBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

                    //创建消息对象
                    Message msg = Message.obtain();
                    msg.what = CACHE_SUCESS;
                    msg.obj = cacheBitmap;//携带数据
                    handler.sendMessage(msg);//发送消息

                }else {

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
                            while((len = in.read(buffer))!=-1){
                                fos.write(buffer, 0, len);
                            }
                            fos.close();
                            in.close();

                            // [2.5]需要把in转换成bitmap (位图) 矢量图
//							Bitmap bitmap = BitmapFactory.decodeStream(in);
                            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());


                            // 节省资源 提供效率
                            Message msg = Message.obtain();
                            // 设置一个消息类型
                            msg.what = REQUEST_SUCESS;
                            // 携带数据
                            msg.obj = bitmap;
                            handler.sendMessage(msg);

                            // [2.6]把bitmap显示到iv 上
                            // iv.setImageBitmap(bitmap);

                        } else {
                            // 请求失败 给用户一个友好提示

                            Message msg = Message.obtain();
                            msg.what = REQUEST_FAIL;
                            handler.sendMessage(msg);



                        }

                    } catch (Exception e) {
                        e.printStackTrace();

                        Message msg = Message.obtain();
                        msg.what = REQUEST_EXCEPTION;
                        handler.sendMessage(msg);

                    }

                }

            };
        }.start();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_look_picture;
    }
}
