package com.cuileikun.androidbase.activity.fifth;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.cuileikun.androidbase.R;

/**
 * 作者：popular cui
 * 时间：2017/4/27 19:38
 * 功能:
 */
public class FreeMoreThreadActivity extends Activity {
    private EditText et_path;
    private ProgressBar pbView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_more_thread);
        //[1]找到我们关心的控件

        et_path = (EditText) findViewById(R.id.et_path);
        pbView = (ProgressBar) findViewById(R.id.progressBar1);
    }

//    //点击按钮 去指定的路径下载文件
//    public void click(View v) {
//        String path = et_path.getText().toString().trim();
//        //[2]创建httpUtils 实例
//        HttpUtils http = new HttpUtils();
//        //target目标 下载文件的存到哪个位置上
//        //true 是否支持断点续传
//        http.download(path, "/mnt/sdcard/test.mp3", true, new RequestCallBack<File>() {
//
//            //下载成功的回调
//            @Override
//            public void onSuccess(ResponseInfo<File> responseInfo) {
//                Toast.makeText(getApplicationContext(), "下载成功了", 1).show();
//            }
//
//            @Override
//            public void onLoading(long total, long current, boolean isUploading) {
//
//                //设置进度条的进度
//                pbView.setMax((int)total);
//                pbView.setProgress((int)current);
//
//                super.onLoading(total, current, isUploading);
//            }
//
//            //下载失败
//            @Override
//            public void onFailure(HttpException error, String msg) {
//
//            }
//        });
//
//    }


}
