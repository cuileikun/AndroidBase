package com.cuileikun.androidbase.javaactivity.fourteen.day14_Date_DateFormat.aaa;

/*
 * 工具类的测试
 */

import java.text.ParseException;
import java.util.Date;

public class DateUtilDemo {
    public static void main(String[] args) throws ParseException {
        Date d = new Date();
        // yyyy-MM-dd HH:mm:ss
        String s = DateUtil.dateToString(d, "yyyy年MM月dd日 HH时:mm分:ss秒");
        System.out.println(s);

        String s2 = DateUtil.dateToString(d, "yyyy年MM月dd日");
        System.out.println(s2);

        String s3 = DateUtil.dateToString(d, "HH:mm:ss");
        System.out.println(s3);
        String s4 = DateUtil.dateToString(d, "yyyy年MM月dd日 HH");
        System.out.println(s4);

        String str = "2014-10-14";
        Date dd = null;
        try {
            dd = DateUtil.stringToDate(str, "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dd);
    }
}
