package com.cuileikun.androidbase.activity.sixth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cuileikun.androidbase.R;

public class SmsTempleateActivity extends Activity {

	//[0]准备listview要显示的数据 
	String[] objects = {"我在开会,请稍后联系","我在吃饭,请稍后联系","我在打坐,请稍后联系","我在睡觉,请稍后联系","我在路上,请稍后联系"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_smstempleate);
		//[1]找到控件 listview
		ListView lv = (ListView) findViewById(R.id.lv);
	
		//[2]准备数据适配器 
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.template_item, objects);
		//[3]显示数据 
		lv.setAdapter(adapter);
		//[4]给listview设置条目点击事件 
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				//[5]获取点中条目的数据 
				String smsContent = objects[position];
				//[6]创建意图 
				Intent intent = new Intent();
				intent.putExtra("smscontent", smsContent);
				
				//[7]把数据返回给调用者 
				setResult(20, intent);
				//[8]把当前页面关闭 
				finish();
				
				
			}
		});
		
		
	}
}
