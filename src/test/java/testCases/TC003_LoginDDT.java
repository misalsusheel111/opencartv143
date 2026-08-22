package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

//valid credentials = login scuccess = test passed
//invalid credentials = login failed = test failed

//invalid credentials = login seuccess = test failed
//invalid credentials = login failed = test passed

// these all from lecture 6 DataDrivenTesting (6.1 to 6.6(an entry in master.xml file))

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class , groups = "DataDriven")     // this is lecture from 7.1 to 7.3 (grouping tests)
	public void verify_loginDDT(String email , String pwd , String expresult)
	{
		logger.info("***** Starting TC003_LoginDDT *****");
		
		try
		{
			
		HomePage hp = new HomePage(driver);
		hp.clicMyAccount();
		hp.clickOnLogin();
		
		//LoginPage
		//After login in we have moved to loginPage 
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		
		lp.clickLogin();
			
		//MyAccountPage
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean pagetarget = myacc.isMyAccountPageExists();
	
		/*
		 1)data is valid --> login success --> testpass -->logoout
		                     login failes --> testfailed
		 
		 2)data is invalid --> login success --> testfails -->logout 
		                       login failed -->  testpass 
		 
		 */
		
		 if(expresult.equalsIgnoreCase("valid"))
		 {
			 if(pagetarget == true)
			 {
				 myacc.clickLogout();
				 Assert.assertTrue(true);
				
			 }
			 else
			 {
				 Assert.assertTrue(false);
			 }
		 }
		 
		 if(expresult.equalsIgnoreCase("invalid"))
		 {
			 if(pagetarget == true)
			 {
				 myacc.clickLogout();
				 Assert.assertTrue(false);
				
			 }
			 else
			 {
				 Assert.assertTrue(true);
			 }
		 }
		 
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		 logger.info("***** Finished TC003_LoginDDT *****");
		 
		}		
	
	}	

