package com.cuileikun.androidbase.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class TestService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	//在服务的内部定义一个方法
	public void testService(){
		
		Toast.makeText(getApplicationContext(), "我是服务内部的方法", 1).show();
	}
	
	
	
}
