package com.cuileikun.androidbase.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.cuileikun.androidbase.R;

public class WxFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		View view = inflater.inflate(R.layout.fragment_wx, null);
		
		//测试一下按钮的点击事件 
		view.findViewById(R.id.btn_test).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "啊啊啊啊啊", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		return view;
	}
	
}
