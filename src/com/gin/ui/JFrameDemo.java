/**
 * ��Ŀ����:�޸��ļ���
 * �ļ�˵��: UI��
 * ������: chenh
 * ��������: 2016-7-1
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

	//�޸��ļ���service
	UpdateFileName up = new UpdateFileName();
	
	public JFrameDemo() {
		
		HashMap file = up.getFileMap();
		final List fileList = (List)file.get("FILELIST");
		String fileStr = file.get("JARPATH").toString()+"\n";
		for (int i = 0; i < fileList.size(); i++) {
			fileStr += fileList.get(i).toString()+"\n";
		}
		// ���ñ���
		setTitle("�޸��ļ���");
		// ���ùرմ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ô��ڴ�С
		setSize(487, 580);
		// �������û��ı䴰�ڴ�С
		setResizable(false);
		// ����
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = screen.width - this.getWidth() >> 1;
		int y = (screen.height - this.getHeight() >> 1) - 20;
		this.setLocation(x, y);
		// ����һ��JPanel��ʵ��
		final JPanelDemo panel = new JPanelDemo();
		// �����޲���
		panel.setLayout(null);
		// ���Panel
		setContentPane(panel);
		
		/*******************����********************/
		JLabel label1 = new JLabel("ԭ�ļ���׺��");
		JLabel label2 = new JLabel("���ļ���׺��");
		final JTextField textField1 = new JTextField();
		final JTextField textField2 = new JTextField();
		final JTextArea textArea1 = new JTextArea();
		Font font1 = new Font("����",Font.PLAIN , 14); 
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
		textArea1.setLineWrap(true);        //�����Զ����й��� 
		JScrollPane scrollPane = new JScrollPane(textArea1);    //��������������Ҫָ�����λ��
		//�ֱ�����ˮƽ�ʹ�ֱ���������ǳ���   
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
		
		/***************�����ļ���**********************/
		// ����JButtonʵ��
		JButton buttonNext = new JButton("�����ļ���");
		// ���ð�ťλ��
		buttonNext.setBounds(190, 500, 100, 30);
		// ��JButtonʵ����ӵ�JPanel��
		panel.add(buttonNext);
		// ��Ӱ�ť������
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1 = textField1.getText();
				String str2 = textField2.getText();
				up.updateFileName(str1, str2, fileList);
				textArea1.append("�������");
			}
		});
		/*******************************************/
		
		
		setVisible(true);
	}

}