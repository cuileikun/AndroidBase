package com.cuileikun.androidbase.activity.eleven;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class ViewAnimActivity extends Activity {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim);
        //用来执行动画

        iv = (ImageView) findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "你点不到我",Toast.LENGTH_SHORT).show();
            }
        });

    }


    //点击按钮  执行一个透明动画效果
    public void click1(View v) {
        //1.0代表完全不透明    0.0代表完全透明
        AlphaAnimation aa= new AlphaAnimation(1.0f,0.0f);
        //动画执行的时间
        aa.setDuration(2000);
        aa.setRepeatCount(1); //设置动画重复的次数
        aa.setRepeatMode(Animation.REVERSE);//设置重复的模式

        //iv执行动画
        iv.startAnimation(aa);


    }

    //点击按钮 实现一个旋转的动画
    public void click2(View v) {

        //RotateAnimation ra = new RotateAnimation(0, 360);
        RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(2000);
        ra.setRepeatCount(1); //设置动画重复的次数
        ra.setRepeatMode(Animation.REVERSE);//设置重复的模式
        iv.startAnimation(ra);

    }


    //点击按钮 实现缩放动画
    public void click3(View v) {
        ScaleAnimation sa = new ScaleAnimation(1.0f, 5.0f, 1.0f, 5.0f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(2000);
        sa.setRepeatCount(1); //设置动画重复的次数
        sa.setRepeatMode(Animation.REVERSE);//设置重复的模式
        iv.startAnimation(sa);


    }

    //点击按钮实现位移动画
    public void click4(View v) {
        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT,0.2f);

        ta.setDuration(2000);
        //当动画执行结束后  动画停留在结束的位置上
        ta.setFillAfter(true);
        iv.startAnimation(ta);


    }

    //点击按钮 实现一起飞的动能
    public void click5(View v) {

        AnimationSet set = new AnimationSet(true);

        AlphaAnimation aa= new AlphaAnimation(1.0f,0.0f);
        //动画执行的时间
        aa.setDuration(2000);
        aa.setRepeatCount(1); //设置动画重复的次数
        aa.setRepeatMode(Animation.REVERSE);//设置重复的模式


        RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(2000);
        ra.setRepeatCount(1); //设置动画重复的次数
        ra.setRepeatMode(Animation.REVERSE);//设置重复的模式

        ScaleAnimation sa = new ScaleAnimation(1.0f, 5.0f, 1.0f, 5.0f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(2000);
        sa.setRepeatCount(1); //设置动画重复的次数
        sa.setRepeatMode(Animation.REVERSE);//设置重复的模式

        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT,0.2f);

        ta.setDuration(2000);
        //当动画执行结束后  动画停留在结束的位置上
        ta.setFillAfter(true);


        set.addAnimation(aa);
        set.addAnimation(ra);
        set.addAnimation(sa);
        set.addAnimation(ta);
        //执行动画
        iv.startAnimation(set);


    }

}
