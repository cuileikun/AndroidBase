package com.cuileikun.androidbase.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.javaactivity.JavaBaseActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        findViewById(R.id.android_base_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this,AndroidBaseActivity.class));
            }
        });
        findViewById(R.id.java_base_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this,JavaBaseActivity.class));
            }
        });

    }
}
