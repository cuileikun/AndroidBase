package com.cuileikun.androidbase.activity.ten;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class UseVideoViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_video_view);

        //[1]检查vitamio框架是否可用
//        if (!LibsChecker.checkVitamioLibs(this)) {
//            return;
//        }

        final VideoView vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoPath("http://169.254.87.250:8080/aa.avi");
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                vv.start();

            }
        });
        //设置video的控制器 加上播放的控制条
        vv.setMediaController(new MediaController(this));
    }
}
