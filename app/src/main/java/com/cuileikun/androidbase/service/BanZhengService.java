package com.cuileikun.androidbase.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import com.cuileikun.androidbase.inteface.IService;

public class BanZhengService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		//把我们定义的中间人对象返回
		return new MyBinder();
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	//[1]办证的方法
	public void banZheng(int money){
		if(money>500){
			Toast.makeText(getApplicationContext(), "明天来拿证", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(getApplicationContext(), "这点钱 还想办事", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	//打麻将的方法
	public void playMaJiang(){
		System.out.println("陪领导 打麻将 ");
	}
	//洗桑拿的方法
	public void 洗桑拿(){
		System.out.println("洗桑拿");
	}
	
	
	
	//[2]在服务的内部定义一个中间人对象  (IBinder)
	private class MyBinder extends Binder implements IService {
		//调用办证的方法
		
		//调用打麻将的方法
		public void callPlayMajiang(){
			playMaJiang();
		}
		
		//调用 洗桑拿的方法
		public void callXiSangNa(){
			洗桑拿();
		}

		//调用办证的方法
		@Override
		public void callBanZheng(int money) {
			banZheng(money);
		}
		
		
	}
	
	
}
