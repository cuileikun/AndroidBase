package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.bean.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactActivityThird extends Activity {

	
	private List<Contact> lists;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载布局 
		setContentView(R.layout.activity_contact_third);
		//[1]找到listview控件 
		ListView lv_contact = (ListView) findViewById(R.id.lv);
		
		//[2]准备listview要显示的数据 
		
		lists = new ArrayList<Contact>();
		for (int i = 0; i < 20; i++) {
			Contact contact = new Contact();
			contact.setName("lisi"+i);
			contact.setPhone("13888"+i);
			lists.add(contact);
		}
		
		//[2]设置数据适配器
		lv_contact.setAdapter(new MyAdapter());
		
		//[3]给listview 设置 条目点击事件 
		lv_contact.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				//[4]取出点中条目的电话号码   数据在哪里存着就去哪里取
				String phone = lists.get(position).getPhone();
				
				//[5]把phone的数据返回给ManiActivity 
				Intent intent = new Intent();
				intent.putExtra("phone", phone);
				
				//[6]把我要传递的数据返回给mainActivity
				setResult(10, intent);
				
				//[7]关闭当前的Activity
				finish();
				
				
			}
		});
		
	}
	
	
	//定义listview的数据适配器
	private class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return lists.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view;
			if (convertView == null) {
				//历史缓存对象为null
				view = View.inflate(getApplicationContext(), R.layout.contact_item, null);
			}else {
				view = convertView;
				
			}
			//找到contact_item 这个布局里面的控件  用来显示数据 
			TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
			TextView tv_phone = (TextView) view.findViewById(R.id.tv_phone);
			//显示数据 
			tv_name.setText(lists.get(position).getName());
			tv_phone.setText(lists.get(position).getPhone());
			
			
			return view;
		}
		
	}
	
	
}
