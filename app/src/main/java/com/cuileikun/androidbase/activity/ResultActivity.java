package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.cuileikun.androidbase.R;

import java.io.UnsupportedEncodingException;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载布局
		setContentView(R.layout.activity_result);
		
		//[1]找到我们关心的控件 
		TextView tv_name = (TextView) findViewById(R.id.tv_name);
		TextView tv_sex = (TextView) findViewById(R.id.tv_sex);
		TextView tv_result = (TextView) findViewById(R.id.tv_result);
		//[2]获取通过意图传递过来的数据 
		Intent intent = getIntent();//获取开启此Activity的意图对象
		//[2.1]获取通过意图传递的数据 注意:小技巧 :  
		String name = intent.getStringExtra("name");
		int sex = intent.getIntExtra("sex", 0);
		
		//[2.2]把数据展示到控件上 
		tv_name.setText(name);
		byte[] bytes = null;
		
		try {
			//[2.3]展示性别 
			switch (sex) {
			case 1:  
				tv_sex.setText("男");
				bytes= name.getBytes("utf-8");
				
				break;
			case 2:  
				tv_sex.setText("女");
				
				bytes= name.getBytes("gbk");
				break;
				
			case 3:  
				tv_sex.setText("人妖");
				bytes= name.getBytes("iso-8859-1");
				break;

			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//[3]算出人品结果  随机数 
		
		int total = 0;
		for (byte b : bytes) {          
			int number = b&0xff;                      
			total+=number;
		}
		//算出一个得分
		int score = Math.abs(total)%100;
		if (score>90) {
			tv_result.setText("人品非常好 您家的祖坟都冒青烟了");
		}else if (score >70 ) {
			tv_result.setText("您的人品还可以 你需要努力啊!!1");
		}else if (score >60 ) {
			tv_result.setText("您的人品刚刚及格 你需要更加努力");
		}else{
			tv_result.setText("您的人品不及格 .....");
		}
			
		
		
		
	}
	
}
