package com.cuileikun.androidbase.utils;

import android.util.Xml;

import com.cuileikun.androidbase.bean.News;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ParserXml {

	//解析xml的业务方法
	public static List<News> parserNewXml(InputStream in) throws Exception{
		//[0]定义集合
		List<News> newsLists = null;
		News news = null;
		//[1]先获取到xmlpullparser对象
		XmlPullParser parser = Xml.newPullParser();
		//[2]设置parser解析器要解析的内容
		parser.setInput(in, "utf-8");
		//[3]基于事件解析 所以要获取事件类型
		int type = parser.getEventType();
		//[4][不停的向下解析]
		while(type!=XmlPullParser.END_DOCUMENT){

			//[5]具体判断一下解析到了哪个标签
			switch (type) {
				case XmlPullParser.START_TAG: //说明解析的是开始标签
					//[6]具体判断一下解析到了哪个开始标签
					if ("channel".equals(parser.getName())) {
						//创建集合对象
						newsLists = new ArrayList<News>();
					}else if ("item".equals(parser.getName())) {
						//创建javabean对象
						news = new News();

					}else if ("title".equals(parser.getName())) {
						//把对应标签的内容取出来 放到javabean对象
						news.setTitle(parser.nextText());
					}else if ("description".equals(parser.getName())) {
						//把对应标签的内容取出来 放到javabean对象
						news.setDescription(parser.nextText());

					}else if ("image".equals(parser.getName())) {
						//把对应标签的内容取出来 放到javabean对象
						news.setImage(parser.nextText());

					}else if ("type".equals(parser.getName())) {
						//把对应标签的内容取出来 放到javabean对象
						news.setType(parser.nextText());

					}else if ("comment".equals(parser.getName())) {
						//把对应标签的内容取出来 放到javabean对象
						news.setComment(parser.nextText());

					}

					break;

				case XmlPullParser.END_TAG://解析结束的标签
					if ("item".equals(parser.getName())) {

						//把news对象加入到集合中
						newsLists.add(news);
					}

					break;
			}



			//不停向下解析
			type = parser.next();
		}

		return newsLists;


	}

}
