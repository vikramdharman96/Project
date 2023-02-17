package com.inetbanking.testCases;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.inetbanking.Utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	//Reading properties file
	ReadConfig rc=new ReadConfig();
	public String baseurl=rc.getApplicationUrl();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	public static String screenshotsSubFolderName;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger = LogManager.getLogger(TC_LoginTest_001.class.getName());
		
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			logger.debug("Chrome Browser Generated");	
		} 
		else if(br.equals("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			logger.debug("Edge Browser Generated");
		}else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			logger.debug("Firefox Browser Generated");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseurl);

		
		

		
		
	
	}
	@AfterClass
	public void tearDown() {
		driver.close();
		
		logger.debug("Browser Closed");
	}
	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target=new File("./Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	


}
