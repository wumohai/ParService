package com.demo.Content;

public class RetContentBean {
	private String retString;
	private byte[] retbyte;
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public RetContentBean(String retString, byte[] retbyte) {
		super();
		this.retString = retString;
		this.retbyte = retbyte;
	}

	public RetContentBean() {
	}

	public String getRetString() {
		return retString;
	}

	public void setRetString(String retString) {
		this.retString = retString;
	}

	public byte[] getRetbyte() {
		return retbyte;
	}

	public void setRetbyte(byte[] retbyte) {
		this.retbyte = retbyte;
	}

}
