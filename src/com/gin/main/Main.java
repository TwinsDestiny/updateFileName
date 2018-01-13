/**
 * 项目名称:修改文件名
 * 文件说明: 主方法
 * 创建者: chenh
 * 创建日期: 2016-7-1
 */
package com.gin.main;

import com.gin.ui.JFrameDemo;

public class Main extends Thread {

	/**
	 * 主函数
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
