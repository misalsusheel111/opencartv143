package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//here we will write xpath for username password and login click button
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnlogin;
	
	
	public void setEmail(String email) {
		              
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String password) {
		                    
		txtpassword.sendKeys(password);
	}
	
	                                            // up to this newly added code chat gpt
	
	public void clickLogin() {
		btnlogin.click();
	}
}
