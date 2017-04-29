package com.cuileikun.androidbase.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.activity.first.AndroidBaseFirstActivity;
import com.qk.applibrary.activity.QkActivity;
import com.qk.applibrary.listener.TopbarImplListener;
import com.qk.applibrary.widget.TopbarView;

public class AndroidBaseActivity extends QkActivity implements View.OnClickListener {
    private TopbarView topbarView;
    private RelativeLayout day_one_rl;
    private RelativeLayout day_two_rl;
    private RelativeLayout day_three_rl;
    private RelativeLayout day_four_rl;
    private RelativeLayout day_five_rl;
    private RelativeLayout day_six_rl;
    private RelativeLayout day_seven_rl;

    @Override
    public int getLayoutId() {
        return R.layout.activity_android_base;
    }

    @Override
    public void initViews() {
        topbarView = (TopbarView) findViewById(R.id.top_bar_view);
        day_one_rl = (RelativeLayout) findViewById(R.id.day_one_rl);
        day_two_rl = (RelativeLayout) findViewById(R.id.day_two_rl);
        day_three_rl = (RelativeLayout) findViewById(R.id.day_three_rl);
        day_four_rl = (RelativeLayout) findViewById(R.id.day_four_rl);
        day_five_rl = (RelativeLayout) findViewById(R.id.day_five_rl);
        day_six_rl = (RelativeLayout) findViewById(R.id.day_six_rl);
        day_seven_rl = (RelativeLayout) findViewById(R.id.day_seven_rl);


    }

    @Override
    public void initData() {
        topbarView.setTopbarTitle(getString(R.string.android_base_list));
    }

    @Override
    public void addListeners() {
        topbarView.setTopBarClickListener(topListener);
        day_one_rl.setOnClickListener(AndroidBaseActivity.this);
        day_two_rl.setOnClickListener(AndroidBaseActivity.this);
        day_three_rl.setOnClickListener(AndroidBaseActivity.this);
        day_four_rl.setOnClickListener(AndroidBaseActivity.this);
        day_five_rl.setOnClickListener(AndroidBaseActivity.this);
        day_six_rl.setOnClickListener(AndroidBaseActivity.this);
        day_seven_rl.setOnClickListener(AndroidBaseActivity.this);

    }

    private TopbarImplListener topListener = new TopbarImplListener() {
        @Override
        public void leftButtonClick() {
            finish();
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.day_one_rl:
                startActivity(new Intent(AndroidBaseActivity.this, AndroidBaseFirstActivity.class));
                break;
            case R.id.day_two_rl:
                startActivity(new Intent(AndroidBaseActivity.this, AndroidBaseSecondActivity.class));
                break;
            case R.id.day_three_rl:
                startActivity(new Intent(AndroidBaseActivity.this, AndroidBaseThirdActivity.class));
                break;
            case R.id.day_four_rl:
                startActivity(new Intent(AndroidBaseActivity.this, AndroidBaseFouthActivity.class));
                break;

            case R.id.day_five_rl:
                startActivity(new Intent(AndroidBaseActivity.this, AndroidBaseFivthActivity.class));
                break;

            case R.id.day_six_rl:
                startActivity(new Intent(AndroidBaseActivity.this, AndroidBaseSixActivity.class));
                break;

            case R.id.day_seven_rl:
                startActivity(new Intent(AndroidBaseActivity.this, AndroidBaseSevenActivity.class));
                break;

        }


    }


}
