package ResourceBundleDemo;

import java.text.MessageFormat;
import java.util.ResourceBundle;
/*
 * 类信息
 * @功能：读取资源包并进行本地化，最终生成正确的错误消息
 * @版本：20150816
 */
public class MessageUtil {
	
	//private static ResourceBundle myResources = ResourceBundle.getBundle("ResourceBundleDemo.ExceptionMsgResources_EN");
	private static ResourceBundle myResources = ResourceBundle.getBundle("ResourceBundleDemo.ExceptionMsgResources_ZN");

	private static String getMessageString(String messageKey) {
		return myResources.getString(messageKey);
	}

	public static String formatMessage(String messageKey) {
		MessageFormat mf = new MessageFormat(getMessageString(messageKey));
		return mf.format(new Object[0]);
	}

	public static String formatMessage(String messageKey, Object arg0) {
		MessageFormat mf = new MessageFormat(getMessageString(messageKey));
		Object[] args = new Object[1];
		args[0] = arg0;
		return mf.format(args);
	}

	public static String formatMessage(String messageKey, Object arg0,
			Object arg1) {
		MessageFormat mf = new MessageFormat(getMessageString(messageKey));
		Object[] args = new Object[2];
		args[0] = arg0;
		args[1] = arg1;
		return mf.format(args);
	}
	// Include implementations of formatMessage() for as many arguments
	// as you need
}
