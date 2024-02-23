package com.demowebshop;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demowebshop.genericlibarary.Base_Test;
import com.demowebshop.genericlibarary.ExcelRead;
import com.demowebshop.pomrepository.HomePage;
import com.demowebshop.pomrepository.LoginPage;
import com.demowebshop.pomrepository.WelcomePage;


public class LoginTest extends Base_Test
{
	@Test(dataProvider="loginData")
   public void TC_Login_001(String email,String password) throws InterruptedException
   {
	  
	  WelcomePage welcomepage= new WelcomePage(driver);  //make webdriver driver as public in basetest class
	  welcomepage.clickLogin();
	  Thread.sleep(3000);
	   
	   LoginPage loginpage = new LoginPage(driver);
	   loginpage.enterEmail(email);
	   loginpage.enterPassword(password);
	   loginpage.clickLoginButton();
	   Thread.sleep(3000);
	   HomePage homepage = new HomePage(driver);
	   try {
		   softAssert.assertTrue(homepage.getlogoutLink().isDisplayed());
	   }
	   catch(Exception e){
		   e.printStackTrace();
		   Reporter.log("User not logged in");
	   }
   }
	
	@DataProvider(name="loginData")
	public String[][] loginDataProvider() throws EncryptedDocumentException, IOException
	{
		return ExcelRead.multipleRead("login");
	}
	
}
