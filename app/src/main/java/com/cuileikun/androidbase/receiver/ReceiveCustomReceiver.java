package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiveCustomReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		//终止广播接收者
		abortBroadcast();
		
		String content = intent.getStringExtra("name");
		Toast.makeText(context, content+"11111111111111111111", Toast.LENGTH_SHORT).show();
		
		
	}

}
