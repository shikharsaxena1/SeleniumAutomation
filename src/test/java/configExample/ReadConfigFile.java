package configExample;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\com.org.coforge.webapplication\\data\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("URL"));
		System.out.println(prop.getProperty("userName"));
		System.out.println(prop.getProperty("password"));

		 }
	}

