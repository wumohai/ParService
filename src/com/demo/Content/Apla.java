package com.demo.Content;

import java.io.File;
import java.util.HashMap;

import com.demo.File.FileType;
import com.demo.File.ReadFile;
import com.demo.Log.Log;

public class Apla {
	/*
	 * 获取Apla文档
	 * 
	 * 输入：cmdString 为客户端传来的命令
	 * 		mp 为读取的cmdFilenameMap.txt
	 * 返回：RetContentBean 返回给客户端
	 */
//	public RetContentBean getDocument(String cmdString,
//			HashMap<String, FileType> mp) {
//
//		RetContentBean retContentBean = new RetContentBean();
//		String fileTypeString = null;
//		FileType fileType;
//		fileType = mp.get(cmdString);
//		byte[] bytes = null;
//		String filePath = null;
//		
//		fileTypeString = fileType.fileType;
//		
//		if (!fileTypeString.equalsIgnoreCase("apla")) {
//			Log.errlog("apla fileType error " + Log.getLineInfo());
//			return null;
//		}
//		filePath = Path.getFilePath(fileType);
//		if (filePath == null) {
//			Log.errlog("get apla Filepath error " + Log.getLineInfo());
//			return null;
//		}
//		bytes = ReadFile.ReadFileByBytes(filePath);
//		if (bytes == null) {
//			Log.errlog("read apla error " + Log.getLineInfo());
//			return null;
//		}
//		
//		retContentBean.setRetbyte(bytes);
//		return retContentBean;
//		
//	}
	/*
	 * 获取apla文档
	 * 输入：cmdString 为客户端传来的命令
	 * 		mp 为读取的cmdFilenameMap.txt
	 * 返回：RetContentBean 返回给客户端
	 */
	public RetContentBean getComponent(String cmdString,
			HashMap<String, FileType> mp) {
		
		RetContentBean retContentBean = new RetContentBean();
		String filePathString;
		FileType fileType = null;
		String retString = null;

		fileType = mp.get(cmdString);
		if (fileType == null) {
			Log.errlog("apla get fileType error " + Log.getLineInfo());
			return null;
		}

		
		filePathString = fileType.fileType + "/" + fileType.fileName;

	
		//retString = ReadFile.Readfile(filePathString);
		retString = ReadFile.readRTF(filePathString);
		if (retString == null) {
			Log.errlog("Read apla  error filename:" + filePathString + "  " + Log.getLineInfo());
			return null;
		}
		
		retContentBean.setRetString(retString);

		return retContentBean;

	}
	public static void main(String args[]) {
		Apla apla = new Apla();
		String cmdString = "Apla程序示例"; 
		HashMap<String, FileType> mp = new HashMap<String, FileType>();
		FileType fileType = new FileType();
		fileType.fileType = "apla";
		fileType.fileName = "Apla程序示例.rtf";
		mp.put(cmdString, fileType);
		RetContentBean retContentBean = new RetContentBean();
		retContentBean = apla.getComponent(cmdString, mp);
		if (retContentBean.getRetString() == null) {
			System.out.println("null");
		}
		else
			System.out.println(retContentBean.getRetString());
		
	}
}
