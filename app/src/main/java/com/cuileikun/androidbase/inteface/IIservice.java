package com.cuileikun.androidbase.inteface;

public interface IIservice {

	//暴露想暴露的方法  
	public void callPlayMusic();
	public void callPauseMusic();
	public void callReplayMusic();
	
	public void callSeekToPositon(int position);
}
