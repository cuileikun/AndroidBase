package com.cuileikun.androidbase.activity.eleven;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class XmlTweenedAnimationActivity extends Activity {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_tween_animation);
        //用来执行动画

        iv = (ImageView) findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "你点不到我", 1).show();
            }
        });
    }
    //点击按钮  执行一个透明动画效果
    public void click1(View v) {

        Animation aa = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);

        //iv执行动画
        iv.startAnimation(aa);


    }

    //点击按钮 实现一个旋转的动画
    public void click2(View v) {


        Animation ra = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

        iv.startAnimation(ra);

    }


    //点击按钮 实现缩放动画
    public void click3(View v) {

        Animation sa = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);

        iv.startAnimation(sa);


    }

    //点击按钮实现位移动画
    public void click4(View v) {

        Animation ta = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
        iv.startAnimation(ta);


    }

    //点击按钮 实现一起飞的动能
    public void click5(View v) {

        Animation set = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
        //执行动画
        iv.startAnimation(set);


    }




}
