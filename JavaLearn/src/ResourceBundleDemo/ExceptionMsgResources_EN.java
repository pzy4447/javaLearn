package ResourceBundleDemo;

import java.util.ListResourceBundle;

/*
 * 类信息
 * @功能：错误消息的英文资源包
 * @版本：20150816
 */

public class ExceptionMsgResources_EN extends ListResourceBundle implements ExceptionMsgResourcesKeys{

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
	
	static final Object[][] contents = {
	    // Localize from here
	    {MSG_FILE_NOT_FOUND, "Cannot find file : {0}"},//原文这里有误
	    {MSG_CANT_OPEN_FILE, "Cannot open file : {0}"},//原文这里有误
	    // Localize to here
	  };
}
