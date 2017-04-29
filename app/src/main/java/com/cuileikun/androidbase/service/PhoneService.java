package com.cuileikun.androidbase.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.io.IOException;

public class PhoneService extends Service {

	private MediaRecorder recorder;//录音机实例 
	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

	// 当服务第一次创建的时候调用
	@Override
	public void onCreate() {
		// 监听电话的状态
		// [1]获取telephoneManager的实例
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

		// [2]注册电话的监听
		tm.listen(new MyPhoneStateListener(),
				PhoneStateListener.LISTEN_CALL_STATE);

		super.onCreate();
	}

	// 定义一个类 作用 :用于监听电话的状态
	private class MyPhoneStateListener extends PhoneStateListener {
		// 当电话状态发生改变的时候调用
		

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {

			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE: //空闲状态 
				if (recorder!=null) {
					 recorder.stop();    //停止录音
					 recorder.reset();  
					 recorder.release(); 
					
				}
				

				break;

			case TelephonyManager.CALL_STATE_OFFHOOK: //接听状态 
				 recorder.start();   
				
				System.out.println("开始录音");
				break;

			case TelephonyManager.CALL_STATE_RINGING:  //响铃状态 
 
				System.out.println("准备一个录音机");
				
				//[1]创建MediaRecorder的实例
				
				 recorder = new MediaRecorder();
				 //[2]设置音频的来源 
				 recorder.setAudioSource(MediaRecorder.AudioSource.MIC);//zet 华为
				 //[3]设置录制音频的格式  gpp 3gp
				 recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				 //[4]设置音频的编码方式
				 recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
				 //[5]设置音频存储的位置
				 recorder.setOutputFile("mnt/sdcard/luyin.3gp");
				 //[6]准备录音
				 try {
					recorder.prepare();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				break;

			
			}

			super.onCallStateChanged(state, incomingNumber);
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
