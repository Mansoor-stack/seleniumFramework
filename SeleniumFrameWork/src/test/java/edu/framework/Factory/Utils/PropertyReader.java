package edu.framework.Factory.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import edu.framework.Factory.Constants.UIConstants;

public class PropertyReader {

	static File F;
	static FileInputStream fis;
	Properties prop;

	public PropertyReader() {
		String root = System.getProperty("User.dir");

//		F  = new File(root + UIConstants.Config_File);

		F = new File("C:\\Users\\MANSOOR...KHAN\\eclipse-workspace\\SeleniumFrameWork\\src\\test\\resources\\Config\\Config.Properties");
		try {
			fis = new FileInputStream(F);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public String getProperty(String key) {

		return prop.getProperty(key);
	}

	public HashMap<String, String> getProperties() {

		HashMap<String, String> Kvpairs = new HashMap<String, String>();
		System.out.println(prop.keySet());// This line prints keys of config file.

		Set<Object> keySet = prop.keySet();
		for (Object obj : keySet) {
			String Keys = (String) obj;
			String values = prop.getProperty(Keys);
			System.out.println(values);
			Kvpairs.put(Keys, values);
//			System.out.println(Kvpairs);

		}
		return Kvpairs;

	}

	public static void main(String[] args) {
		PropertyReader pr = new PropertyReader();
		System.out.println(pr.getProperty(UIConstants.BaseURL));
		System.out.println(pr.getProperty(UIConstants.Implicitwait));
		System.out.println(pr.getProperty(UIConstants.Browser));
		System.out.println(pr.getProperty(UIConstants.PageLoadWait));
		HashMap<String, String> myMap = pr.getProperties();
		System.out.println(myMap);
		
  }
}