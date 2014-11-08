package com.demo.Content;

import java.util.HashMap;

import com.demo.File.FileType;
import com.demo.File.ReadFile;
import com.demo.Log.Log;

public class Image {

	/*
	 * 获取图片
	 * 
	 * 输入：cmdString 为客户端传来的命令
	 * 		mp 为读取的cmdFilenameMap.txt
	 * 返回：RetContentBean 返回给客户端
	 */
	public RetContentBean getImage(String cmdString,
			HashMap<String, FileType> mp) {

		RetContentBean retContentBean = new RetContentBean();
		String fileTypeString = null;
		FileType fileType;
		fileType = mp.get(cmdString);
		byte[] bytes = null;
		String filePath = null;
		
		fileTypeString = fileType.fileType;
		
		if (!fileTypeString.equalsIgnoreCase("image")) {
			Log.errlog("image fileType error " + Log.getLineInfo());
			return null;
		}
		filePath = Path.getFilePath(fileType);
		if (filePath == null) {
			Log.errlog("get Filepath error " + Log.getLineInfo());
			return null;
		}
		bytes = ReadFile.ReadFileByBytes(filePath);
		if (bytes == null) {
			Log.errlog("read image error " + Log.getLineInfo());
			return null;
		}
		
		retContentBean.setRetbyte(bytes);
		return retContentBean;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
