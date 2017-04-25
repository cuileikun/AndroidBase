package com.cuileikun.androidbase.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.bean.News;
import com.cuileikun.androidbase.imageview.SmartImageView;
import com.cuileikun.androidbase.utils.ParserXml;
import com.qk.applibrary.activity.QkActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * 作者：popular cui
 * 时间：2017/4/24 17:19
 * 功能:6_新闻客户端
 */
public class NewsActivity extends QkActivity {
    private List<News> newsLists;
    private ListView lv;

    @Override
    public void initViews() {
        super.initViews();
        // [1]找到控件

        lv = (ListView) findViewById(R.id.lv);

        // [2]初始化 listview要展示的数据 注意必须先有数据 这里的数据我从服务器获取
        initDatas();
    }

    // 获取listview要展示的数据 去服务器获取
    private void initDatas() {

        // [2.1]去服务器取数据 是联网 的操作 所以要开一个子线程
        // 创建一个子线程
        new Thread() {

            public void run() {

                try {

                    String path = "http://169.254.87.250:8080/news.xml";
                    // [2.1]创建URL 对象指定我们要访问的 网址(路径)
                    URL url = new URL(path);
                    // [2.2]拿到httpurlconnection对象 用于发送或者接收数据
                    HttpURLConnection conn = (HttpURLConnection) url
                            .openConnection();
                    // [2.3]设置发送get请求
                    conn.setRequestMethod("GET");// get要求大写 默认就是get请求
                    // [2.4]设置请求超时时间
                    conn.setConnectTimeout(5000);
                    // [2.5]获取服务器返回的状态码
                    int code = conn.getResponseCode();
                    // [2.7]如果code == 200 说明请求成功
                    if (code == 200) {
                        // [2.8]获取服务器返回的数据 是以流的形式返回的 由于把流转换成字符串是一个非常常见的操作
                        // 所以我抽出一个工具类(utils)
                        InputStream in = conn.getInputStream();

                        // 3 解析xml进行封装数据 单独抽出一个业务方法

                        newsLists = ParserXml.parserNewXml(in);


                        //[3.1]展示数据
                        runOnUiThread(new Runnable() {
                            public void run() {
                                lv.setAdapter(new MyAdapter());
                            }
                        });


                    }

                } catch (Exception e) {

                }

            }

            ;
        }.start();

    }

    //定义数据适配器
    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return newsLists.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view;
            if (convertView == null) {
                // 历史缓存对象为空 创建新的view对象
                view = View.inflate(getApplicationContext(), R.layout.item,
                        null);
            } else {
                view = convertView;

            }
            // 找到布局里目的控件
            SmartImageView iv = (SmartImageView) view.findViewById(R.id.iv);
            TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
            TextView tv_desc = (TextView) view.findViewById(R.id.tv_desc);
            TextView tv_type = (TextView) view.findViewById(R.id.tv_type);


            //[1]展示图片的信息 也在集合里面存着
            String imageUrl = newsLists.get(position).getImage();
            iv.setImageUrl(imageUrl);


            // [2]显示真实的数据 真实的数据在哪里存着 就去哪里找
            tv_title.setText(newsLists.get(position).getTitle());
            tv_desc.setText(newsLists.get(position).getDescription());

            // 获取新闻的类型
            String typee = newsLists.get(position).getType();
            String comment = newsLists.get(position).getComment();
            int type = Integer.parseInt(typee);
            switch (type) {
                case 1: // 代表国内

                    tv_type.setText("国内:" + comment);
                    break;

                case 2: // 代表国外
                    tv_type.setText("国外");
                    break;

                case 3: // 代表国内
                    tv_type.setText("娱乐");
                    break;
            }

            return view;
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_news;
    }
}
