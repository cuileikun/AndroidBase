package com.cuileikun.androidbase.utils;


import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.cuileikun.androidbase.bean.Contacts;

import java.util.ArrayList;
import java.util.List;

//读取联系人的工具类 
public class ReadContactUtils{

	//读取联系人的工具类
	public static List<Contacts> readContact(Context context){
		
		//[0]创建集合 用于封装 联系人信息 
		List<Contacts> contactLists = new ArrayList<Contacts>();

		//[1]由于联系人的数据库 系统也已经通过内容提供者暴露出来 所以我们可以直接通过内容解析者去操作联系人数据库
		
		//[2]获取内容解析者 去查询 raw_contacts 表   查询这个表的contact_id列 
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		Uri dataUri = Uri.parse("content://com.android.contacts/data");
		Cursor cursor = context.getContentResolver().query(uri, new String[]{"contact_id"}, null, null, null);
		while(cursor.moveToNext()){
			String contact_id = cursor.getString(0);
			Contacts  contact = new Contacts();
			contact.setId(contact_id);
			
			if (contact_id!=null) {
			
			System.out.println("contact_id:"+contact_id);
			//[3]根据我们查询出来的 contact_id 去查询data表     mimetype_id  data1列 
			//☆☆☆☆☆这里查询的实际上查询的是view_data的视图   这里没有  mimetype_id  所以我们直接查询mimetype列 
			Cursor dataCursor = context.getContentResolver().query(dataUri, new String[]{"mimetype","data1"}, "raw_contact_id=?", new String[]{contact_id}, null);
			while(dataCursor.moveToNext()){
				String mimetype = dataCursor.getString(0);
				String data1 = dataCursor.getString(1);
				System.out.println("data1:~~~"+data1+"----"+mimetype);
				
				//[4]通过mimetype 列区分数据类型 
				if ("vnd.android.cursor.item/email_v2".equals(mimetype)) {
					System.out.println("邮箱:"+data1);
					contact.setEmail(data1);
					
				}else if ("vnd.android.cursor.item/phone_v2".equals(mimetype)) {
					System.out.println("电话号码:"+data1);
					contact.setPhone(data1);
				}else if("vnd.android.cursor.item/name".equals(mimetype)){
					contact.setName(data1);
			 		System.out.println("姓名:"+data1);
				}
				
				
			}
			//把javabean对象加入到 集合中 
			contactLists.add(contact);
			}
			
		}
		
		
		return contactLists;
	}
	
	
}
