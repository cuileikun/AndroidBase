package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NongMinReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		//获取发送广播携带的数据 
		String rice = getResultData();
		
		Toast.makeText(context, "农民:"+rice, 1).show();
		
	}

}
