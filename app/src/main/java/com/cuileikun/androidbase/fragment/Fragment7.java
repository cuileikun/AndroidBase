package com.cuileikun.androidbase.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.cuileikun.androidbase.R;

//声明一个Fragment 
public class Fragment7 extends Fragment {

	//通过这个方法加载Fragment自己要显示的内容 setContentView
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment77, null);
		
		//给按钮添加点击事件 
		view.findViewById(R.id.btn_update).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Fragment有一个公共的桥梁 是Activity
				Fragment8 f2= (Fragment8) getActivity().getFragmentManager().findFragmentByTag("f2");
				f2.updateTextView("呵呵呵");
			}
		});
		
		
		return view;
				
	}
	
	
}
