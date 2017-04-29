package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SdcardReceiver extends BroadcastReceiver {

	//当sd卡状态发生改变的时候调用
	@Override
	public void onReceive(Context context, Intent intent) {

		//获取当前广播的事件类型 
		String action = intent.getAction();
		if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
			System.out.println("sd卡挂载了");
		}else if ("android.intent.action.MEDIA_UNMOUNTED".equals(action)) {
			System.out.println("说明sd卡卸载了");
		}
		
		
	}

}
