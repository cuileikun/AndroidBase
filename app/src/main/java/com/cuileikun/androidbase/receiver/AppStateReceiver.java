package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AppStateReceiver extends BroadcastReceiver {

	//当 应用被卸载 或者安装的时候调用
	@Override
	public void onReceive(Context context, Intent intent) {

		System.out.println("嘻嘻");
		
		//获取当前广播的事件类型
		String action = intent.getAction();
		
		if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
			System.out.println("shuoming 应用被安装了:"+intent.getData());
		}else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
			System.out.println("说明应用被卸载了");
		}
		
	}

}
