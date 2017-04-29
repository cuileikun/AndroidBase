package com.cuileikun.androidbase.activity.fifth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.utils.StreamUtils;
import com.cuileikun.androidbase.utils.StreamUtilsSecond;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 作者：popular cui
 * 时间：2017/4/27 19:38
 * 功能:
 */
public class LoginActivity extends Activity {


    private EditText et_username;
    private EditText et_userpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // [1]找到我们关心的控件

        et_username = (EditText) findViewById(R.id.et_username);
        et_userpassword = (EditText) findViewById(R.id.et_userpassword);
    }

    // 点击按钮 进行get方式把数据提交给服务器
    public void click1(View v) {

        //创建一个子线程
        new Thread() {
            public void run() {

                //[1]获取用户输入的用户名和密码
                String name = et_username.getText().toString().trim();
                String pwd = et_userpassword.getText().toString().trim();
                //自己判断一下 是否为空

                try {

                    String path = "http://169.254.87.250:8080/login/LoginServlet?username=" + URLEncoder.encode(name, "utf-8") + "&password=" + URLEncoder.encode(pwd, "utf-8") + "";
                    //[2.1]创建URL 对象指定我们要访问的 网址(路径)
                    URL url = new URL(path);
                    //[2.2]拿到httpurlconnection对象  用于发送或者接收数据
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //[2.3]设置发送get请求
                    conn.setRequestMethod("GET");//get要求大写  默认就是get请求
                    //[2.4]设置请求超时时间
                    conn.setConnectTimeout(5000);
                    //[2.5]获取服务器返回的状态码
                    int code = conn.getResponseCode();
                    //[2.7]如果code == 200 说明请求成功
                    if (code == 200) {
                        //[2.8]获取服务器返回的数据   是以流的形式返回的  由于把流转换成字符串是一个非常常见的操作  所以我抽出一个工具类(utils)
                        InputStream in = conn.getInputStream();

                        //[2.8]把in转换成String
                        String content = StreamUtilsSecond.readStream(in); //服务器返回的内容

                        //[2.9]弹出一个Toast 给用户一个友好提示
                        showToast(content);


                    }

                } catch (Exception e) {

                }

            }
        }.start();


    }

    // 点击按钮 以post方式把数据提交给服务器
    public void click2(View v) {


        //创建一个子线程
        new Thread() {
            public void run() {

                //[1]获取用户输入的用户名和密码
                String name = et_username.getText().toString().trim();
                String pwd = et_userpassword.getText().toString().trim();
                //自己判断一下 是否为空

                try {

                    //[2.0]封装请求正文的内容
                    String data = "username=" + URLEncoder.encode(name, "utf-8") + "&password=" + URLEncoder.encode(pwd, "utf-8") + "";
                    //一 ☆☆☆☆和get方式提交数据不同之处
                    String path = "http://169.254.87.250:8080/login/LoginServlet";
                    //[2.1]创建URL 对象指定我们要访问的 网址(路径)
                    URL url = new URL(path);
                    //[2.2]拿到httpurlconnection对象  用于发送或者接收数据
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //[2.3]设置发送get请求
                    conn.setRequestMethod("POST");//get要求大写  默认就是get请求
                    //[2.4]设置请求超时时间
                    conn.setConnectTimeout(5000);


                    //二 ☆☆☆☆和get区别  以流的形式把数据写个服务器
                    conn.setDoOutput(true);//设置一个标记允许 httpurlconnection输出
                    conn.getOutputStream().write(data.getBytes());
                    //[2.5]获取服务器返回的状态码
                    int code = conn.getResponseCode();
                    //[2.7]如果code == 200 说明请求成功
                    if (code == 200) {
                        //[2.8]获取服务器返回的数据   是以流的形式返回的  由于把流转换成字符串是一个非常常见的操作  所以我抽出一个工具类(utils)
                        InputStream in = conn.getInputStream();

                        //[2.8]把in转换成String
                        String content = StreamUtils.readStream(in); //服务器返回的内容

                        //[2.9]弹出一个Toast 给用户一个友好提示
                        showToast(content);


                    }

                } catch (Exception e) {

                }

            }

        }.start();


    }

    //显示土司的工具类
    public void showToast(final String content) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
