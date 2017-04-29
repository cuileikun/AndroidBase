package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.cuileikun.androidbase.activity.seventh.PhoneRestartActivity;

public class BootReceiver extends BroadcastReceiver {

	//当手机重新启动就会执行这个方法
	@Override
	public void onReceive(Context context, Intent intent) {

		//在这个方法里面开启mainActivity
		
		Intent intent2 = new Intent(context,PhoneRestartActivity.class);
		
		//注意不可以在广播接收者中开启activity 需要一个任务栈   如果想在广播接收者里面开启Activity需要设置一个flags
		intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		//开启Activity
		context.startActivity(intent2);
		
	}

}
