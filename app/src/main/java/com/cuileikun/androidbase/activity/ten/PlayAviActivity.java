package com.cuileikun.androidbase.activity.ten;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class PlayAviActivity extends Activity {
    private MediaPlayer mediaPlayer;
    private int currentPosition; //当前视频播放的位置
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_avi);

        SurfaceView sfv = (SurfaceView) findViewById(R.id.sfv);

        // [1.1]获取 surfaceHolder
        SurfaceHolder holder = sfv.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {

            //sufrfaceView销毁了
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

                System.out.println("surfaceDestroyed");

                if (mediaPlayer!=null && mediaPlayer.isPlaying()) {
                    //正在播放
                    //获取到当前播放的位置
                    currentPosition = mediaPlayer.getCurrentPosition();
                    //停止播放
                    mediaPlayer.stop();

                }


            }

            //说明sufrfaceView 准备好了
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                //在这个方法里面去播放视频
                try {
                    // [1]获取mediaplayer 实例
                    mediaPlayer = new MediaPlayer();

                    mediaPlayer.setDataSource("mnt/sdcard/test1.3gp");

                    // [3]准备播放
                    mediaPlayer.prepareAsync();

                    // [3.1]设置视频播放的内容 显示的位置 surfaceHolder 用来维护视频的内容
                    mediaPlayer.setDisplay(holder);

                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            // [4]开始播放
                            mediaPlayer.start();

                            //[5]继续上次的位置继续播放
                            mediaPlayer.seekTo(currentPosition);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                       int height) {

            }
        });


    }
}
