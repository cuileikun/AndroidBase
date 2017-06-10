package com.cuileikun.androidbase.javaactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.javaactivity.eight.Java8Activity;
import com.cuileikun.androidbase.javaactivity.eleven.Java11Activity;
import com.cuileikun.androidbase.javaactivity.five.Java5Activity;
import com.cuileikun.androidbase.javaactivity.four.Java4Activity;
import com.cuileikun.androidbase.javaactivity.nine.Java9Activity;
import com.cuileikun.androidbase.javaactivity.seven.Java7Activity;
import com.cuileikun.androidbase.javaactivity.six.Java6Activity;
import com.cuileikun.androidbase.javaactivity.ten.Java10Activity;
import com.cuileikun.androidbase.javaactivity.three.Java3Activity;
import com.cuileikun.androidbase.javaactivity.twelve.Java12Activity;
import com.cuileikun.androidbase.javaactivity.two.Java2Activity;

public class JavaBaseActivity extends Activity implements View.OnClickListener {
    private RelativeLayout day_one_rl;
    private RelativeLayout day_two_rl;
    private RelativeLayout day_three_rl;
    private RelativeLayout day_four_rl;
    private RelativeLayout day_five_rl;
    private RelativeLayout day_six_rl;
    private RelativeLayout day_seven_rl;
    private RelativeLayout day_eight_rl;
    private RelativeLayout day_nine_rl;
    private RelativeLayout day_ten_rl;
    private RelativeLayout day_eleven_rl;
    private RelativeLayout day_twelve_rl;
    private RelativeLayout day_13_rl;
    private RelativeLayout day_14_rl;
    private RelativeLayout day_15_rl;
    private RelativeLayout day_16_rl;
    private RelativeLayout day_17_rl;
    private RelativeLayout day_18_rl;
    private RelativeLayout day_19_rl;
    private RelativeLayout day_20_rl;
    private RelativeLayout day_21_rl;
    private RelativeLayout day_22_rl;
    private RelativeLayout day_23_rl;
    private RelativeLayout day_24_rl;
    private RelativeLayout day_25_rl;
    private RelativeLayout day_26_rl;
    private RelativeLayout day_27_rl;
    private RelativeLayout day_28_rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_base);
        initView();
        addListeners();

    }

    private void addListeners() {
        day_one_rl.setOnClickListener(JavaBaseActivity.this);
        day_two_rl.setOnClickListener(JavaBaseActivity.this);
        day_three_rl.setOnClickListener(JavaBaseActivity.this);
        day_four_rl.setOnClickListener(JavaBaseActivity.this);
        day_five_rl.setOnClickListener(JavaBaseActivity.this);
        day_six_rl.setOnClickListener(JavaBaseActivity.this);
        day_seven_rl.setOnClickListener(JavaBaseActivity.this);
        day_eight_rl.setOnClickListener(JavaBaseActivity.this);
        day_nine_rl.setOnClickListener(JavaBaseActivity.this);
        day_ten_rl.setOnClickListener(JavaBaseActivity.this);
        day_eleven_rl.setOnClickListener(JavaBaseActivity.this);
        day_twelve_rl.setOnClickListener(JavaBaseActivity.this);
        day_13_rl.setOnClickListener(JavaBaseActivity.this);
        day_14_rl.setOnClickListener(JavaBaseActivity.this);
        day_15_rl.setOnClickListener(JavaBaseActivity.this);
        day_16_rl.setOnClickListener(JavaBaseActivity.this);
        day_17_rl.setOnClickListener(JavaBaseActivity.this);
        day_18_rl.setOnClickListener(JavaBaseActivity.this);
        day_19_rl.setOnClickListener(JavaBaseActivity.this);
        day_20_rl.setOnClickListener(JavaBaseActivity.this);
        day_21_rl.setOnClickListener(JavaBaseActivity.this);
        day_22_rl.setOnClickListener(JavaBaseActivity.this);
        day_23_rl.setOnClickListener(JavaBaseActivity.this);
        day_24_rl.setOnClickListener(JavaBaseActivity.this);
        day_25_rl.setOnClickListener(JavaBaseActivity.this);
        day_26_rl.setOnClickListener(JavaBaseActivity.this);
        day_27_rl.setOnClickListener(JavaBaseActivity.this);
        day_28_rl.setOnClickListener(JavaBaseActivity.this);
    }

    private void initView() {
        day_one_rl = (RelativeLayout) findViewById(R.id.day_one_rl);
        day_two_rl = (RelativeLayout) findViewById(R.id.day_two_rl);
        day_three_rl = (RelativeLayout) findViewById(R.id.day_three_rl);
        day_four_rl = (RelativeLayout) findViewById(R.id.day_four_rl);
        day_five_rl = (RelativeLayout) findViewById(R.id.day_five_rl);
        day_six_rl = (RelativeLayout) findViewById(R.id.day_six_rl);
        day_seven_rl = (RelativeLayout) findViewById(R.id.day_seven_rl);
        day_eight_rl = (RelativeLayout) findViewById(R.id.day_eight_rl);
        day_nine_rl = (RelativeLayout) findViewById(R.id.day_nine_rl);
        day_ten_rl = (RelativeLayout) findViewById(R.id.day_ten_rl);
        day_eleven_rl = (RelativeLayout) findViewById(R.id.day_eleven_rl);
        day_twelve_rl = (RelativeLayout) findViewById(R.id.day_twelve_rl);
        day_13_rl = (RelativeLayout) findViewById(R.id.day_13_rl);
        day_14_rl = (RelativeLayout) findViewById(R.id.day_14_rl);
        day_15_rl = (RelativeLayout) findViewById(R.id.day_15_rl);
        day_16_rl = (RelativeLayout) findViewById(R.id.day_16_rl);
        day_17_rl = (RelativeLayout) findViewById(R.id.day_17_rl);
        day_18_rl = (RelativeLayout) findViewById(R.id.day_18_rl);
        day_19_rl = (RelativeLayout) findViewById(R.id.day_19_rl);
        day_20_rl = (RelativeLayout) findViewById(R.id.day_20_rl);
        day_21_rl = (RelativeLayout) findViewById(R.id.day_21_rl);
        day_22_rl = (RelativeLayout) findViewById(R.id.day_22_rl);
        day_23_rl = (RelativeLayout) findViewById(R.id.day_23_rl);
        day_24_rl = (RelativeLayout) findViewById(R.id.day_24_rl);
        day_25_rl = (RelativeLayout) findViewById(R.id.day_25_rl);
        day_26_rl = (RelativeLayout) findViewById(R.id.day_26_rl);
        day_27_rl = (RelativeLayout) findViewById(R.id.day_27_rl);
        day_28_rl = (RelativeLayout) findViewById(R.id.day_28_rl);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.day_one_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java1Activity.class));
                break;
            case R.id.day_two_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java2Activity.class));
                break;
            case R.id.day_three_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java3Activity.class));
                break;
            case R.id.day_four_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java4Activity.class));
                break;
            case R.id.day_five_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java5Activity.class));
                break;
            case R.id.day_six_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java6Activity.class));
                break;
            case R.id.day_seven_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java7Activity.class));
                break;
            case R.id.day_eight_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java8Activity.class));
                break;
            case R.id.day_nine_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java9Activity.class));
                break;
            case R.id.day_ten_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java10Activity.class));
                break;
            case R.id.day_eleven_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java11Activity.class));
                break;
            case R.id.day_twelve_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java12Activity.class));
                break;
            case R.id.day_13_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java13Activity.class));
                break;
            case R.id.day_14_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java14Activity.class));
                break;

            case R.id.day_15_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java15Activity.class));
                break;
            case R.id.day_16_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java16Activity.class));
                break;
            case R.id.day_17_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java17Activity.class));
                break;
            case R.id.day_18_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java18Activity.class));
                break;
            case R.id.day_19_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java19Activity.class));
                break;
            case R.id.day_20_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java20Activity.class));
                break;
            case R.id.day_21_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java21Activity.class));
                break;
            case R.id.day_22_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java22Activity.class));
                break;
            case R.id.day_23_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java23Activity.class));
                break;
            case R.id.day_24_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java24Activity.class));
                break;
            case R.id.day_25_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java25Activity.class));
                break;
            case R.id.day_26_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java26Activity.class));
                break;
            case R.id.day_27_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java27Activity.class));
                break;
            case R.id.day_28_rl:
                startActivity(new Intent(JavaBaseActivity.this,Java28Activity.class));
                break;
        }
    }


}
