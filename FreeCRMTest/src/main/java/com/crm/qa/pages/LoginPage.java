package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="email")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginbtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public HomePage Login(String username,String password) {
		
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.loginbtn.click();
		return new HomePage();		
	}
	
	
	
	
}
