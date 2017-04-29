package com.cuileikun.androidbase.activity.seventh;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class FrameAnimationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fame_animation);
        //用来显示动画
        ImageView rocketImage = (ImageView) findViewById(R.id.iv);

        //设置iamgeview的背景资源
        rocketImage.setBackgroundResource(R.drawable.my_anim);

        //获取背景资源
        AnimationDrawable rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
        //开始动画
        rocketAnimation.start();
    }
}
