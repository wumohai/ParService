package com.demo.Content;

import java.util.HashMap;

import com.demo.File.FileType;
import com.demo.File.ReadFile;
import com.demo.Log.Log;

public class Document {


	/*
	 * 获取文档
	 * 
	 * 输入：cmdString 为客户端传来的命令
	 * 		mp 为读取的cmdFilenameMap.txt
	 * 返回：RetContentBean 返回给客户端
	 */
	public RetContentBean getDocument(String cmdString,
			HashMap<String, FileType> mp) {

		RetContentBean retContentBean = new RetContentBean();
		String fileTypeString = null;
		FileType fileType;
		fileType = mp.get(cmdString);
		byte[] bytes = null;
		String filePath = null;
		
		fileTypeString = fileType.fileType;
		
		if (!fileTypeString.equalsIgnoreCase("document")) {
			Log.errlog("document fileType error " + Log.getLineInfo());
			return null;
		}
		filePath = Path.getFilePath(fileType);
		if (filePath == null) {
			Log.errlog("get document Filepath error " + Log.getLineInfo());
			return null;
		}
		bytes = ReadFile.ReadFileByBytes(filePath);
		if (bytes == null) {
			Log.errlog("read document error " + Log.getLineInfo());
			return null;
		}
		
		retContentBean.setRetbyte(bytes);
		return retContentBean;
		
	}
	public static void main(String[] args) {
//		HashMap<String, FileType>mpHashMap = new HashMap<String, FileType>();
//		RetContentBean retContentBean = new RetContentBean();
//		FileType fileType = new FileType();
//		fileType.fileName = "Java中的WebService.pptx";
//		fileType.fileType = "document";
//		mpHashMap.put("javaWebService", fileType);
//		Document document = new Document();
//		 retContentBean = document.getDocument("javaWebService", mpHashMap);
//		 if (retContentBean.getRetbyte() != null) {
//			System.out.println("succ");
//		}
		
		
	}

}
