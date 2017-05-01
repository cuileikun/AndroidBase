package com.cuileikun.androidbase.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;

import com.cuileikun.androidbase.activity.ten.BaiduMusicActivity;
import com.cuileikun.androidbase.inteface.IIservice;

import java.util.Timer;
import java.util.TimerTask;

public class MMusicService extends Service {

	private MediaPlayer mediaPlayer;


	@Override
	public IBinder onBind(Intent intent) {
		//[2]把我们定义的中间人对象返回 
		return new MyBinder();
	}

	// 当服务第一次创建的时候调用
	@Override
	public void onCreate() {
		//把mediaplayer这个类 实例化 
		//[1]获取mediaplayer 实例 
		
		mediaPlayer = new MediaPlayer();
		
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	// 播放音乐的方法
	public void playMusic() {
		System.out.println("音乐播放了");
		
		//[2]设置你要播放的音频资源的路径    path:可以是网络路径 也可以是本地路径
				try {
					mediaPlayer.reset();
					mediaPlayer.setDataSource("/mnt/sdcard/xpg.mp3");
					
					//[3]准备播放 
					mediaPlayer.prepare();
					//[4]开始播放 
					mediaPlayer.start();
					
					//[5]更新seekbar的进度条 
					updataSeekBar();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		

	}

	//设置播放歌曲的位置 
	public void seekToPositon(int position){
		mediaPlayer.seekTo(position);
		
	}
	
	//更新进度条的方法 
	private void updataSeekBar() {
		//[1]获取歌曲的总时长 
		final int duration = mediaPlayer.getDuration();
		//[2]每隔一秒钟获取一次当前的进度 
		final Timer timer = new Timer();
		final TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				//[3]获取到歌曲当前播放的进度 
				int currentPosition = mediaPlayer.getCurrentPosition();
				//[4]拿着我们在mainActivity创建的hander发消息  发消息的同时可以携带数据 
				
				Message msg = Message.obtain();
				//携带多条 数据  
				Bundle bundle = new Bundle();
				bundle.putInt("duration", duration);
				bundle.putInt("currentPosition", currentPosition);
				msg.setData(bundle);
				//这句话一执行  mainActivity的handlemessage方法就会执行
				BaiduMusicActivity.handler.sendMessage(msg);
				//手机影音 
				
			}
		};
		//200毫秒后每隔1秒种执行一次 run方法
		timer.schedule(task, 200, 1000);
		//当歌曲播放完成  取消 timer 和 task 任务  
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
			
				System.out.println("歌曲播放完成啦");
				timer.cancel();
				task.cancel();
				
			}
		});
		
		
		
		
		
	}

	// 播放暂停的方法
	public void pauseMusic() {

		mediaPlayer.pause();
		
	}

	// 播放暂停的方法
	public void replayMusic() {
		
		mediaPlayer.start();

	}

	
	//[1]定义中间人对象 (IBinder)
	private class MyBinder extends Binder implements IIservice {

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

		@Override
		public void callSeekToPositon(int position) {
			//设置播放歌曲的位置
			seekToPositon(position);
			
		}
		
	}
	
	
	
}
