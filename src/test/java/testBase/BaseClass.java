package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;  // log4j 
import org.apache.logging.log4j.Logger;      // log4j

public class BaseClass {
	
	public static WebDriver driver;
	
	public Logger logger = LogManager.getLogger(this.getClass());     //chat gpt

//	public Logger logger;      //log4j2 
	
	public Properties properties;
	
	
	@BeforeClass(groups = {"Sanity" , "Regression" , "Master"})          //lecture 7 grouping tests here steps from 7.1 to 7.3
	@Parameters({"os","Browser"})
	public void setup(String os , String broser) throws Exception 
	{
		
		// HERE WE ARE LOADING THE PROPERTIES FILE FROM config.propertes in test resources
		FileReader file= new FileReader("./src//test//resources//config.properties");
		
		properties = new Properties();
		
		properties.load(file);
		
		
	    //	logger = LogManager.getLogger(this.getClass());     
		
		// if the exceution value is romote we have to run this(grid selenium concept)
		if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))     // class 10 -->selenium grid concept
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{	
				capabilities.setPlatform(Platform.WIN11);	
			}
			else if(os.equalsIgnoreCase("Linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No Match Os");
				return;
			}
			
			//browser
			switch(broser.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "firefox": capabilities.setBrowserName("firefox");break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("No Matching Browser"); return;                //up to here class 10 from 10.1 to 10.2
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(broser.toLowerCase())
			{
			 
			case "chrome" : driver =  new ChromeDriver(); break;
			
			case "edge" : driver =  new EdgeDriver(); break;
			
			case "firefox" : driver =  new FirefoxDriver(); break;
			
			default : System.out.println("Invalid Browser...."); return;
			}	
		}
			
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(properties.getProperty("appURL"));    //READING URL FROM PROPERETIES FILE
		
		driver.manage().window().maximize();
	}
	
	
	@AfterClass(groups = {"Sanity" , "Regression" , "Master"})   //lecture 7 grouping tests here steps from 7.1 to 7.3
	public void tearDown()
	{
	   driver.quit();	
	}
	

	public String randomString()
	{
		
		String randomlygeneratedString = RandomStringUtils.randomAlphabetic(5);
		
		return randomlygeneratedString;
	}
	
	
	public String randomNumbers()
	{
		
		String randomlygeneratedNumber = RandomStringUtils.randomNumeric(10);
		
		return randomlygeneratedNumber;
	}
	
	
	public String alphaNumeric()
	{

		String randomlygeneratedString = RandomStringUtils.randomAlphabetic(3);
		
		String randomlygeneratedNumber = RandomStringUtils.randomNumeric(3);
		
		return (randomlygeneratedString+"@"+randomlygeneratedNumber);
		
	}
	
	
	public String captureScreen(String tname)throws IOException {              //lecture 8 screenshot 
		
		String timeStamp=new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	

}
