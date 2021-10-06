package practiceFramework.PropertyReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import practiceFramework.Constants.UIconstants;

public class PropertyReader {
	Properties prop;

	public String getProperty(String name) {

		FileInputStream file;

		try {
			file = new FileInputStream(
					"C:\\Users\\MANSOOR...KHAN\\eclipse-workspace\\seleniummaven\\src\\test\\resources\\Config2\\Config2.Properties");
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop.getProperty(name);
	}

	/*
	 * public static void main(String[] args) throws IOException{
	 * 
	 * // PropertyReader reader = new PropertyReader();
	 * 
	 * System.out.println(getProperty(UIconstants.BROWSER));
	 * 
	 * System.out.println(getProperty(UIconstants.URL));
	 * System.out.println(getProperty(UIconstants.WAIT));
	 * 
	 * }
	 */
}
