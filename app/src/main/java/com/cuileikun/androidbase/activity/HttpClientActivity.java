package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.os.Bundle;

import com.cuileikun.androidbase.R;

/**
 * 作者：popular cui
 * 时间：2017/4/27 19:38
 * 功能: HttpClient已过时
 */
public class HttpClientActivity extends Activity {

//    private EditText et_username;
//    private EditText et_userpassword;
//    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client);

        // [1]找到我们关心的控件

//        et_username = (EditText) findViewById(R.id.et_username);
//        et_userpassword = (EditText) findViewById(R.id.et_userpassword);
    }

//    // 点击按钮 进行get方式把数据提交给服务器
//    public void click1(View v){
//
//        //创建一个子线程
//        new Thread() {
//            public void run() {
//
//                //[1]获取用户输入的用户名和密码
//                String name = et_username.getText().toString().trim();
//                String pwd = et_userpassword.getText().toString().trim();
//
//                try {
//                    path = "http://169.254.87.250:8080/login/LoginServlet?username="+ URLEncoder.encode(name,"utf-8")+"&password="+URLEncoder.encode(pwd, "utf-8")+"";
//                } catch (UnsupportedEncodingException e1) {
//                    e1.printStackTrace();
//                }
//                //自己判断一下 是否为空
//                //[2]以httpclient的方式进行 get请求
//
//                //[2.1]获取httpclient实例
//                HttpClient client = new DefaultHttpClient();
//
//                //[2.2]准备httpget实例 进行get请求
//                HttpGet get  = new HttpGet(path);
//
//                //[2.3]执行get请求
//                try {
//                    HttpResponse response = client.execute(get);
//                    //[2.4]获取状态码
//                    int code = response.getStatusLine().getStatusCode();
//                    if (code == 200) {
//                        //说明请求成功   获取服务器返回的数据
//                        InputStream in = response.getEntity().getContent();
//                        String content = StreamUtilsSecond.readStream(in);
//                        showToast(content);
//                    }
//
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }.start();
//
//
//
//
//    }
//
//    // 点击按钮 以post方式把数据提交给服务器
//    public void click2(View v) {
//
//        //创建一个子线程
//        new Thread() {
//            public void run() {
//
//                try {
//                    //[1]获取用户输入的用户名和密码
//                    String name = et_username.getText().toString().trim();
//                    String pwd = et_userpassword.getText().toString().trim();
//                    //自己判断一下 是否为空
//                    //[2]创建httpclient 对象
//                    HttpClient client = new DefaultHttpClient();
//                    String path = "http://169.254.87.250:8080/login/LoginServlet";
//                    //[2.1]准备httppost 进行post 请求
//                    HttpPost post = new HttpPost(path);
//                    //[2.2]准备post提交的数据 以实体的形式进行准备
//                    //[2.3]准备parameters
//                    List<NameValuePair> parameters  = new ArrayList<NameValuePair>();
//
//                    //[2.4]准备NameValuePair 又是一个接口 key要和服务器username对应
//                    BasicNameValuePair nameValuePair = new BasicNameValuePair("username", name);
//                    BasicNameValuePair pwdValuePair = new BasicNameValuePair("password", pwd);
//                    //[2.5] 把nameValuePair 和 pwdValuePair 加入到集合里
//                    parameters.add(nameValuePair);
//                    parameters.add(pwdValuePair);
//                    //[2.6]创建entity 实例
//                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters);
//                    //[2.7]设置准备的实体
//                    post.setEntity(entity);
//                    //[3]进行post请求
//                    HttpResponse response = client.execute(post);
//                    int code = response.getStatusLine().getStatusCode();
//                    if (code == 200) {
//                        //说明请求成功   获取服务器返回的数据
//                        InputStream in = response.getEntity().getContent();
//                        String content = StreamUtils.readStream(in);
//                        //更新ui
//                        showToast(content);
//                    }
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//
//            };
//        }.start();
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
//                Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}
