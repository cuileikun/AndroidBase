package com.cuileikun.androidbase.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cuileikun.androidbase.R;

//声明一个Fragment 
public class Fragment8 extends Fragment {

	private TextView tv_content;


	//通过这个方法加载Fragment自己要显示的内容 setContentView
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment8, null);
		
		tv_content = (TextView) view.findViewById(R.id.tv_content);
		
		return view;
				
	}
	
	
	//更新textview的方法
	public void updateTextView(String content){
		tv_content.setText(content);
	}
	
	
}
