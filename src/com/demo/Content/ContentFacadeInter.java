package com.demo.Content;

import javax.jws.WebService;

@WebService
public interface ContentFacadeInter {
	
//	public void getContent(String cmdString,String retString);
//	public void getContent(String cmdString,byte[] retbyte);
//	public String getComponent(String cmdString);
//	public String getImage(String cmdString);
	public RetContentBean getContent(String cmdString);
	
}
