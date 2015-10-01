package JavaCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.rmi.ServerException;
import java.sql.SQLException;

public class ExceptionTest {

	public void read(File file) throws Exception{
		if(!file.exists()){
			Exception e = new FileNotFoundException();
			throw e;
		}
	}
	
	public void callRead(){
		try {
			//可能抛出异常的代码
			read(new File("filename1"));
			read(new File("filename2"));
		} catch (Exception e) {
			//异常处理代码
			e.printStackTrace();
			e.getMessage()
		}
		finally{
			//无论如何需要执行的代码，比如释放资源	
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
