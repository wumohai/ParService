package com.demo.Log;

import java.io.*;
import java.util.Date;

public class Log {

	@SuppressWarnings("deprecation")
	public static void errlog( String content) {
		String fileName;
		Date date = new Date();
		String dateString = date.toLocaleString().split(" ")[0];
		content = (new Date()).toLocaleString() + content + "\r\n";
		fileName = "Log/Error" + dateString;
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
 			
        	File file = new File(fileName);
        	OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file, true),"UTF-8");
			BufferedWriter writer=new BufferedWriter(write);   
			writer.write(content);
			writer.flush();
			writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	@SuppressWarnings("deprecation")
	public static void wlog( String content) {
		String fileName;
		Date date = new Date();
		String dateString = date.toLocaleString().split(" ")[0];
		System.out.println(dateString);
		content = (new Date()).toLocaleString() + content + "\r\n";
		fileName = "Log/Normal" + dateString;
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            File file = new File(fileName);
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8");
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static String getLineInfo()
    {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + ": Line " + ste.getLineNumber();
    }
	public static void main(String[] args) {
//		Date date = new Date();
//		String dateString = date.toLocaleString().split(" ")[0];
//		System.out.println(dateString);
//		wlog( "wumohai");
		//System.out.println(getLineInfo());
		//errlog("吴莫海");
	}

}
