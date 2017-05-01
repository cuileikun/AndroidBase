package com.cuileikun.androidbase.activity.ten;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class PlayAudioActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_audio);
        //[1]获取mediaplayer 实例
        MediaPlayer mediaPlayer = new MediaPlayer();

        //[2]设置你要播放的音频资源的路径    path:可以是网络路径 也可以是本地路径
        try {
            mediaPlayer.setDataSource("/mnt/sdcard/xpg.mp3");

            //[3]准备播放
			mediaPlayer.prepare();
//            mediaPlayer.prepareAsync(); //一般我们播放网络音乐使用异步


            //[4]开始播放
            mediaPlayer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }

