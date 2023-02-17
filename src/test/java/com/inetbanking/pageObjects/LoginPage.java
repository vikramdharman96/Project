package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")	
	WebElement btnlogin;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logout;
	
	
	public void setUsername(String Username) {
		txtUsername.sendKeys(Username);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clicksubmit() {
		btnlogin.click();

	}

	public void clicklogout() {
		logout.click();
		
	}
	
	
	
	
		

}
