package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")    // my account page heading
	WebElement msgHeading;
	
	
	// for logout we have to create xpath because logout present in MyAccountPage
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")   // adding in step number 6
	WebElement lnkLogout;
	
	
	
	public boolean isMyAccountPageExists()        // we are not validating here we will validate it in test class
	{
		try 
		{
		return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	//for logout we have created method and perform the action click method
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
}
