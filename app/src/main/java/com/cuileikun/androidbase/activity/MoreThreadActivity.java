package com.cuileikun.androidbase.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.cuileikun.androidbase.R;
import com.qk.applibrary.util.CommonUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：popular cui
 * 时间：2017/4/27 19:38
 * 功能:
 */
public class MoreThreadActivity extends Activity {

    private EditText et_path; //下载的路径
    private EditText et_threadCont;//线程的数量
    private LinearLayout ll_layout; //垂直的线性布局 用来添加进度条
    private List<ProgressBar> pbs; //进度条的引用
    private String path;//下载的路径

    private int runningThread;  //代表当前正在运行的线程
    private int threadCount; //线程数量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_thread);
        //[1]找到我们关心的控件


        et_path = (EditText) findViewById(R.id.et_path);
        et_threadCont = (EditText) findViewById(R.id.et_threadCount);
        ll_layout = (LinearLayout) findViewById(R.id.ll_layout);

        //[1.1]创建一个集合 用来存进度条的引用
        pbs = new ArrayList<ProgressBar>();

    }

    //点击按钮 去指定的路径下载文件
    public void click(View v) {
        //[2]获取路径

        path = et_path.getText().toString().trim();
        String threadCountt = et_threadCont.getText().toString().trim();
        if (CommonUtil.isEmpty(threadCountt)) {
            CommonUtil.sendToast(MoreThreadActivity.this, "线程数量不能为空");
        } else {
            threadCount = Integer.parseInt(threadCountt);
        }

        //[3]根据线程的数量 动态的添加进度条
        ll_layout.removeAllViews();//添加之前 先清除
        pbs.clear();
        for (int i = 0; i < threadCount; i++) {
            ProgressBar pbView = (ProgressBar) View.inflate(getApplicationContext(), R.layout.item_second, null);
            //[4]把进度条的引用 加入到集合  方便一会我更新进度条的进度
            pbs.add(pbView);
            //[5]把进度条添加到线程布局上
            ll_layout.addView(pbView);//想添加进度条 你的想办法把进度条转换成一个view
        }


        //[6]开始下载   进行移植  把javase工程代码移植 过来
        //创建一个子线程
        new Thread() {
            public void run() {

                //一☆ ☆ ☆ ☆ 获取服务器文件的大小
                try {
                    //[2.1]创建URL 对象指定我们要访问的 网址(路径)
                    URL url = new URL(path);
                    //[2.2]拿到httpurlconnection对象  用于发送或者接收数据
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //[2.3]设置发送get请求
                    conn.setRequestMethod("GET");//get要求大写  默认就是get请求
                    //[2.4]设置请求超时时间
                    conn.setConnectTimeout(5000);
                    //[2.5]获取服务器返回的状态码
                    int code = conn.getResponseCode();
                    //[2.7]如果code == 200 说明请求成功
                    if (code == 200) {
                        //[2.8]获取服务器返回的数据   是以流的形式返回的  由于把流转换成字符串是一个非常常见的操作  所以我抽出一个工具类(utils)
                        int length = conn.getContentLength();
                        runningThread = threadCount;

                        //二 在客户端创建一个大小和服务器一模一样的文件 目的提前在客客户端把空间申请出来
                        RandomAccessFile raf = new RandomAccessFile(getFileName(path), "rw");
                        //设置文件的大小 但是无内容
                        raf.setLength(length);

                        //三 ☆ ☆ ☆ ☆ 开启多个线程去下载
                        int bloackSize = length / threadCount;

                        //☆ ☆ ☆ ☆  四 算出每个线程下载的开始位置和结束位置
                        for (int i = 0; i < threadCount; i++) {
                            int startIndex = i * bloackSize;
                            int endIndex = (i + 1) * bloackSize - 1;
                            //注意 特殊情况 最后一个线程 需要判断一下
                            if (i == threadCount - 1) {
                                endIndex = length - 1;
                            }

                            System.out.println("线程id:" + i + "理论的位置:" + startIndex + "----" + endIndex);
                            // ☆ ☆ ☆ ☆ 五 开启多个线程
                            DownLoadThread downLoadThread = new DownLoadThread(startIndex, endIndex, i);
                            downLoadThread.start();

                        }


                    }

                } catch (Exception e) {

                }


            }

            ;
        }.start();


    }


    //这个类才是真正去服务器下载数据
    private class DownLoadThread extends Thread {

        //把每个线程下载的开始位置和结束位置传递过来
        private int threadId;
        private int startIndex;
        private int endIndex;

        private int pbMaxSize; //进度条的最大值
        private int pbLastposition;//代表上次下载的位置

        public DownLoadThread(int startIndex, int endIndex, int threadId) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.threadId = threadId;
        }

        @Override
        public void run() {
            super.run();

            //去服务器下载数据
            try {

                //[2.0]算出进度条的最大值
                pbMaxSize = endIndex - startIndex;
                //[2.1]创建URL 对象指定我们要访问的 网址(路径)
                URL url = new URL(path);
                //[2.2]拿到httpurlconnection对象  用于发送或者接收数据
                HttpURLConnection conn = (HttpURLConnection) url
                        .openConnection();
                //[2.3]设置发送get请求
                conn.setRequestMethod("GET");//get要求大写  默认就是get请求
                //[2.4]设置请求超时时间
                conn.setConnectTimeout(5000);

                //☆☆☆☆☆ 如果中断过 继续上次的位置继续下
                File file = new File(getFileName(path) + threadId + ".txt");
                if (file.exists() && file.length() > 0) {
                    FileInputStream fis = new FileInputStream(file);
                    BufferedReader bufr = new BufferedReader(new InputStreamReader(fis));
                    String lastPositionn = bufr.readLine(); //就是上次下载的位置

                    //上次进度条下载的位置
                    pbLastposition = Integer.parseInt(lastPositionn);
                    //下次在下载的时候 要改变一下 startIndex位置
                    startIndex = Integer.parseInt(lastPositionn);

                    System.out.println("线程id:" + threadId + "真实开始位置:" + startIndex + "----:" + endIndex);
                    fis.close();
                }

                //☆☆☆☆☆ 要设置一个请求头信息 告诉服务器每个线程下载的开始位置 和结束位置
                conn.setRequestProperty("Range", "bytes=" + startIndex + "-" + endIndex);

                //[2.5]获取服务器返回的状态码
                int code = conn.getResponseCode();
                //[2.7]如果code == 200 说明请求成功    206代表请求部分数据成功
                if (code == 206) {
                    //[2.8]获取服务器返回的数据   是以流的形式返回的  由于把流转换成字符串是一个非常常见的操作  所以我抽出一个工具类(utils)
                    InputStream in = conn.getInputStream();
                    //[2.9]创建随机访问文件对象
                    RandomAccessFile raf = new RandomAccessFile(getFileName(path), "rw");
                    raf.seek(startIndex);
                    int len = -1;

                    int total = 0; //代表当前线程下载的大小
                    byte[] buffer = new byte[1024 * 1024];//1M
                    while ((len = in.read(buffer)) != -1) {
                        raf.write(buffer, 0, len);
                        //断点的逻辑 就是当前线程下载的位置 存起来   算出当前线程下载的位置
                        total += len;
                        //当前线程下载的位置
                        int currentThreadPosition = startIndex + total;
                        //把当前线程下载的位置 存起来  如果中断过 那么下次再下载的时候 就按照这个保存的位置继续下载
                        RandomAccessFile raff = new RandomAccessFile(getFileName(path) + threadId + ".txt", "rwd");
                        raff.write(String.valueOf(currentThreadPosition).getBytes());
                        raff.close();

                        //时时的更新进度条
                        pbs.get(threadId).setMax(pbMaxSize); //设置进度条的最大值
                        pbs.get(threadId).setProgress(pbLastposition + total);


                    }
                    in.close();
                    raf.close();//关闭流
                    System.out.println("线程id::" + threadId + "下载完毕了");

                    //枷锁
                    synchronized (DownLoadThread.class) {
                        runningThread--;
                        if (runningThread == 0) {
                            //说明所有的线程都执行完毕了  把.txt 文件删除
                            for (int i = 0; i < threadCount; i++) {
                                File deleteFile = new File(getFileName(path) + i + ".txt");
                                deleteFile.delete();
                            }


                        }

                    }


                }

            } catch (Exception e) {

            }


        }

    }


    //"http://169.254.87.250:8080/feiq.exe"  截取feiq.exe
    public static String getFileName(String path) {

        int start = path.lastIndexOf("/") + 1;
        String sdcardPath = Environment.getExternalStorageDirectory().getPath();
        String subPath = sdcardPath + "/" + path.substring(start);
        return subPath;
    }

}
