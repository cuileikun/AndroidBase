package com.cuileikun.androidbase.activity.eleven;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.fragment.Fragment7;
import com.cuileikun.androidbase.fragment.Fragment8;

/**
 * Created by Admin on 2017/4/29.
 */

public class FragmentContactActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_contact);
        //获取管理者
        FragmentManager fragmentManager = getFragmentManager();
        //开启事务
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.ll1, new Fragment7(),"f1");
        beginTransaction.replace(R.id.ll2, new Fragment8(),"f2");
        //记得commit
        beginTransaction.commit();
    }
}
