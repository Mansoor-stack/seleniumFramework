package practiceFramework.Driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import practiceFramework.Constants.UIconstants;
import practiceFramework.PropertyReader.PropertyReader;

public class DriverFactory {

	public static WebDriver driver;

	public static WebDriver initDriver() {
		PropertyReader props = new PropertyReader();
	String Browser=	props.getProperty(UIconstants.BROWSER);
		

		switch (Browser) {

		case "chrome":
			ChromeOptions Options = new ChromeOptions();
			Options.setExperimentalOption("debuggerAddress", "localhost:2214");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(Options);
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();

			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();

			break;

		default:
			System.out.println("No browser is matched with switch case block");
		}
		
		int wait = Integer.parseInt(props.getProperty(UIconstants.WAIT));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(wait, TimeUnit.SECONDS);
		return driver;
	}
	


}
