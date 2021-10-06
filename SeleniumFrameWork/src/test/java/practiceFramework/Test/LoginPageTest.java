package practiceFramework.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practiceFramework.Driver.DriverFactory;

public class LoginPageTest {
	
	static WebDriver driver;
@BeforeTest
	public static void beforeTest() throws IOException {
	
	driver = DriverFactory.initDriver();

	}
@Test
	public static void test()  {
	
	driver.get("http://a.testaddressbook.com/");
	
	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(screenshot, new File("C://Users//MANSOOR...KHAN//eclipse-workspace//seleniumproject//src//test//resources//screenshots//address.jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}

@AfterTest	
public static void afterTest() {
//	driver.close();
//	driver.quit();

	}
}
