package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.activity.eleven.AutoCompleteTextViewActivity;
import com.cuileikun.androidbase.activity.eleven.BackupMessageActivity;
import com.cuileikun.androidbase.activity.eleven.FragmentContactActivity;
import com.cuileikun.androidbase.activity.eleven.FragmentLifeActivity;
import com.cuileikun.androidbase.activity.eleven.FragmentLowVersionActivity;
import com.cuileikun.androidbase.activity.eleven.FragmentZeroActivity;
import com.cuileikun.androidbase.activity.eleven.InsteadFragmentActivity;
import com.cuileikun.androidbase.activity.eleven.MenuActivity;
import com.cuileikun.androidbase.activity.eleven.NoticationActivity;
import com.cuileikun.androidbase.activity.eleven.ViewAnimActivity;
import com.cuileikun.androidbase.activity.eleven.WeixinMainContentActivity;
import com.cuileikun.androidbase.activity.eleven.XmlTweenedAnimationActivity;

/**
 * Created by Admin on 2017/4/29.
 */

public class AndroidBaseElevenActivity extends Activity implements View.OnClickListener {
    private Button btnFragmentZero;
    private Button btnInsteadFragment;
    private Button btnWeixinMainContent;
    private Button btnFragmentLowVersion;
    private Button btnFragmentLife;
    private Button btnFragmentContact;
    private Button btnMenu;
    private Button btnAutoCompleteTextView;
    private Button btnViewAnim;
    private Button btnXmlTweenedAnimation;
    private Button btnNotication;
    private Button btnBackupMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andrid_base_eleven);
        initView();
    }

    private void initView() {
        btnFragmentZero = (Button) findViewById(R.id.btn_fragment_zero);
        btnInsteadFragment = (Button) findViewById(R.id.btn_instead_fragment);
        btnWeixinMainContent = (Button) findViewById(R.id.btn_weixin_main_content);
        btnFragmentLowVersion = (Button) findViewById(R.id.btn_fragment_low_version);
        btnFragmentLife = (Button) findViewById(R.id.btn_fragment_life);
        btnFragmentContact = (Button) findViewById(R.id.btn_fragment_contact);
        btnMenu = (Button) findViewById(R.id.btn_menu);
        btnAutoCompleteTextView = (Button) findViewById(R.id.btn_auto_complete_text_view);
        btnViewAnim = (Button) findViewById(R.id.btn_view_anim);
        btnXmlTweenedAnimation = (Button) findViewById(R.id.btn_xml_tweened_animation);
        btnNotication = (Button) findViewById(R.id.btn_notication);
        btnBackupMessage = (Button) findViewById(R.id.btn_backup_message);
        addListener();
    }

    private void addListener() {
        btnFragmentZero.setOnClickListener(AndroidBaseElevenActivity.this);
        btnInsteadFragment.setOnClickListener(AndroidBaseElevenActivity.this);
        btnWeixinMainContent.setOnClickListener(AndroidBaseElevenActivity.this);
        btnFragmentLowVersion.setOnClickListener(AndroidBaseElevenActivity.this);
        btnFragmentLife.setOnClickListener(AndroidBaseElevenActivity.this);
        btnFragmentContact.setOnClickListener(AndroidBaseElevenActivity.this);
        btnMenu.setOnClickListener(AndroidBaseElevenActivity.this);
        btnAutoCompleteTextView.setOnClickListener(AndroidBaseElevenActivity.this);
        btnViewAnim.setOnClickListener(AndroidBaseElevenActivity.this);
        btnXmlTweenedAnimation.setOnClickListener(AndroidBaseElevenActivity.this);
        btnNotication.setOnClickListener(AndroidBaseElevenActivity.this);
        btnBackupMessage.setOnClickListener(AndroidBaseElevenActivity.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fragment_zero:
                startActivity(new Intent(AndroidBaseElevenActivity.this, FragmentZeroActivity.class));
                break;
            case R.id.btn_instead_fragment:
                startActivity(new Intent(AndroidBaseElevenActivity.this, InsteadFragmentActivity.class));
                break;
            case R.id.btn_weixin_main_content:
                startActivity(new Intent(AndroidBaseElevenActivity.this, WeixinMainContentActivity.class));
                break;
            case R.id.btn_fragment_low_version:
                startActivity(new Intent(AndroidBaseElevenActivity.this, FragmentLowVersionActivity.class));
                break;
            case R.id.btn_fragment_life:
                startActivity(new Intent(AndroidBaseElevenActivity.this, FragmentLifeActivity.class));
                break;
            case R.id.btn_fragment_contact:
                startActivity(new Intent(AndroidBaseElevenActivity.this, FragmentContactActivity.class));
                break;
            case R.id.btn_menu:
                startActivity(new Intent(AndroidBaseElevenActivity.this, MenuActivity.class));
                break;
            case R.id.btn_auto_complete_text_view:
                startActivity(new Intent(AndroidBaseElevenActivity.this, AutoCompleteTextViewActivity.class));
                break;
            case R.id.btn_view_anim:
                startActivity(new Intent(AndroidBaseElevenActivity.this, ViewAnimActivity.class));
                break;
            case R.id.btn_xml_tweened_animation:
                startActivity(new Intent(AndroidBaseElevenActivity.this, XmlTweenedAnimationActivity.class));
                break;
            case R.id.btn_notication:
                startActivity(new Intent(AndroidBaseElevenActivity.this, NoticationActivity.class));
                break;
            case R.id.btn_backup_message:
                startActivity(new Intent(AndroidBaseElevenActivity.this, BackupMessageActivity.class));
                break;
        }
    }
}
