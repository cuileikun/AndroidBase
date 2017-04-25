package com.cuileikun.androidbase.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MySmartImageView extends ImageView {


	protected static final int REQUESTSUCESS = 0;
	//创建handler
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
				case REQUESTSUCESS: //请求成功
					Bitmap bitmap =  (Bitmap) msg.obj;
					MySmartImageView.this.setImageBitmap(bitmap);

					break;

				default:
					break;
			}


		};

	};

	//直接new 的时候 调用一个参数的构造方法
	public MySmartImageView(Context context) {
		super(context);
	}
	//在布局中使用的时候调用
	public MySmartImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MySmartImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}



	//展示图片成url方法
	public void setImageUrl(final String path){

		//创建一个子线程
		new Thread() {
			public void run() {

				try {

					//[2.1]创建URL 对象指定我们要访问的 网址(路径)
					URL url = new URL(path);
					//[2.2]拿到httpurlconnection对象  用于发送或者接收数据
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
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

						//[2.9]转换bitmap对象

						Bitmap bitmap = BitmapFactory.decodeStream(in);
						Message msg = Message.obtain();
						msg.what = REQUESTSUCESS;
						msg.obj = bitmap;
						handler.sendMessage(msg);



					}

				} catch (Exception e) {

				}


			};
		}.start();



	}



}
