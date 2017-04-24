package com.cuileikun.androidbase.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class StreamUtils {
//把inputStream 转换成Strng

    public static String readStream(InputStream in) throws IOException {


        //定义内存输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = -1;
        byte buffer[] = new byte[1024];
        while ((len = in.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }

        //创建String
        String content = new String(baos.toByteArray());
        in.close();
        return content;
    }

}
