package edu.framework.Factory.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageUsingFindBy {

	WebDriver driver;
	
	

	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	WebElement SignIN;

	@FindBy(how = How.ID, using = "session_email")
	WebElement Email;

	@FindBy(how = How.ID, using = "session_password")
	WebElement Password;

	@FindBy(how = How.XPATH, using = "//input[@name='commit']")
	WebElement ClickSignIn;

	public LoginPageUsingFindBy(WebDriver d) {
		driver = d;
//		PageFactory.initElements(d,this);
	
	}

	public void SignIN() {

		SignIN.click();
	}

	public void email(String mail_id) {
		Email.sendKeys(mail_id);

	}

	public void password(String Pass_wrd) {
		Password.sendKeys(Pass_wrd);

	}

	public void clickSign() {

		ClickSignIn.click();

	}
}
