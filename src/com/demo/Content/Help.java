package com.demo.Content;

import java.util.HashMap;

import com.demo.File.FileType;
import com.demo.File.ReadFile;
import com.demo.Log.Log;

public class Help {

	/*
	 * 获取帮助文档
	 * 
	 * 输入：cmdString 为客户端传来的命令
	 * 		mp 为读取的cmdFilenameMap.txt
	 * 返回：RetContentBean 返回给客户端
	 */
	public RetContentBean getHelp(String cmdString, HashMap<String, FileType> mp) {
		RetContentBean retContentBean = new RetContentBean();
		String filePathString;
		FileType fileType = null;
		String retString = null;

		fileType = mp.get(cmdString);
		if (fileType == null) {
			Log.errlog("Help get fileType error " + Log.getLineInfo());
			return null;
		}

		filePathString = fileType.fileType + "/" + fileType.fileName;

		retString = ReadFile.Readfile(filePathString);
		if (retString == null) {
			Log.errlog("Read Help error " + Log.getLineInfo());
			return null;
		}
		
		retContentBean.setRetString(retString);

		return retContentBean;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
