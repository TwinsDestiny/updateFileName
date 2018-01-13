/**
 * ��Ŀ����:�޸��ļ���
 * �ļ�˵��: �����
 * ������: chenh
 * ��������: 2016-7-1
 */
package com.gin.service;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdateFileName {
	
	/**
	 * ��ȡ�����ļ�
	 */
	public HashMap getFileMap() {
		return getAllFileStr();
	}

	/**
	 * ��ȡ��ǰ�ļ��������ļ�
	 */
	private HashMap getAllFileStr(){
		HashMap result = new HashMap();
		String filePath = System.getProperty("java.class.path");
		URL url = UpdateFileName.class.getProtectionDomain().getCodeSource().getLocation();
		try {
		    filePath = URLDecoder.decode(url.getPath(), "utf-8");// ת��Ϊutf-8���룬֧������
		} catch (Exception e) {
		    e.printStackTrace();
		}
		if (filePath.endsWith(".jar")) {// ��ִ��jar�����еĽ�������".jar"
		    // ��ȡjar������Ŀ¼
		    filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		}

		File file = new File(filePath);
		filePath = file.getAbsolutePath();//�õ�windows�µ���ȷ·��
		System.out.println("jar������Ŀ¼��"+filePath);
		List list = this.traverseFolder2(filePath);
		result.put("FILELIST", list);
		result.put("JARPATH", filePath);
		return result;
	}
	
    
    /**
     * ˢ���ļ�·��
     * @param path
     */
	public List traverseFolder2(String path) {
        File file = new File(path);
        List list = new ArrayList();
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("�ļ����ǿյ�!");
                return list;
            } else {
                for (File file2 : files) {
                    if (!file2.isDirectory()) {
                    	System.out.println("�ļ�:" + file2.getAbsolutePath());
                    	list.add(file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("�ļ�������!");
        }
        return list;
    }
	
	/*
	 * �����ļ���
	 */
	public void updateFileName(String name1, String name2, List list){
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			String fileName = list.get(i).toString();
			if(fileName.indexOf(name1) != -1){
				list1.add(fileName);
			}
			if(fileName.indexOf(name2) != -1){
				list2.add(fileName);
			}
		}
		for (int i = 0; i < list1.size(); i++) {
			String filename1 = list1.get(i).toString();
			String fileNameFirst=filename1.substring(0,filename1.lastIndexOf("."));
			String filename2 = list2.get(i).toString();
			String fileNameLast = filename2.substring(filename2.lastIndexOf("."));

			File f = new File(filename2);
			File mm = new File(fileNameFirst + fileNameLast);
			if (f.renameTo(mm)) {
				System.out.println("�޸ĳɹ�!");
			} else {
				System.out.println("�޸�ʧ��");
			}
		}
	}
}
