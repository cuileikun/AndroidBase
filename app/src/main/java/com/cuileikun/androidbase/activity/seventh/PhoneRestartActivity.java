package com.cuileikun.androidbase.activity.seventh;

import android.app.Activity;
import android.os.Bundle;

import com.cuileikun.androidbase.R;

/**
 * Created by Admin on 2017/4/29.
 */

public class PhoneRestartActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_restart);
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

}
