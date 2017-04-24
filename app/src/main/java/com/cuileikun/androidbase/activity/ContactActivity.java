package com.cuileikun.androidbase.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cuileikun.androidbase.R;
import com.cuileikun.androidbase.bean.User;
import com.qk.applibrary.activity.QkActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * 作者：popular cui
 * 时间：2017/4/19 14:50
 * 功能:联系人界面
 */
public class ContactActivity extends QkActivity {
    private ArrayList<User> datas;
    private ListView lv;

    @Override
    public void initViews() {

    }

    /*
     * 1. 访问assets目录中的my_user.db
		1. 获取assertManager:Context.getAsserts();
		2. InputStream is = open("my_user.db");
		3. 拷贝db
		4. /data/data/包名/databases/my_user.db
		5. SQLitedatabase db = Context.openOrCreateDatabase("my_user.db");
	   2. 将db中的数据保存在集合中
		1. Cursor cursor = db.rawQuery(args);
		2. 遍历Cursor获取
	 */
    @Override
    public void initData() {
        super.initData();
        //拷贝数据库到指定路径
        copyDB();
        datas = readDB();

        //初始化控件
        lv = (ListView) findViewById(R.id.lv);
        //给ListView设置点击条目事件监听
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 根据position获取数据
//				Object item = lv.getAdapter().getItem(position);
                User user = datas.get(position);
                //打电话
                callPhone(user.getPhone());

            }
        });
        //设置Adapter
        lv.setAdapter(new MyAdapter());
    }

    //完成拨打电话功能
    protected void callPhone(String phone) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phone);
        intent.setData(data);
        startActivity(intent);

    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public User getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            if (convertView == null) {
                /*
				 * 参数1:上下文
				 * 参数2:布局资源id
				 * 参数3:要挂载的父控件 null即可
				 */
                view = View.inflate(ContactActivity.this, R.layout.list_item, null);

                View view2 = LayoutInflater.from(ContactActivity.this).inflate(R.layout.list_item, null);

                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View view3 = inflater.inflate(R.layout.list_item, null);

            } else {
                view = convertView;
            }
            User user = getItem(position);
            //从view身上去查找子控件
            ImageView iv = (ImageView) view.findViewById(R.id.iv);
            switch (position % 10) {
                case 0:
                    iv.setImageResource(R.drawable.iv0);
                    break;
                case 1:
                    iv.setImageResource(R.drawable.iv1);
                    break;
                case 2:
                    iv.setImageResource(R.drawable.iv2);
                    break;
                case 3:
                    iv.setImageResource(R.drawable.iv3);
                    break;
                case 4:
                    iv.setImageResource(R.drawable.iv4);
                    break;
                case 5:
                    iv.setImageResource(R.drawable.iv5);
                    break;
                case 6:
                    iv.setImageResource(R.drawable.iv6);
                    break;
                case 7:
                    iv.setImageResource(R.drawable.iv7);
                    break;
                case 8:
                    iv.setImageResource(R.drawable.iv8);
                    break;
                case 9:
                    iv.setImageResource(R.drawable.iv9);
                    break;
                default:
                    break;
            }

            TextView tv_age = (TextView) view.findViewById(R.id.tv_age);
//			tv_age.setText(user.getAge());
            //如果是整型一定转换为字符串,不然就报资源找不到异常
            tv_age.setText(user.getAge() + "");
            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_name.setText(user.getName());
            TextView tv_phone = (TextView) view.findViewById(R.id.tv_phone);
            tv_phone.setText(user.getPhone());
            return view;
        }

    }

    //从数据库中读取数据
    private ArrayList<User> readDB() {
        ArrayList<User> users = new ArrayList<User>();
        //获取SQLiteDatabase ///data/data/包名/databases/my_user.db
        SQLiteDatabase database = openOrCreateDatabase("my_user.db", MODE_PRIVATE, null);
        Cursor cursor = database.query("t_user", new String[]{"c_name", "c_age", "c_phone"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            users.add(new User(cursor.getString(0), cursor.getInt(1), cursor.getString(2)));
        }
        cursor.close();
        database.close();
        return users;
    }

    private void copyDB() {
        AssetManager assetManager = getAssets();
        try {
            InputStream is = assetManager.open("my_user.db");
            File dirPath = new File("/data/data/com.itheima.contacts/databases");
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
            File file = new File(dirPath, "my_user.db");
            if (file.exists()) {
                return;
            }
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[1024 * 16];
            int len = -1;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_contact;
    }
}
