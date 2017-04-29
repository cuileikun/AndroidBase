package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		//获取当前广播的事件类型 
		String action = intent.getAction();
		if ("android.intent.action.SCREEN_OFF".equals(action)) {
			System.out.println("当前屏幕锁屏");
		}else if ("android.intent.action.SCREEN_ON".equals(action)) {
			System.out.println("说明当前屏幕 解锁了");
		}
		
		
	}

}
