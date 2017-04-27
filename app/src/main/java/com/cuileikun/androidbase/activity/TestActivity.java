package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.os.Bundle;

import com.cuileikun.androidbase.R;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载一个布局 
		setContentView(R.layout.activity_test);
		
	}
}
