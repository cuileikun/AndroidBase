package com.cuileikun.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CountryReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		//获取发送广播携带的数据 
		String rice = getResultData();
		
		Toast.makeText(context, "乡:"+rice, Toast.LENGTH_SHORT).show();
		
		//修改数据
		setResultData("习大大给每个村民发了10斤");
		
	}

}
