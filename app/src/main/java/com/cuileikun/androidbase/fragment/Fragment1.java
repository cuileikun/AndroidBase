package com.cuileikun.androidbase.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cuileikun.androidbase.R;

//声明一个Fragment 
public class Fragment1 extends Fragment {

	//通过这个方法加载Fragment自己要显示的内容 setContentView
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment1, null);
		
		
		return view;
				
	}
	
	
}
