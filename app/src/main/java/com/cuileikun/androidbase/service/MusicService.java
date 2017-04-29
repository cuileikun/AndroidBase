package com.cuileikun.androidbase.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.cuileikun.androidbase.inteface.Iservicess;

public class MusicService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		//[2]把我们定义的中间人对象返回 
		return new MyBinder();
	}

	// 当服务第一次创建的时候调用
	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	// 播放音乐的方法
	public void playMusic() {
		// TODO 讲多媒体的时候在把这个案例完善
		System.out.println("音乐播放了");

	}

	// 播放暂停的方法
	public void pauseMusic() {
		System.out.println("音乐暂停了");

	}

	// 播放暂停的方法
	public void replayMusic() {
		System.out.println("音乐继续播放了");

	}

	
	//[1]定义中间人对象 (IBinder)
	private class MyBinder extends Binder implements Iservicess {

		@Override
		public void callPlayMusic() {
			
			//调用播放音乐的方法 
			playMusic();
		}

		@Override
		public void callPauseMusic() {
			pauseMusic();
		}

		@Override
		public void callReplayMusic() {
			replayMusic();
		}
		
	}
	
	
	
}
