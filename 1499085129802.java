package cn.itcast_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * UDPЭ��������ݣ�
 * A:�������ն�Socket����
 * B:����һ�����ݰ�(��������)
 * C:����Socket����Ľ��շ�����������
 * D:�������ݰ�������ʾ�ڿ���̨
 * E:�ͷ���Դ
 */
public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		// �������ն�Socket����
		// DatagramSocket(int port)
		DatagramSocket ds = new DatagramSocket(10086);

		// ����һ�����ݰ�(��������)
		// DatagramPacket(byte[] buf, int length)
		byte[] bys = new byte[1024];
		int length = bys.length;
		DatagramPacket dp = new DatagramPacket(bys, length);

		// ����Socket����Ľ��շ�����������
		// public void receive(DatagramPacket p)
		ds.receive(dp); // ����ʽ

		// �������ݰ�������ʾ�ڿ���̨
		// ��ȡ�Է���ip
		// public InetAddress getAddress()
		InetAddress address = dp.getAddress();
		String ip = address.getHostAddress();
		// public byte[] getData():��ȡ���ݻ�����
		// public int getLength():��ȡ���ݵ�ʵ�ʳ���
		byte[] bys2 = dp.getData();
		int len = dp.getLength();
		String s = new String(bys2, 0, len);
		System.out.println(ip + "���ݵ�������:" + s);

		// �ͷ���Դ
		ds.close();
	}
}
