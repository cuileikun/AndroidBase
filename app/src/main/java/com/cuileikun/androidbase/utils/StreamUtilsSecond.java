package com.cuileikun.androidbase.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class StreamUtilsSecond {


    public static String  readStream(InputStream in) throws IOException{


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = -1;
        byte buffer[] = new byte[1024];
        while((len=in.read(buffer))!=-1){
            baos.write(buffer, 0, len);
        }

        String content = new String(baos.toByteArray(),"gbk");
        in.close();
        return content;
    }

}
