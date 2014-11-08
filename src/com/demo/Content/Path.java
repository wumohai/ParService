package com.demo.Content;

import com.demo.File.FileType;

public class Path {
	public static String getFilePath(FileType fileType) {
		if (fileType == null) {
			return null;
		}
		return fileType.fileType +  "/" + fileType.fileName;
	}
}
