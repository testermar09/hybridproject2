package com.adactinhotelapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.base.Page;

public class LoginPage extends Page{
	
	@FindBy(xpath="//input[@name='username'")
	WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password'")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@name='login'")
	WebElement loginButton;
	
	
	public void usernameTextbox(String text)
	{
		type(usernameTextbox,text);
	}
	
	public void passwordTextbox(String text)
	{
		type(passwordTextbox,text);
	}
	
	public void loginButton()
	{
		click(loginButton);
	}

}
