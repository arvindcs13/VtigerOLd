package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileReader {
	/*
	 * Class to read data from Property file
	 */

	public String getPropertydata(String key)throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Vijay\\naya-workspace\\vtigercrm\\src\\main\\resources\\testdata.properties");
        Properties pr = new Properties();
        pr.load(fis);
        String value = pr.getProperty(key);
        
		return value;
	}

}
