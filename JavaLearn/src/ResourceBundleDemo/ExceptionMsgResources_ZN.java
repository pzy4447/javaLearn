package ResourceBundleDemo;

import java.util.ListResourceBundle;

/*
 * 类信息
 * @功能：错误消息的中文资源包
 * @版本：20150816
 */

public class ExceptionMsgResources_ZN extends ListResourceBundle implements ExceptionMsgResourcesKeys{

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
	    // Localize from here
	    {MSG_FILE_NOT_FOUND, "找不到文件 : {0}"},//原文这里有误
	    {MSG_CANT_OPEN_FILE, "打不开文件 : {0}"},//原文这里有误
	    // Localize to here
	  };
}
