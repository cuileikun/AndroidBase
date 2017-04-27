package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cuileikun.androidbase.R;

public class SecondActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载布局 
		setContentView(R.layout.activity_second);
	}
	
	// 点击按钮 开启第一个页面
		public void open1(View v) {
			Intent intent = new Intent(this,StartMethodActivity.class);
			startActivity(intent);
		}

		// 点击按钮 开启第二个页面
		public void open2(View v) {

			Intent intent = new Intent(this,SecondActivity.class);
			startActivity(intent);
		}

	
	
}
