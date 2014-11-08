package com.demo.Analysis;

import java.util.HashMap;

import javax.jws.WebService;

import com.demo.File.FileType;
import com.demo.File.ReadFile;
import com.demo.Log.Log;

@WebService(endpointInterface = "com.demo.Analysis.AnalysisCommandInter", serviceName = "AnalysisCommandImp")
public class AnalysisCommandImp implements AnalysisCommandInter {
	private HashMap<String, FileType> fileTypeMP;
	private HashMap<String, String> cmdMP;

	public AnalysisCommandImp() {
		super();
		fileTypeMP = new HashMap<String, FileType>();
		cmdMP = new HashMap<String, String>();
		new ReadFile();

		/*
		 * 读取系统的命令对应的文件信息
		 */
		ReadFile.ReadFileTypeToMap(fileTypeMP, "resources/cmdFilenameMap.txt");
		if (fileTypeMP.isEmpty())
			Log.errlog("get fileTypeMp error " + Log.getLineInfo());

		/*
		 * 读取用户选择命令对应的系统命令
		 */
		ReadFile.ReadToMap(cmdMP, "resources/cmdMap.txt");
		if (cmdMP.isEmpty())
			Log.errlog("get cmdMp error " + Log.getLineInfo());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.Analysis.AnalysisCommandInter#getFileType(java.lang.String)
	 * 根据系统命令，找出对应的文件信息
	 */
	public FileType getFileType(String cmdString) {
		FileType retFileType = null;
		retFileType = fileTypeMP.get(cmdString);
		if (retFileType == null) {
			Log.errlog(cmdString + " 系统命令不存在 " + Log.getLineInfo());
		}
		return retFileType;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.Analysis.AnalysisCommandInter#fixCommand(java.lang.String)
	 * 根据用户选择，返回其选择对应的系统命令
	 */
	public String fixCommand(String cmd) {
		String retString = null;
		int startIndex, endIndex;
		if (cmd == null) {
			Log.errlog("cmd is null " + Log.getLineInfo());
			return null;
		}
		cmd = cmd.toLowerCase();
		if (cmd.startsWith("image") || cmd.startsWith("document")
				|| cmd.startsWith("component")) {
			startIndex = cmd.indexOf("(");
			endIndex = cmd.indexOf(")");
			if (startIndex == -1 || endIndex == -1) {
				Log.errlog(cmd + " 命令格式错误 " + Log.getLineInfo());
				return null;
			}
			cmd = cmd.substring(startIndex + 1, endIndex).trim();
			//System.out.println(cmd);
		}

		retString = cmdMP.get(cmd);
		System.out.println(cmd);
		if (retString == null) {
			Log.errlog(cmd + " 命令不存在 " + Log.getLineInfo());
		}
		return retString;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.demo.Analysis.AnalysisCommandInter#getFilePath(com.demo.File.FileType
	 * 根据文件信息，获取到文件所在路径
	 */
	public String getFilePath(FileType fileType) {
		// TODO Auto-generated method stub
		if (fileType == null || fileType.fileName == null
				|| fileType.fileType == null) {
			Log.errlog("get filepath error " + Log.getLineInfo());
			return null;
		}

		String filePathString = fileType.fileType + "/" + fileType.fileName;

		return filePathString;
	}
}
