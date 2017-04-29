package com.cuileikun.androidbase.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class DemoService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("onBind");
		return null;
	}
	
	//当服务第一次创建的时候调用
	@Override
	public void onCreate() {
		System.out.println("onCreate");
		
		super.onCreate();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		System.out.println("onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		
		super.onDestroy();
	}
	
	
	

}
