package com.cuileikun.androidbase.javaactivity.twentyone.day21_IO;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
 * String(byte[] bytes, String charsetName):ͨ��ָ�����ַ��������ֽ�����
 * byte[] getBytes(String charsetName):ʹ��ָ�����ַ����ϰ��ַ�������Ϊ�ֽ�����
 * 
 * ����:�ѿ��ö��ı�ɿ�������
 * String -- byte[]
 * 
 * ����:�ѿ������ı�ɿ��ö���
 * byte[] -- String
 * 
 * ��������սƬ(���籨���ӵ籨)
 * 
 * ���С����
 * 		�ַ�	��ֵ
 * 
 * Ҫ����һ�����֣�
 * 		�����������ϵط���
 * 
 * 		���Ͷˣ��� -- ��ֵ -- ������ -- ����ȥ
 * 		���նˣ����� -- ������ -- ʮ���� -- ��ֵ -- �ַ� -- ��
 * 
 * 		�����������ϵط���
 * 
 * ��������򵥣�ֻҪ�������ĸ�ʽ��һ�µġ�
 */
public class StringDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "���";

		// String -- byte[]
		byte[] bys = s.getBytes(); // [-60, -29, -70, -61]
		// byte[] bys = s.getBytes("GBK");// [-60, -29, -70, -61]
		// byte[] bys = s.getBytes("UTF-8");// [-28, -67, -96, -27, -91, -67]
		System.out.println(Arrays.toString(bys));

		// byte[] -- String
		String ss = new String(bys); // ���
		// String ss = new String(bys, "GBK"); // ���
		// String ss = new String(bys, "UTF-8"); // ???
		System.out.println(ss);
	}
}