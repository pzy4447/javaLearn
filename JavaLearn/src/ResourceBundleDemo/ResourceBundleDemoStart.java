package ResourceBundleDemo;

import java.io.File;
import java.io.FileNotFoundException;

/*
 * 工程信息
 * @源码地址： http://www.javaworld.com/article/2075897/testing-debugging/exceptional-practices--part-3.html
 * @功能：演示使用ResourceBundle构造错误消息以及本地化的过程
 * @结构：ResourceBundleDemoStart[起始点]，MessageUtil,ExceptionMsgResourcesKeys,ExceptionMsgResources_ZN,ExceptionMsgResources_EN
 * @版本：20150816
 */

/*
 * 类信息
 * @功能：项目起始点
 * @版本：20150816
 */

public class ResourceBundleDemoStart implements ExceptionMsgResourcesKeys {

	public void run() {
		try {
			loadResource();
		} catch (ResourceLoadException e) {
			// TODO Auto-generated catch block
			 
			System.out.println("error occured when loadResource : "+ e.getMessage());
			e.printStackTrace();
			if (e.getCause() instanceof FileNotFoundException) {
				FileNotFoundException exception = (FileNotFoundException) e
						.getCause();
				System.out.println("FileNotFoundException message : " + exception.getMessage());
			}
		}
	}

	public void loadResource() throws ResourceLoadException {
		File file = new File("config.txt");
		try {
			loadFile(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new ResourceLoadException("Unable to load resource "
					+ file.getName(), e);
		}
	}

	private void loadFile(File file) throws FileNotFoundException {
		String exceptionMsg = MessageUtil.formatMessage(MSG_FILE_NOT_FOUND,
				file.getName());
		throw new FileNotFoundException(exceptionMsg);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundleDemoStart resourceBundleDemoStart = new ResourceBundleDemoStart();
		resourceBundleDemoStart.run();
	}
}
