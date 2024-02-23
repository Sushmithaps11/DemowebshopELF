package com.demowebshop;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demowebshop.genericlibarary.Base_Test;
import com.demowebshop.genericlibarary.ExcelRead;
import com.demowebshop.pomrepository.HomePage;
import com.demowebshop.pomrepository.RegisterPage;
import com.demowebshop.pomrepository.WelcomePage;

public class RegisterTest extends Base_Test
{
	@Test(dataProvider="registerData")
   public void TC_Register_001(String gender,String firstName,String lastName,String email,String password) {
	   WelcomePage welcomePage = new WelcomePage(driver);
	   welcomePage.clickRegisterLink();
	   RegisterPage registerPage = new RegisterPage(driver);
	   if(gender.equalsIgnoreCase("M")) {
		   registerPage.clickMaleRadioButton();
	   }
	   else if(gender.equalsIgnoreCase("F")) {
		   registerPage.clifeckFemaleRadioButton();
	   }
	   else
	   {
		   Reporter.log("Gender is not valid",true);
	   }
	   
	   registerPage.enterFirstName(firstName);
	   registerPage.enterLastName(lastName);
	   registerPage.enterEmail(email);
	   registerPage.enterpassword(password);
	   registerPage.confirmpassword(password);
	   registerPage.clickRegisteButtonr();
	   
	   HomePage homePage=new HomePage(driver);
	   try {
		   softAssert.assertTrue(homePage.getlogoutLink().isDisplayed());
	   }catch(Exception e) {
		   e.printStackTrace();
		   Reporter.log("User not registerd");
	   }
   }
	@DataProvider(name="registerData")
	public String[][] registerDataProvider() throws EncryptedDocumentException, IOException{
		return ExcelRead.multipleRead("register");
	}
}
