package com.cuileikun.androidbase.activity.eleven;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.WindowManager;
import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.fragment.Fragment3;

/**
 * Created by Admin on 2017/4/29.
 */

public class InsteadFragmentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instead_fragment);
        //[1]获取窗口的管理者
        WindowManager wm =  (WindowManager) getSystemService(WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        //[1.1]获取Fragment的管理者
        FragmentManager fragmentManager = getFragmentManager();
        //[1.2]开启事务
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();

        //[2]判断横竖屏
        if (height>width) {
            //说明这是竖屏   我显示Fragment1 的内容 android.R.id.content:理解成是当前手机窗体要显示的内容
//            beginTransaction.replace(R.id.main_content, new Fragment3());
            beginTransaction.replace(android.R.id.content, new Fragment3());

        }else {
            //说明是横屏   显示Fragment2的内容
//            beginTransaction.replace(R.id.main_content, new Fragment4());
            beginTransaction.replace(android.R.id.content, new Fragment3());
        }

        //[3]最后一步 一定要记得 commit
        beginTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
