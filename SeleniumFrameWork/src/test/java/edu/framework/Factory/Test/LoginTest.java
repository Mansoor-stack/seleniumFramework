package edu.framework.Factory.Test;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import edu.framework.Factory.PageObject.LoginPageUsingFindBy;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;

public class LoginTest {

	WebDriver driver;
Logger logger = LogManager.getLogger(LoginTest.class);

	@BeforeClass
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:2214");
		ChromeDriverManager chrome = new ChromeDriverManager();
		chrome.setup();
//		WebDriverManager manager = new WebDriverManager();
		driver = new ChromeDriver(options);
//		PropertyReader prop = new PropertyReader();
//		prop.getProperty(UIConstants.Implicitwait);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@Test
	public void Test() {
		driver.get("http://a.testaddressbook.com/");

	/*	LoginPage loginPage = new LoginPage(driver);

		loginPage.HomeSignIn();
		loginPage.enterEmailId("mansoorahmed2214@gmail.com");
		loginPage.enterPassword("Ma@1998.");
		loginPage.clickSignIn();
		
		*/
		
		LoginPageUsingFindBy logFindBy = new LoginPageUsingFindBy(driver);
		logFindBy = PageFactory.initElements(driver, LoginPageUsingFindBy.class);//Method to instatiate elements of LoginPageUsingFindBy from Test class
		logFindBy.SignIN();
		logger.trace("Clicked Sign In link");
		logFindBy.email("mansoorahmed2214@gmail.com");
		logger.info("Entered user mail id successfully");
		logFindBy.password("Ma@1998.");
		logger.debug("Entered user password successfully");
		logFindBy.clickSign();
		logger.warn("Entered credentials and Cliscked sign in button");
		

	}

	@AfterClass
	public void TearDown() {
//		driver.close();
//		driver.quit();
	}
}
