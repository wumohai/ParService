package com.demo.Content;

import java.util.HashMap;

import com.demo.File.FileType;
import com.demo.File.ReadFile;
import com.demo.Log.Log;

public class Component {

	

	@SuppressWarnings("unused")
	/*
	 * 获取构建
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
			Log.errlog("component get fileType error " + Log.getLineInfo());
			return null;
		}

		
		filePathString = fileType.fileType + "/" + fileType.fileName;

		if (filePathString == null) {
			Log.errlog("component get filePath error in "  + Log.getLineInfo());
			return null;
		}
		
		retString = ReadFile.Readfile(filePathString);
		if (retString == null) {
			Log.errlog("Read component error " + Log.getLineInfo());
			return null;
		}
		
		retContentBean.setRetString(retString);

		return retContentBean;

	}

	/*
	 * 测试compont类
	 */
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Component compont = new Component();
//		HashMap<String, String> mp = new HashMap<String, String>();
//		mp.put("arraylist", "strulib/arraylist.java");
//		String retString = null;
//		String cmd = "arraylist";
//		//retString = compont.getCompont(cmd, mp).getRetString();
//		if (retString == null)
//			
//			System.out.println(cmd + " 命令不存在");
//		System.out.println(retString);

	}

}
