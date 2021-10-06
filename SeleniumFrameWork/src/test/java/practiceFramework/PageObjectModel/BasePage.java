package practiceFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 15);
	}
	
	public void click(WebElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	public void type(WebElement element, String EnterFields) {
		wait.until(ExpectedConditions.visibilityOf(element));
		
		element.sendKeys(EnterFields);
	}

}
