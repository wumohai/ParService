package com.demo.Menu;

import javax.jws.WebService;

@WebService
public interface MenuInter {

	public String GetMenu();
	public String Analysis(String cmd);
}
