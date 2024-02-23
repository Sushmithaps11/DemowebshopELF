package com.demowebshop.genericlibarary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FrameworkLibrary implements FrameworkConstants
{
	public Actions action;
	public WebDriverWait wait;
	public SoftAssert softAssert;
	public ExtentSparkReporter sparkReporter;  
	public ExtentReports reports;  
	public ExtentTest test;  
	public String testMethodName;

	public void Selectclass(WebElement dropDown,String option) 
	  {
		Select select = new Select(dropDown);
	     int counter=0;
		try
		{
			int indexvalue=Integer.parseInt(option);
			select.selectByIndex(indexvalue);
			counter++;
		}catch(Exception e)//NumberFormatException
		{
			e.printStackTrace();
			System.out.println("Not and index value");
		}
		if(counter==0)
		{
			try {
				select.selectByValue(option);
			}catch(Exception e)
			{
				select.selectByVisibleText(option);
			}
		}
	}
	
	
	
	public String takeScreenshotofPage(WebDriver driver)
	{
		 LocalDateTime dateTime=LocalDateTime.now();
		 String fileName = dateTime.toString().replace(":", "-");
		 
           TakesScreenshot ts = (TakesScreenshot)driver;
           String filePath = SCREENSHOT_PATH+name()+".png";
			File destination=new File(filePath);
			File temp=ts.getScreenshotAs(OutputType.FILE);
		    try {
				FileHandler.copy(temp,destination);
			} catch (IOException e) {
		
				e.printStackTrace();
			}
             return "."+filePath;
	}
	
	public void takeScreenshotofElement(WebElement element)
	{
		File destination=new File(SCREENSHOT_PATH+name()+".png");
		File temp=element.getScreenshotAs(OutputType.FILE);
	    try {
			FileHandler.copy(temp,destination);
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	
	
	public String name()
	{
		LocalDateTime dateTime=LocalDateTime.now();
		 String fileName = dateTime.toString().replace(":", "-");
		 return fileName;
	}
	
	public String getPropertyValue(String key) throws IOException
	{
		File file = new File(PROPERTIES_PATH);
		FileInputStream fis=new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public void initObjects(WebDriver driver) {
		action = new Actions(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		softAssert=new SoftAssert();
	}
	
	public void scrollActionTillWebElement(WebElement element)
	{
		action.scrollToElement(element).build();
	}
}
