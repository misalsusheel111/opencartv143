package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegestrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class Tc001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression" , "Master"})         // this is lecture from 7.1 to 7.3 (grouping tests)
	public void verify_Account_Registration()
	{
		
		logger.info("**** Starting Tc001_AccountRegistrationTest **** ");
		
		try
		{
		
		HomePage hp = new HomePage(driver);
		
		hp.clicMyAccount();
		logger.info("clicked on MyAccount link");
		
		hp.clickMyRegister();
		logger.info("clicked on Registration link");
		
		AccountRegestrationPage regpage = new AccountRegestrationPage(driver);
		
		logger.info("Providing cutomers details....");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString() + "@Gmail.com");     //randomly generated email
		regpage.setphoneNumber(randomNumbers());
		
		String password = alphaNumeric();
		
		
		
		regpage.setPassword(password);
		regpage.setconfirmPassword(password);
		
		
	    regpage.setcheckPolicy();
	    regpage.clickContinueButton();
	    
	    logger.info("validating expected meassage...");
	    String msgConfirmation = regpage.accountCreatedMessage();
	   
	    AssertJUnit.assertEquals(msgConfirmation, "Your Account Has Been Created!");
	    
		}
		catch(Exception e)
		{
		
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			AssertJUnit.fail();
		}
		
		logger.info("**** Finished Tc001_AccountRegistrationTest **** ");
		
	}
	
		
}
