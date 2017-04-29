package com.cuileikun.androidbase.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.cuileikun.androidbase.receiver.ScreenReceiverSecond;

public class ScreenService extends Service {
	private ScreenReceiverSecond screenReceiver;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		//在这里 注册广播接收者 
		screenReceiver = new ScreenReceiverSecond();
		//创建意图过滤器
		IntentFilter filter = new IntentFilter();
		filter.addAction("android.intent.action.SCREEN_OFF");
		filter.addAction("android.intent.action.SCREEN_ON");
		//注册广播接收者 
		registerReceiver(screenReceiver, filter);
		
		
		
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		//取消注册广播接收者
		unregisterReceiver(screenReceiver);
		super.onDestroy();
	}
	
}
