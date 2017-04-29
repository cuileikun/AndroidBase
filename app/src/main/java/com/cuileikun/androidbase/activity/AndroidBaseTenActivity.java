package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.activity.ten.BaiduMusicActivity;
import com.cuileikun.androidbase.activity.ten.CreateOriginImageBackupActivity;
import com.cuileikun.androidbase.activity.ten.DealImageActivity;
import com.cuileikun.androidbase.activity.ten.LoadBigImageActivity;
import com.cuileikun.androidbase.activity.ten.PaintActivity;
import com.cuileikun.androidbase.activity.ten.PlayAudioActivity;
import com.cuileikun.androidbase.activity.ten.PlayAviActivity;
import com.cuileikun.androidbase.activity.ten.PlayNetSongActivity;
import com.cuileikun.androidbase.activity.ten.TakePhotoAviActivity;
import com.cuileikun.androidbase.activity.ten.TearClothesActivity;
import com.cuileikun.androidbase.activity.ten.UseVideoViewActivity;

/**
 * Created by Admin on 2017/4/29.
 */

public class AndroidBaseTenActivity extends Activity implements View.OnClickListener {
    private Button btnLoadBigImage;
    private Button btnCreateOriginImageBackup;
    private Button btnDealImage;
    private Button btnPaint;
    private Button btnTearClothes;
    private Button btnPlayAudio;
    private Button btnBaiduMusic;
    private Button btnPlayNetSong;
    private Button btnPlayAvi;
    private Button btnUseVideoView;
    private Button btnTakePhotoAvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andrid_base_ten);
        initView();
    }

    private void initView() {
        btnLoadBigImage = (Button) findViewById(R.id.btn_load_big_image);
        btnCreateOriginImageBackup = (Button) findViewById(R.id.btn_create_origin_image_backup);
        btnDealImage = (Button) findViewById(R.id.btn_deal_image);
        btnPaint = (Button) findViewById(R.id.btn_paint);
        btnTearClothes = (Button) findViewById(R.id.btn_tear_clothes);
        btnPlayAudio = (Button) findViewById(R.id.btn_play_audio);
        btnBaiduMusic = (Button) findViewById(R.id.btn_baidu_music);
        btnPlayNetSong = (Button) findViewById(R.id.btn_play_net_song);
        btnPlayAvi = (Button) findViewById(R.id.btn_play_avi);
        btnUseVideoView = (Button) findViewById(R.id.btn_use_video_view);
        btnTakePhotoAvi = (Button) findViewById(R.id.btn_take_photo_avi);
        addListener();
    }

    private void addListener() {
        btnLoadBigImage.setOnClickListener(AndroidBaseTenActivity.this);
        btnCreateOriginImageBackup.setOnClickListener(AndroidBaseTenActivity.this);
        btnDealImage.setOnClickListener(AndroidBaseTenActivity.this);
        btnPaint.setOnClickListener(AndroidBaseTenActivity.this);
        btnTearClothes.setOnClickListener(AndroidBaseTenActivity.this);
        btnPlayAudio.setOnClickListener(AndroidBaseTenActivity.this);
        btnBaiduMusic.setOnClickListener(AndroidBaseTenActivity.this);
        btnPlayNetSong.setOnClickListener(AndroidBaseTenActivity.this);
        btnPlayAvi.setOnClickListener(AndroidBaseTenActivity.this);
        btnUseVideoView.setOnClickListener(AndroidBaseTenActivity.this);
        btnTakePhotoAvi.setOnClickListener(AndroidBaseTenActivity.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_load_big_image:
                startActivity(new Intent(AndroidBaseTenActivity.this, LoadBigImageActivity.class));
                break;
            case R.id.btn_create_origin_image_backup:
                startActivity(new Intent(AndroidBaseTenActivity.this, CreateOriginImageBackupActivity.class));
                break;
            case R.id.btn_deal_image:
                startActivity(new Intent(AndroidBaseTenActivity.this, DealImageActivity.class));
                break;
            case R.id.btn_paint:
                startActivity(new Intent(AndroidBaseTenActivity.this, PaintActivity.class));
                break;
            case R.id.btn_tear_clothes:
                startActivity(new Intent(AndroidBaseTenActivity.this, TearClothesActivity.class));
                break;
            case R.id.btn_play_audio:
                startActivity(new Intent(AndroidBaseTenActivity.this, PlayAudioActivity.class));
                break;
            case R.id.btn_baidu_music:
                startActivity(new Intent(AndroidBaseTenActivity.this, BaiduMusicActivity.class));
                break;
            case R.id.btn_play_net_song:
                startActivity(new Intent(AndroidBaseTenActivity.this, PlayNetSongActivity.class));
                break;
            case R.id.btn_play_avi:
                startActivity(new Intent(AndroidBaseTenActivity.this, PlayAviActivity.class));
                break;
            case R.id.btn_use_video_view:
                startActivity(new Intent(AndroidBaseTenActivity.this, UseVideoViewActivity.class));
                break;
            case R.id.btn_take_photo_avi:
                startActivity(new Intent(AndroidBaseTenActivity.this, TakePhotoAviActivity.class));
                break;
        }

    }
}
