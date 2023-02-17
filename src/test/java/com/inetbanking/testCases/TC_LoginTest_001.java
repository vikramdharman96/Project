package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void logintest() throws IOException {
		
		
		logger.debug("Url Opened");
		
		LoginPage lp=new LoginPage(driver);
		
		logger.debug("Enter username and password");
		lp.setUsername(username);
		logger.debug("Username Entered");
		lp.setPassword(password);
		logger.debug("Password Entered");
		lp.clicksubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Test Passed");
		} else {
			captureScreen(driver, "logintest");
			logger.error("Test Failed");
			Assert.assertTrue(false);	
		}
	}

}
