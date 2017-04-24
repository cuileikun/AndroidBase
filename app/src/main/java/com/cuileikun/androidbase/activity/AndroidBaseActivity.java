package com.cuileikun.androidbase.activity;

import android.view.View;
import android.widget.RelativeLayout;

import com.cuileikun.androidbase.R;
import com.qk.applibrary.activity.QkActivity;
import com.qk.applibrary.listener.TopbarImplListener;
import com.qk.applibrary.widget.TopbarView;

public class AndroidBaseActivity extends QkActivity implements View.OnClickListener {
    private TopbarView topbarView;
    private RelativeLayout day_one_rl;
    private RelativeLayout day_two_rl;
    private RelativeLayout day_three_rl;

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

    }

    @Override
    public void initData() {
        topbarView.setTopbarTitle("Android基础列表");
    }

    @Override
    public void addListeners() {
        topbarView.setTopBarClickListener(topListener);
        day_one_rl.setOnClickListener(AndroidBaseActivity.this);
        day_two_rl.setOnClickListener(AndroidBaseActivity.this);
        day_three_rl.setOnClickListener(AndroidBaseActivity.this);
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
//                startActivity(new Intent(AndroidBaseActivity.this, AndroidBaseFirstActivity.class));
                break;
            case R.id.day_two_rl:
//                startActivity(new Intent(AndroidBaseActivity.this, AndroidBaseSecondActivity.class));
                break;
            case R.id.day_three_rl:
//                startActivity(new Intent(AndroidBaseActivity.this, AndroidBaseThirdActivity.class));
                break;

        }


    }


}
