package com.demo.Analysis;

import javax.jws.WebService;

import com.demo.File.FileType;

@WebService
public interface AnalysisCommandInter {
	
	public FileType getFileType(String cmdString);
	public String fixCommand(String cmd);
	public String getFilePath(FileType fileType);

}
