package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.cuileikun.androidbase.R;

/**
 * 作者：popular cui
 * 时间：2017/4/27 19:38
 * 功能:
 */
public class AsyncHttpClientActivity extends Activity {

    private EditText et_username;
    private EditText et_userpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_http_client);

        // [1]找到我们关心的控件

//        et_username = (EditText) findViewById(R.id.et_username);
//        et_userpassword = (EditText) findViewById(R.id.et_userpassword);
    }

//    // 点击按钮 进行get方式把数据提交给服务器
//    public void click1(View v) {
//        try {
//            //[1]获取用户输入的用户名和密码
//            String name = et_username.getText().toString().trim();
//            String pwd = et_userpassword.getText().toString().trim();
//            //[2]以开源项目(asynchttpclient)实现get请求
//            AsyncHttpClient client = new AsyncHttpClient();
//            String path = "http://169.254.87.250:8080/login/LoginServlet?username="+ URLEncoder.encode(name,"utf-8")+"&password="+URLEncoder.encode(pwd, "utf-8")+"";
//            //[2.1]想进行get请求
//            client.get(path,new AsyncHttpResponseHandler() {
//                //请求成功
//                @Override
//                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//
//                    try {
//                        Toast.makeText(getApplicationContext(), new String(responseBody,"gbk"), 1).show();
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//                //请求失败
//                @Override
//                public void onFailure(int statusCode, Header[] headers,
//                                      byte[] responseBody, Throwable error) {
//
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//
//
//
//    }
//
//    // 点击按钮 以post方式把数据提交给服务器
//    public void click2(View v) {
//        //[1]获取用户输入的用户名和密码
//        String name = et_username.getText().toString().trim();
//        String pwd = et_userpassword.getText().toString().trim();
//
//        //[2]]以开源项目(asynchttpclient)实现post请求
//        AsyncHttpClient client = new AsyncHttpClient();
//        String path = "http://169.254.87.250:8080/login/LoginServlet";
//        //params请求的参数
//        RequestParams params = new RequestParams();
//        params.put("username", name);
//        params.put("password", pwd);
//        client.post(path, params, new AsyncHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                try {
//                    Toast.makeText(getApplicationContext(), new String(responseBody,"gbk"), 1).show();
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers,
//                                  byte[] responseBody, Throwable error) {
//
//            }
//        });
//
//
//
//
//    }
//
//    //显示土司的工具类
//    public void showToast(final String content){
//        runOnUiThread(new Runnable() {
//
//            @Override
//            public void run() {
//                Toast.makeText(getApplicationContext(), content, 1).show();
//            }
//        });
//    }


}
