/**
 * ��Ŀ����:�޸��ļ���
 * �ļ�˵��: UI��
 * ������: chenh
 * ��������: 2016-7-1
 */
package com.gin.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelDemo extends JPanel {
	
	/**
	 * �����ַ���
	 */
	private void drawText(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("����",Font.PLAIN , 14));
		g.drawString("aaaa", 0, 14);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		this.drawText(g);
		this.repaint();
	}

}
