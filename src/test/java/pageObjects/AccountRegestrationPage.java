package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AccountRegestrationPage extends BasePage {
	
	
	public AccountRegestrationPage(WebDriver driver)
	{
		
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtPasswordConfirm;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement txtCheckedPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement clickContinueBtn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	
	public void setFirstName(String firstname) 
	{
		txtFirstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) 
	{
		txtLastName.sendKeys(lastname);
	}
	
	
	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	
	public void setphoneNumber(String phoneno) 
	{
		txtTelephone.sendKeys(phoneno);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void setconfirmPassword(String password)
	{
		txtPasswordConfirm.sendKeys(password);
	}
	
	public void setcheckPolicy()
	{
		txtCheckedPolicy.click();
	}
	
//	public void clickContinueBtn()
//	{
//		clickContinueBtn.click();
//	}
	
	public void clickContinueButton()
	{   
		//sol 1
		clickContinueBtn.click();
		
		//sol 2
	//	clickContinueBtn.submit();
		
		//sol 3
//		Actions act = new Actions(driver);
//		act.click(clickContinueBtn).build().perform();
		
		//solution 4
//		JavascriptException js = (JavascriptException) driver;
//		js.executeScript("arguments[0].click();" ,clickContinueBtn );
		
		//sol 5
//		clickContinueBtn.sendKeys(Keys.RETURN);
		

	}
	
	public String accountCreatedMessage()
	{
	   try
	   {
		  return(msgConfirmation.getText());
				  
	   }catch(Exception e)
	   {
		   return(e.getMessage());
	   }
	}
}
