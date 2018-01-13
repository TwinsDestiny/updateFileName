/**
 * 项目名称:修改文件名
 * 文件说明: UI层
 * 创建者: chenh
 * 创建日期: 2016-7-1
 */
package com.gin.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelDemo extends JPanel {
	
	/**
	 * 绘制字符串
	 */
	private void drawText(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("宋体",Font.PLAIN , 14));
		g.drawString("aaaa", 0, 14);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		this.drawText(g);
		this.repaint();
	}

}
