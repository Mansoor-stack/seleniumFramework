package practiceFramework.DataDriven;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practiceFramework.Driver.DriverFactory;

public class FormTest {
	static WebDriver driver;
	@BeforeTest
	public static void beforeTest() {
		driver = DriverFactory.initDriver();
		
	}
	@Test
	public static void test() {
		
	driver.get("http://a.testaddressbook.com/addresses/new");	
	ReadDataFromExcel obj = new ReadDataFromExcel();
	

	} 

	@AfterTest
	public static void afterTest() {
		
	driver.close();
	driver.quit();
	}
}
