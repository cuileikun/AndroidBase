package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.activity.nine.CreatePrivateDbActivity;
import com.cuileikun.androidbase.activity.nine.CustomContentObserverActivity;
import com.cuileikun.androidbase.activity.nine.ListenTheMessageActivity;
import com.cuileikun.androidbase.activity.nine.MessageBackupActivity;
import com.cuileikun.androidbase.activity.nine.ReadTheFirstAppcontentActivity;
import com.cuileikun.androidbase.activity.nine.SearchContactActivity;
import com.cuileikun.androidbase.activity.nine.UseNeirongJiexiActivity;

/**
 * Created by Admin on 2017/4/29.
 */

public class AndroidBaseNineActivity extends Activity implements View.OnClickListener {
    private Button btnCreatePrivateDb;
    private Button btnReadTheFirstAppcontent;
    private Button btnMessageBackup;
    private Button btnSearchContact;
    private Button btnUseNeirongJiexi;
    private Button btnCustomContentObserver;
    private Button btnListenTheMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andrid_base_nine);
        initView();
    }

    private void initView() {
        btnCreatePrivateDb = (Button) findViewById(R.id.btn_create_private_db);
        btnReadTheFirstAppcontent = (Button) findViewById(R.id.btn_read_the_first_appcontent);
        btnMessageBackup = (Button) findViewById(R.id.btn_message_backup);
        btnSearchContact = (Button) findViewById(R.id.btn_search_contact);
        btnUseNeirongJiexi = (Button) findViewById(R.id.btn_use_neirong_jiexi);
        btnCustomContentObserver = (Button) findViewById(R.id.btn_custom_content_observer);
        btnListenTheMessage = (Button) findViewById(R.id.btn_listen_the_message);
        addListener();
    }


    private void addListener() {
        btnCreatePrivateDb.setOnClickListener(AndroidBaseNineActivity.this);
        btnReadTheFirstAppcontent.setOnClickListener(AndroidBaseNineActivity.this);
        btnMessageBackup.setOnClickListener(AndroidBaseNineActivity.this);
        btnSearchContact.setOnClickListener(AndroidBaseNineActivity.this);
        btnUseNeirongJiexi.setOnClickListener(AndroidBaseNineActivity.this);
        btnCustomContentObserver.setOnClickListener(AndroidBaseNineActivity.this);
        btnListenTheMessage.setOnClickListener(AndroidBaseNineActivity.this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_create_private_db:
                startActivity(new Intent(AndroidBaseNineActivity.this,CreatePrivateDbActivity.class));
                break;
            case R.id.btn_read_the_first_appcontent:
                startActivity(new Intent(AndroidBaseNineActivity.this,ReadTheFirstAppcontentActivity.class));
                break;
            case R.id.btn_message_backup:
                startActivity(new Intent(AndroidBaseNineActivity.this,MessageBackupActivity.class));
                break;
            case R.id.btn_search_contact:
                startActivity(new Intent(AndroidBaseNineActivity.this,SearchContactActivity.class));
                break;
            case R.id.btn_use_neirong_jiexi:
                startActivity(new Intent(AndroidBaseNineActivity.this,UseNeirongJiexiActivity.class));
                break;
            case R.id.btn_custom_content_observer:
                startActivity(new Intent(AndroidBaseNineActivity.this,CustomContentObserverActivity.class));
                break;
            case R.id.btn_listen_the_message:
                startActivity(new Intent(AndroidBaseNineActivity.this,ListenTheMessageActivity.class));
                break;
        }
    }
}
