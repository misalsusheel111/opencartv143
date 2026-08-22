package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	
	@Test(groups={"Sanity","Master"})      // this is lecture from 7.1 to 7.3 (grouping tests)
	public void verify_Login()
	{
		
		logger.info("***** Starting TC002_LoginTest *****");
		
		//HomePage
		//create HomePage object to call the methods myAccount()&clickLogin()
		try
		{	
		HomePage hp = new HomePage(driver);
		hp.clicMyAccount();
		hp.clickOnLogin();
		
		//LoginPage
		//After login in we have moved to loginPage 
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(properties.getProperty("email"));
		lp.setPassword(properties.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean pagetarget = myacc.isMyAccountPageExists();
		
		//Assert.assertEquals(pagetarget, true,"login failed");
		AssertJUnit.assertTrue(pagetarget);
		//Assert.assertTrue(pagetarget, "Login failed - My Account page was not displayed");
		}
		catch(Exception e)
		{
		   AssertJUnit.fail();
		}
        
		logger.info("***** Finished TC002_LoginTest *****");
	}
	
	
	
}
