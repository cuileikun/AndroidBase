package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenReceiverSecond extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		String action = intent.getAction();
		if ("android.intent.action.SCREEN_OFF".equals(action)) {
			System.out.println("说明屏幕锁屏了");
		}else if ("android.intent.action.SCREEN_ON".equals(action)) {
			
			System.out.println("````````````````````");
		}
		
	}

}
