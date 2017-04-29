package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.activity.seventh.DialogActivity;
import com.cuileikun.androidbase.activity.seventh.FrameAnimationActivity;
import com.cuileikun.androidbase.activity.seventh.GlobalizationActivity;
import com.cuileikun.androidbase.activity.seventh.IpDialerActivity;
import com.cuileikun.androidbase.activity.seventh.ListenSdcardStateActivity;
import com.cuileikun.androidbase.activity.seventh.PhoneRestartActivity;
import com.cuileikun.androidbase.activity.seventh.PowerSavingAssistantActivity;
import com.cuileikun.androidbase.activity.seventh.ReceiveUnorderedBroadcastActivity;
import com.cuileikun.androidbase.activity.seventh.SendUnorderedBroadcastActivity;
import com.cuileikun.androidbase.activity.seventh.SpecalBroadcasterActivity;
import com.cuileikun.androidbase.activity.seventh.ThemeStyleActivity;
import com.cuileikun.androidbase.activity.seventh.UninstallInstallActivity;
import com.cuileikun.androidbase.activity.seventh.XidadaFenRiceActivity;
import com.cuileikun.androidbase.activity.seventh.XidadaFenRiceEightActivity;

/**
 * Created by Admin on 2017/4/29.
 */

public class AndroidBaseSevenActivity extends Activity implements View.OnClickListener {

    private Button btnIpDialer;
    private Button btnListenSdcardState;
    private Button btnPowerSavingAssistant;
    private Button btnUninstallInstall;
    private Button btnPhoneRestart;
    private Button btnSendUnorderedBroadcast;
    private Button btnReceiveUnorderedBroadcast;
    private Button btnXidadaFenRiceEight;
    private Button btnXidadaFenRice;
    private Button btnSpecalBroadcast;
    private Button btnThemeStyle;
    private Button btnGlobalization;
    private Button btnDialog;
    private Button btnFrameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_base_seven);
        initView();
    }

    private void initView() {
        btnIpDialer = (Button) findViewById(R.id.btn_ip_dialer);
        btnListenSdcardState = (Button) findViewById(R.id.btn_listen_sdcard_state);
        btnPowerSavingAssistant = (Button) findViewById(R.id.btn_power_saving_assistant);
        btnUninstallInstall = (Button) findViewById(R.id.btn_uninstall_install);
        btnPhoneRestart = (Button) findViewById(R.id.btn_phone_restart);
        btnSendUnorderedBroadcast = (Button) findViewById(R.id.btn_send_unordered_broadcast);
        btnReceiveUnorderedBroadcast = (Button) findViewById(R.id.btn_receive_unordered_broadcast);
        btnXidadaFenRiceEight = (Button) findViewById(R.id.btn_xidada_fen_rice_eight);
        btnXidadaFenRice = (Button) findViewById(R.id.btn_xidada_fen_rice);
        btnSpecalBroadcast = (Button) findViewById(R.id.btn_specal_broadcast);
        btnThemeStyle = (Button) findViewById(R.id.btn_theme_style);
        btnGlobalization = (Button) findViewById(R.id.btn_globalization);
        btnDialog = (Button) findViewById(R.id.btn_dialog);
        btnFrameAnimation = (Button) findViewById(R.id.btn_frame_animation);
        addListener();
    }

    private void addListener() {
        btnIpDialer.setOnClickListener(AndroidBaseSevenActivity.this);
        btnListenSdcardState.setOnClickListener(AndroidBaseSevenActivity.this);
        btnPowerSavingAssistant.setOnClickListener(AndroidBaseSevenActivity.this);
        btnUninstallInstall.setOnClickListener(AndroidBaseSevenActivity.this);
        btnPhoneRestart.setOnClickListener(AndroidBaseSevenActivity.this);
        btnSendUnorderedBroadcast.setOnClickListener(AndroidBaseSevenActivity.this);
        btnReceiveUnorderedBroadcast.setOnClickListener(AndroidBaseSevenActivity.this);
        btnXidadaFenRiceEight.setOnClickListener(AndroidBaseSevenActivity.this);
        btnXidadaFenRice.setOnClickListener(AndroidBaseSevenActivity.this);
        btnSpecalBroadcast.setOnClickListener(AndroidBaseSevenActivity.this);
        btnThemeStyle.setOnClickListener(AndroidBaseSevenActivity.this);
        btnGlobalization.setOnClickListener(AndroidBaseSevenActivity.this);
        btnDialog.setOnClickListener(AndroidBaseSevenActivity.this);
        btnFrameAnimation.setOnClickListener(AndroidBaseSevenActivity.this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_ip_dialer:
                startActivity(new Intent(AndroidBaseSevenActivity.this,IpDialerActivity.class));
                break;
            case R.id.btn_listen_sdcard_state:
                startActivity(new Intent(AndroidBaseSevenActivity.this,ListenSdcardStateActivity.class));
                break;
            case R.id.btn_power_saving_assistant:
                startActivity(new Intent(AndroidBaseSevenActivity.this,PowerSavingAssistantActivity.class));
                break;
            case R.id.btn_uninstall_install:
                startActivity(new Intent(AndroidBaseSevenActivity.this,UninstallInstallActivity.class));
                break;
            case R.id.btn_phone_restart:
                startActivity(new Intent(AndroidBaseSevenActivity.this,PhoneRestartActivity.class));
                break;
            case R.id.btn_send_unordered_broadcast:
                startActivity(new Intent(AndroidBaseSevenActivity.this,SendUnorderedBroadcastActivity.class));
                break;
            case R.id.btn_receive_unordered_broadcast:
                startActivity(new Intent(AndroidBaseSevenActivity.this,ReceiveUnorderedBroadcastActivity.class));
                break;
            case R.id.btn_xidada_fen_rice_eight:
                startActivity(new Intent(AndroidBaseSevenActivity.this,XidadaFenRiceEightActivity.class));
                break;
            case R.id.btn_xidada_fen_rice:
                startActivity(new Intent(AndroidBaseSevenActivity.this,XidadaFenRiceActivity.class));
                break;
            case R.id.btn_specal_broadcast:
                startActivity(new Intent(AndroidBaseSevenActivity.this,SpecalBroadcasterActivity.class));
                break;
            case R.id.btn_theme_style:
                startActivity(new Intent(AndroidBaseSevenActivity.this,ThemeStyleActivity.class));
                break;
            case R.id.btn_globalization:
                startActivity(new Intent(AndroidBaseSevenActivity.this,GlobalizationActivity.class));
                break;
            case R.id.btn_dialog:
                startActivity(new Intent(AndroidBaseSevenActivity.this,DialogActivity.class));
                break;
            case R.id.btn_frame_animation:
                startActivity(new Intent(AndroidBaseSevenActivity.this,FrameAnimationActivity.class));
                break;
        }

    }
}
