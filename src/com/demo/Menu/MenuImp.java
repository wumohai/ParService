package com.demo.Menu;

import java.util.HashMap;

import javax.jws.WebService;

import com.demo.File.ReadFile;
import com.demo.Log.Log;

@WebService(endpointInterface="com.demo.Menu.MenuInter", 
			serviceName = "MenuImp")
public class MenuImp implements MenuInter {

	
	HashMap<String, String> mp = new HashMap<String, String>();
	public MenuImp() {
		super();
		ReadFile.ReadToMap(mp, "resources/cmdMap.txt");

	}
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see com.demo.inter.MenuInter#GetMenu()
	 * 获取菜单界面
	 */
	public String GetMenu() {
		String retString = ReadFile.ReadProfile("resources/Menu.txt");
		if (retString == null) {
			Log.errlog("ReadProfile error " + Log.getLineInfo());
		}
		return retString;
	}
	@Override
	/*
	 * (non-Javadoc)
	 * @see com.demo.inter.MenuInter#Analysis(java.lang.String)
	 * 解析用户端命令，客户端端命令对应的命令
	 */
	public String Analysis(String cmd) {
		String retString = "";
		retString = mp.get(cmd);
		if (retString == null)
		{
			retString = "命令不存在";
			Log.errlog(retString + " " + Log.getLineInfo());
		}
		return retString;
	}
	

}
