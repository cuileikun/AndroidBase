package com.cuileikun.androidbase.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cuileikun.androidbase.R;

public class Fragment5 extends Fragment {

	//在这个方法里面加载 Fragment要显示的内容
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment5, null);
		
		return view;
	}
}
