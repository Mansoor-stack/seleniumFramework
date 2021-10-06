package practiceFramework.DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import practiceFramework.Driver.DriverFactory;

public class ReadExcelDataUsingDataProvider {
	static WebDriver driver;

	@BeforeTest
	public static void beforeTest() {

		driver = DriverFactory.initDriver();

	}

	@Test(dataProvider = "LoginCredentials")
	public static void test(String Email, String Password) throws InterruptedException {

//		driver.get("http://a.testaddressbook.com/");

		WebElement signIn = driver.findElement(By.cssSelector("a.nav-item.nav-link:not(.active)"));
		signIn.click();
		
		
		Thread.sleep(5000);
		WebElement email = driver.findElement(By.cssSelector("input.form-control"));
		email.sendKeys(Email);
		Thread.sleep(5000);

		WebElement password = driver.findElement(By.cssSelector("input#session_password"));
		password.sendKeys(Password);
		Thread.sleep(5000);

	}

	@DataProvider(name = "LoginCredentials")
	public static Object[][] dataprovider() {
		Object[][] data = { { "mansoorahmed2214@gmail.com", "Ma@1998." },
				{ "avinash.vcentry@gmail.com", "vcentry2021" } };

		return data;
	}

	@AfterTest
	public static void afterTest() {
		driver.close();
		driver.quit();

	}
}
