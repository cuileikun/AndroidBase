package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {

	//当短信到来就会执行这个方法
	@Override
	public void onReceive(Context context, Intent intent) {
		
//		获取发送短信的号码 和 内容
		Object[] objects = (Object[])intent.getExtras().get("pdus");
		for (Object object : objects) {
			//创建smsmessage的实例 
			SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) object);
			String body = smsMessage.getMessageBody();
			String address = smsMessage.getOriginatingAddress();
			
			System.out.println("body:"+body+"----"+address);
		}
		
		
		
	}

}
