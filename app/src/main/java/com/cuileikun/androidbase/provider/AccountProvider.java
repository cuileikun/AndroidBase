package com.cuileikun.androidbase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.cuileikun.androidbase.db.MyOpenHeloer;

//定义内容提供者  注意 就要在清单文件里面配置一下
public class AccountProvider extends ContentProvider {

	//[1]定义一个uri路径的匹配器 
	 private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	private static final int QUERYSUCESS = 0; //变大小  ctrl+shift+X    + y变小写
	private static final int INSERTSUCESS = 1;
	private static final int DELETESUCESS = 2;
	private static final int UPDATESUCESS = 3;
	private MyOpenHeloer myOpenHeloer;


	 //[2]添加匹配规则 
	 static{
		 /**
		  * URL   http://www.baidu.com/tieba 
		  * 
		  * URI(你自己定义的一个路径)   content://com.itheima.provider/query
		  * 
		  * 张三 学霸  定义规则  A呀 D   
		  * 
		  */
		 sURIMatcher.addURI("com.itheima.provider", "query", QUERYSUCESS);
		 sURIMatcher.addURI("com.itheima.provider", "insert", INSERTSUCESS);
		 sURIMatcher.addURI("com.itheima.provider", "delete", DELETESUCESS);
		 sURIMatcher.addURI("com.itheima.provider", "update", UPDATESUCESS);
		 
		 
	 }
	 
	
	@Override
	public boolean onCreate() {
		//初始化myOpenHelper 实例 目的是为了获取 数据库的实例  
		
		myOpenHeloer = new MyOpenHeloer(getContext());
		
		return false;
	}

	//对数据库进行查询的操作
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		
		//[3]匹配路径  暴露query方法
		int code = sURIMatcher.match(uri);
		if (code == QUERYSUCESS ) {
			//说明路径匹配成功
			SQLiteDatabase db = myOpenHeloer.getReadableDatabase();  //获取db 的实例 就可以对数据库进行操作
			Cursor cursor = db.query("info", projection, selection, selectionArgs, null, null, sortOrder);
			
			//说明有人操作了 数据库   我就主动发一条消息  告诉系统说  数据库被人操作了 
			getContext().getContentResolver().notifyChange(uri, null);
			
			
			//注意 这个cursor 不能关闭
			return cursor;
			
		}else {
			//说明路径匹配失败 
			throw new IllegalArgumentException("哥们 路径不匹配 请检测路径");
			
		}
		
		
		
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		int code = sURIMatcher.match(uri);

		if (code == INSERTSUCESS) {
			
			//说明路径匹配成功   对数据库进行插入的操作 
			SQLiteDatabase db = myOpenHeloer.getReadableDatabase();
			long insert = db.insert("info", null, values);
			
			if (insert>0) {
				//发消息  说明数据库被人操作了 
				getContext().getContentResolver().notifyChange(uri, null);
			}
			
			//由于返回值类型 是Uri类型 所以我就准备一个uri类型 
			Uri uri2 = Uri.parse("com.itheima.insert/"+insert);
			return uri2;
			
		}else {
			//说明路径匹配失败 
			throw new IllegalArgumentException("姐们 路径不匹配 请检测路径");
			
		}
		
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int code = sURIMatcher.match(uri);
		
		if (code ==DELETESUCESS ) {
			//说明路径匹配成功  对数据库进行删除的操作 
			SQLiteDatabase db = myOpenHeloer.getReadableDatabase();
			//代表删除  的行数
			int delete = db.delete("info", selection, selectionArgs);
			if (delete>0) {
				//发消息  说明数据库被人操作了 
				getContext().getContentResolver().notifyChange(uri, null);
				
			}
			
			return delete;
		}else {
			//说明路径匹配失败 
			throw new IllegalArgumentException("爷们 路径不匹配 请检测路径");
			
		}
		
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		
		int code = sURIMatcher.match(uri);
		if (code == UPDATESUCESS) {
			//说明路径匹配成功 对数据库进行更新的操作 
			
			SQLiteDatabase db = myOpenHeloer.getReadableDatabase();
			//代表更新的行数
			int update = db.update("info", values, selection, selectionArgs);
			if (update>0) {
				//发消息  说明数据库被人操作了 
				getContext().getContentResolver().notifyChange(uri, null);
			}
			
			return update;
			
		}else {
			//说明路径匹配失败 
			throw new IllegalArgumentException("哥他们 路径不匹配 请检测路径");
			
		}
		
	}

}
