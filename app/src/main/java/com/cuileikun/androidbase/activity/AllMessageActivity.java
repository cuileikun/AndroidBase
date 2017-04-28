package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cuileikun.androidbase.R;

/**
 * 作者：popular cui
 * 时间：2017/4/27 21:00
 * 功能:
 */
public class AllMessageActivity extends Activity {



    //[0]准备listview要显示的数据
    private String[] objects = {"今天的风儿轻柔无比，今天的花儿香飘万里；今天的鸟儿十分欢喜，今天的云儿满载笑意；今天的事儿万分顺利，今天的人儿如此甜蜜。所有美...",
            "丫头，生活是你自己的，你哭它就对你哭，你笑它就对你笑。转眼，又是一年，你的生日即将来到。今年，还是少不了我对你的祝福，我忍不住...",
            "世界上最动听的声音，是妈妈声声的呼唤；世界上最温暖的笑容，是妈妈温暖的笑脸。妈妈，原谅生日时我不能陪在您身边，在这个日子里，我...",
            "今天是你的生日，祝你：发财势头如快马加鞭，一日千里；发展速度如滔滔江水，势不可挡；好事发生如雨后春笋，络绎不绝；祝福发送如比赛..."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_message);
        //[1]找到控件
        ListView lv = (ListView) findViewById(R.id.lv);

        //[2]准备适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item, objects);

        //[3]显示数据
        lv.setAdapter(adapter);

        //[4]给listview设置点击事件
        lv.setOnItemClickListener(new  AdapterView.OnItemClickListener() {

            //当listview的条目被点击的时候调用这个方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //[5]取出点中条目的数据  数据在哪里面存着 就去哪里取
                String content = objects[position];


                //[6]跳转到发送短信的页面  用隐式
                Intent intent = new Intent();

				/*  <intent-filter>
	               <action android:name="android.intent.action.SEND" />
	               <category android:name="android.intent.category.DEFAULT" />
	               <data android:mimeType="text/plain" />
	           </intent-filter>*/

                //设置action
                intent.setAction("android.intent.action.SEND");
                //设置category
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setType("text/plain");

                //[6.1]传递数据
                intent.putExtra("sms_body", content); //关键问题是name怎么写
//
                //开启Activity
                startActivity(intent);


            }
        });

    }

}
