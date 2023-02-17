package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.Utilities.XLUtility;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass{
	@Test(dataProvider="LoginData")
	
	public void loginDDT(String user, String pwd) {
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		logger.info("User name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clicksubmit();
		
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		} else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
	
		}
		

	}
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/logindata.xlsx";

//		XLUtility xlutil=new XLUtility(path);
		int totalrows=XLUtility.getRowCount(path, "Sheet1");
		int totalcols=XLUtility.getCellCount(path,"Sheet1",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=XLUtility.getCellData(path,"Sheet1", i, j);
			}
			
		}
		
		return loginData;
	}
		
	

}
