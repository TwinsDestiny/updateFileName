/**
 * 项目名称:修改文件名
 * 文件说明: 服务层
 * 创建者: chenh
 * 创建日期: 2016-7-1
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
	 * 获取所有文件
	 */
	public HashMap getFileMap() {
		return getAllFileStr();
	}

	/**
	 * 获取当前文件夹所有文件
	 */
	private HashMap getAllFileStr(){
		HashMap result = new HashMap();
		String filePath = System.getProperty("java.class.path");
		URL url = UpdateFileName.class.getProtectionDomain().getCodeSource().getLocation();
		try {
		    filePath = URLDecoder.decode(url.getPath(), "utf-8");// 转化为utf-8编码，支持中文
		} catch (Exception e) {
		    e.printStackTrace();
		}
		if (filePath.endsWith(".jar")) {// 可执行jar包运行的结果里包含".jar"
		    // 获取jar包所在目录
		    filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		}

		File file = new File(filePath);
		filePath = file.getAbsolutePath();//得到windows下的正确路径
		System.out.println("jar包所在目录："+filePath);
		List list = this.traverseFolder2(filePath);
		result.put("FILELIST", list);
		result.put("JARPATH", filePath);
		return result;
	}
	
    
    /**
     * 刷出文件路径
     * @param path
     */
	public List traverseFolder2(String path) {
        File file = new File(path);
        List list = new ArrayList();
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return list;
            } else {
                for (File file2 : files) {
                    if (!file2.isDirectory()) {
                    	System.out.println("文件:" + file2.getAbsolutePath());
                    	list.add(file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        return list;
    }
	
	/*
	 * 更新文件名
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
				System.out.println("修改成功!");
			} else {
				System.out.println("修改失败");
			}
		}
	}
}
