package com.cuileikun.androidbase.activity;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.utils.StreamUtils;
import com.qk.applibrary.activity.QkActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 作者：popular cui
 * 时间：2017/4/24 17:18
 * 功能:1_源码查看器
 */
public class YuanMaActivity extends QkActivity{

    private EditText et_path;
    private TextView tv_content;


    //[0]创建handler对象  在主线程创建的
    private Handler handler = new Handler(){

        //一旦handler发送消息 这个方法就会执行  可以在这个方法里面更新ui
        public void handleMessage(android.os.Message msg) {
            //取出 我们发送消息 携带的数据
            String content = (String) msg.obj;
            //在更新ui
            tv_content.setText(content);

        };
    };

    @Override
    public void initViews() {
        super.initViews();
        //[1]找到我们关心的控件

        et_path = (EditText) findViewById(R.id.et_path);
        //用来显示源码的内容
        tv_content = (TextView) findViewById(R.id.tv_content);

        System.out.println("当前线程的名字:"+Thread.currentThread().getName());
    }

    //[2]点击按钮 向服务器发送一个get请求 获取我们要要的数据
    public void click(View v){


        //[2.0]创建子线程
        new Thread(){public void run() {
            //[2.1]获取url路径
            String path = et_path.getText().toString().trim();
            //[2.2]判断aath是否为空 TextUtils
            if (TextUtils.isEmpty(path)) {
                //说明为空
                Toast.makeText(getApplicationContext(), "path不能为空", 1).show();
            }else {
                //说明路径不为空  向服务器发送get请求
                try {
                    //[2.3]创建url对象 目的是为了 获取HttpURLConnection
                    URL url = new URL(path);
                    //[2.4]获取HttpURLConnection 这个类实例
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //[2.5]发送get请求
                    conn.setRequestMethod("GET");//默认就是 get请求 写要大写
                    //[2.6]设置连接的超时时间
                    conn.setConnectTimeout(5000);
                    //[2.7]获取服务器返回的状态码
                    int code = conn.getResponseCode();

                    if (code == 200) {
                        //代表请求成功    [2.8]  获取服务器返回的数据  ☆☆☆☆ 注意 服务器是以流的形式返回
                        InputStream in = conn.getInputStream();
                        //[2.9]把流转换为 String  这个操作非常常见 所以我做成一个工具类
                        String content = StreamUtils.readStream(in);

                        //[3.0]把内容显示到textview上  这句话就是在更新ui   子线程不能更新ui


                        //[3.1]拿着handler助手发送一条消息  告诉操作系统 我要更新ui
                        Message msg = new Message();
                        msg.obj = content;//使用msg携带数据

                        //[3.2]发送一条消息  handlermessage方法就会执行
                        handler.sendMessage(msg);
                        System.out.println("当前线程的名字6666:"+Thread.currentThread().getName());

//						tv_content.setText(content);

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        };}.start();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_yuan_ma;
    }
}
