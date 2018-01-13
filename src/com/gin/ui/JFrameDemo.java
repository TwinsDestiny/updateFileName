/**
 * 项目名称:修改文件名
 * 文件说明: UI层
 * 创建者: chenh
 * 创建日期: 2016-7-1
 */
package com.gin.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.gin.service.UpdateFileName;

public class JFrameDemo extends JFrame {

	//修改文件名service
	UpdateFileName up = new UpdateFileName();
	
	public JFrameDemo() {
		
		HashMap file = up.getFileMap();
		final List fileList = (List)file.get("FILELIST");
		String fileStr = file.get("JARPATH").toString()+"\n";
		for (int i = 0; i < fileList.size(); i++) {
			fileStr += fileList.get(i).toString()+"\n";
		}
		// 设置标题
		setTitle("修改文件名");
		// 设置关闭窗口
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口大小
		setSize(487, 580);
		// 不允许用户改变窗口大小
		setResizable(false);
		// 居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = screen.width - this.getWidth() >> 1;
		int y = (screen.height - this.getHeight() >> 1) - 20;
		this.setLocation(x, y);
		// 创建一个JPanel的实例
		final JPanelDemo panel = new JPanelDemo();
		// 设置无布局
		panel.setLayout(null);
		// 添加Panel
		setContentPane(panel);
		
		/*******************界面********************/
		JLabel label1 = new JLabel("原文件后缀：");
		JLabel label2 = new JLabel("改文件后缀：");
		final JTextField textField1 = new JTextField();
		final JTextField textField2 = new JTextField();
		final JTextArea textArea1 = new JTextArea();
		Font font1 = new Font("宋体",Font.PLAIN , 14); 
		label1.setFont(font1);
		label2.setFont(font1);
		label1.setBounds(10, 10, 100, 30);
		label2.setBounds(10, 50, 100, 30);
		textField1.setColumns(10);
		textField2.setColumns(10);
		textField1.setBounds(120, 10, 200, 30);
		textField2.setBounds(120, 50, 200, 30);
		textArea1.setBounds(10, 90, 460, 400);
		textArea1.setText(fileStr);
		textArea1.setLineWrap(true);        //激活自动换行功能 
		JScrollPane scrollPane = new JScrollPane(textArea1);    //创建滚动条，需要指定添加位置
		//分别设置水平和垂直滚动条总是出现   
		scrollPane.setHorizontalScrollBarPolicy(   
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);   
		scrollPane.setVerticalScrollBarPolicy(   
		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		scrollPane.setBounds(10, 90, 460, 400);
		panel.add(label1);
		panel.add(label2);
		panel.add(textField1);
		panel.add(textField2);
		panel.add(scrollPane);
		/*******************************************/
		
		/***************更新文件名**********************/
		// 创建JButton实例
		JButton buttonNext = new JButton("更新文件名");
		// 设置按钮位置
		buttonNext.setBounds(190, 500, 100, 30);
		// 将JButton实例添加到JPanel中
		panel.add(buttonNext);
		// 添加按钮监听器
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1 = textField1.getText();
				String str2 = textField2.getText();
				up.updateFileName(str1, str2, fileList);
				textArea1.append("更新完成");
			}
		});
		/*******************************************/
		
		
		setVisible(true);
	}

}