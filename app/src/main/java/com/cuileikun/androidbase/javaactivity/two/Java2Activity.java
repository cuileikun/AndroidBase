package com.cuileikun.androidbase.javaactivity.two;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cuileikun.androidbase.R;

public class Java2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button first_btn;
    private Button second_btn;
    private Button third_btn;
    private Button fourth_btn;
    private Button fifth_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java2);
        initView();
        addListener();

    }

    private void addListener() {
        first_btn.setOnClickListener(Java2Activity.this);
        second_btn.setOnClickListener(Java2Activity.this);
        third_btn.setOnClickListener(Java2Activity.this);
        fourth_btn.setOnClickListener(Java2Activity.this);
        fifth_btn.setOnClickListener(Java2Activity.this);

    }

    private void initView() {
        first_btn = (Button) findViewById(R.id.first_btn);
        second_btn = (Button) findViewById(R.id.second_btn);
        third_btn = (Button) findViewById(R.id.third_btn);
        fourth_btn = (Button) findViewById(R.id.fourth_btn);
        fifth_btn = (Button) findViewById(R.id.fifth_btn);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_btn:
                startActivity(new Intent(Java2Activity.this,FirstBtnActivity.class));
                break;
            case R.id.second_btn:
                startActivity(new Intent(Java2Activity.this,SecondBtnActivity.class));
                break;
            case R.id.third_btn:
                startActivity(new Intent(Java2Activity.this,ThirdBtnActivity.class));
                break;
            case R.id.fourth_btn:
                startActivity(new Intent(Java2Activity.this,FourthBtnActivity.class));
                break;
            case R.id.fifth_btn:
                startActivity(new Intent(Java2Activity.this,FifthBtnActivity.class));
                break;
        }

    }


}
