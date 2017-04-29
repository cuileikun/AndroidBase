package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.cuileikun.androidbase.service.PhoneService;

public class BootReceiverSecond extends BroadcastReceiver {

	//当手机重新启动 会执行这个方法 
	@Override
	public void onReceive(Context context, Intent intent) {

		//把开启服务的方法写到这里 
		Intent intent2 = new Intent(context,PhoneService.class);
		//开启服务  
		context.startService(intent2);
		
		
	}

}
