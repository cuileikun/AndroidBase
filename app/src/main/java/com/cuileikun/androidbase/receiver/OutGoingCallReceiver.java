package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

//定义广播接收者 需要在清单文件配置 相当于你买了一个收音机
public class OutGoingCallReceiver extends BroadcastReceiver {


	//当接收到外拨电话的事件的时候 这个方法就会执行
	@Override
	public void onReceive(Context context, Intent intent) {

		//[0]获取用户保存的ipnumber 
		SharedPreferences spPreferences = context.getSharedPreferences("config", 0);
		String ipNumber = spPreferences.getString("ipnumber", "");
		
		//[1]获取当前拨打的号码 
	
		String currentNumber = getResultData();
		
		//[2]判断一下是否以0开头 然后在去加上17951 
		if (currentNumber.startsWith("0")) {
			
			//修改拨打的电话号码
			setResultData(ipNumber+currentNumber);
		}
		
		
	}

}
