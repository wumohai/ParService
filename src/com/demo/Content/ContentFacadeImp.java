package com.demo.Content;

import java.util.HashMap;

import javax.jws.WebService;

import com.demo.Analysis.AnalysisCommandImp;
import com.demo.Analysis.AnalysisCommandInter;
import com.demo.File.FileType;
import com.demo.File.ReadFile;
import com.demo.Log.Log;

@WebService(endpointInterface = "com.demo.Content.ContentFacadeInter", serviceName = "ContentFacadeImp")
public class ContentFacadeImp implements ContentFacadeInter {
	private HashMap<String, FileType> mp;
	private Component compont;// 构件服务类
	private Image image;
	private Help help;
	private Document document;
	private Apla apla;

	public ContentFacadeImp() {

		mp = new HashMap<String, FileType>();
		compont = new Component();
		image = new Image();
		help = new Help();
		document = new Document();
		apla = new Apla();

		// 根据命令读取命令对应需要读取的文件名，以及命令所属类型
		String fileName = "resources/cmdFilenameMap.txt";
		ReadFile.ReadFileTypeToMap(mp, fileName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.demo.Content.ContentFacadeInter#getContent(java.lang.String)
	 * 获取课程内容的总路口，根据或许内容的命令，选择相应的服务，返回相应的服务
	 */
	@Override
	public RetContentBean getContent(String cmdString) {

		RetContentBean retContentBean = new RetContentBean();
		AnalysisCommandInter analysisCommand = new AnalysisCommandImp();
		// String filePath = "";

		/*
		 * 根据命令。读取文件的描述信息存到FileType中
		 */
		FileType fileType = new FileType();
		fileType = analysisCommand.getFileType(cmdString);
		if (fileType == null) {
			Log.errlog("get fileType error " + Log.getLineInfo());
			return null;
		}
		// filePath = fileType.fileType + "/" + fileType.fileName;

		if (fileType.fileType.equalsIgnoreCase("component")) {
			/*
			 * 属于构件
			 */
			retContentBean = compont.getComponent(cmdString, mp);
			if (retContentBean == null) {
				Log.errlog("get component error " + Log.getLineInfo());
				return retContentBean;
			}

		}// end if (fileType.fileType.equalsIgnoreCase("component"))
		else if (fileType.fileType.equalsIgnoreCase("image")) {
			/*
			 * 属于图片
			 */
			retContentBean = image.getImage(cmdString, mp);
			if (retContentBean == null) {
				Log.errlog("get image error " + Log.getLineInfo());
				return retContentBean;
			}

		}// end if (fileType.fileType.equalsIgnoreCase("image"))
		else if (fileType.fileType.equalsIgnoreCase("help")) {
			/*
			 * 属于help帮助类命令
			 */
			retContentBean = help.getHelp(cmdString, mp);
			if (retContentBean == null) {
				Log.errlog("get help error " + Log.getLineInfo());
			}
			return retContentBean;

		} else if (fileType.fileType.equalsIgnoreCase("document")) {
			/*
			 * 属于请求文档类
			 */
			retContentBean = document.getDocument(cmdString, mp);
			if (retContentBean == null) {
				Log.errlog("get document error " + Log.getLineInfo());
			}
			return retContentBean;
		}
		else if (fileType.fileType.equalsIgnoreCase("apla")) {
			/*
			 * 表示请求apla内容。
			 */
			retContentBean = apla.getComponent(cmdString, mp);
			if(retContentBean == null)
			{
				Log.errlog("get apla document error " + Log.getLineInfo());
			}
			return retContentBean;
		}
		return retContentBean;

	}

	public static void main(String[] args) {
		// ContentFacadeImp contentFacadeImp = new ContentFacadeImp();
		// System.out.println(contentFacadeImp.mp.get("arraylist"));
	}

}
