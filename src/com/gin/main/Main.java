/**
 * ��Ŀ����:�޸��ļ���
 * �ļ�˵��: ������
 * ������: chenh
 * ��������: 2016-7-1
 */
package com.gin.main;

import com.gin.ui.JFrameDemo;

public class Main extends Thread {

	/**
	 * ������
	 */
	public static void main(String[] args) {
		new Main("updateFileName").start(); }

	public Main(String name) {
		super(name);
	}

	@Override
	public void run() {
		new JFrameDemo();
	}

}
