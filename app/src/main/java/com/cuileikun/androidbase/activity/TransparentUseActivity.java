package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.cuileikun.androidbase.R;

/**
 * 作者：popular cui
 * 时间：2017/4/27 21:01
 * 功能:
 */
public class TransparentUseActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent_use);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
