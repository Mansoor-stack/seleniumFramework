package practiceFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageUsingFindBy extends BasePage {

	WebDriver driver;
	public LoginPageUsingFindBy(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	WebElement HomeSignIn;

	@FindBy(how = How.ID, using = "session_email")
	WebElement Email;

	@FindBy(how = How.ID, using = "session_password")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@name='commit']")
	WebElement SignIn;

	

	
	public void HomeSignIn() {
		click(HomeSignIn);
	}

	public void Email(String email) {
		type(Email, email);
	}

	public void password(String passwrd) {

		type(password, passwrd);
	}

	public void SignIn() {
		click(SignIn);
	}

}
