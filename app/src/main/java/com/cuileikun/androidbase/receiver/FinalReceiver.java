package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class FinalReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		String content = getResultData();
		
		Toast.makeText(context, "报告习大大:"+content, Toast.LENGTH_SHORT).show();
	}

}
