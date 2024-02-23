package com.demowebshop.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.genericlibarary.FrameworkLibrary;

public class Base_Page extends FrameworkLibrary
{
	public Base_Page(WebDriver driver) {
		   PageFactory.initElements(driver, this);
		   
	   }
	   
}
