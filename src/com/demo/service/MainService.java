package com.demo.service;

import javax.xml.ws.Endpoint;

import com.demo.Analysis.AnalysisCommandImp;
import com.demo.Analysis.AnalysisCommandInter;
import com.demo.Content.ContentFacadeImp;
import com.demo.Content.ContentFacadeInter;
import com.demo.Log.Log;
import com.demo.Menu.MenuImp;
import com.demo.Menu.MenuInter;

public class MainService {

	public static void main(String[] args) {


		String addrString = "http://127.0.0.1:9000/";
		
		/*
		 * 菜单类服务
		 */
		MenuInter menuInter = new MenuImp();
		Endpoint.publish(addrString + "MenuImp", menuInter);
		//Endpoint.publish( "http://127.0.0.1:8081/MenuImp", menuInter);
		System.out.println("MenuInter publish succ");
		Log.wlog("MenuInter publish succ");
		
		/*
		 * 命令解析类服务
		 */
		AnalysisCommandInter analysisCommandInter = new AnalysisCommandImp();
		Endpoint.publish(addrString + "AnalysisCommandImp", analysisCommandInter);
		System.out.println("AnalysisCommandInter publish succ");
		Log.wlog("AnalysisCommandInter publish succ");
		
		/*
		 * 获取内容服务总接口
		 */
		ContentFacadeInter contentFacadeInter = new ContentFacadeImp();
		Endpoint.publish(addrString + "ContentFacadeImp", contentFacadeInter);
		System.out.println("ContentFacadeImp publish succ");
		Log.wlog("ContentFacadeImp publish succ");
		
		
	}

}
