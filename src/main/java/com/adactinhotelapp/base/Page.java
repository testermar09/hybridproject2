package com.adactinhotelapp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	
	public static WebDriver driver;
	
	public ExtentReports rep;
	
	public static Properties configProp=new Properties();
	
	public FileInputStream fis;
	
	public ExtentTest test;
	
	public static TopMenu menu;
	
	public Page()
	{
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\adactinhotelapp\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			configProp.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(driver==null)
		{
			if(configProp.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			   	
			}
			
			else if(configProp.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
		 	
			}
			
			else if(configProp.getProperty("browser").equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
		 	
			}
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWaitTime"))));
		}
	}
	
	//common methods or keywords
	
	public void log(String message)
	{
		test.log(Status.INFO, message);
	}
	
	
	public void type(WebElement element,String text)
	{
		log("Entering text "+text+" into the textbox "+element);
		
		element.sendKeys(text);
		
		test.log(Status.INFO, "Entered text "+text+"  into the textbox "+element);
	}
	
	public void click(WebElement element)
	{
		log("Clicking on the element  "+element);
		
		element.click();
		
		test.log(Status.INFO, "Clicked on the element  "+element);
	}
	
	public void select(WebElement element,String text)
	{
		log("Selecting option "+text+" from dropdown "+element);
		
		new Select(element).selectByVisibleText(text);
		
		test.log(Status.INFO, "Selected option  "+text+" from dropdown "+element);
				
	}

}
