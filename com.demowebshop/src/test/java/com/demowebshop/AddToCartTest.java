package com.demowebshop;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.demowebshop.genericlibarary.Base_Test;
import com.demowebshop.genericlibarary.ExcelRead;
import com.demowebshop.pomrepository.BooksPage;
import com.demowebshop.pomrepository.HomePage;
import com.demowebshop.pomrepository.LoginPage;
import com.demowebshop.pomrepository.ShoppingCartPage;
import com.demowebshop.pomrepository.WelcomePage;

public class AddToCartTest extends Base_Test
{
	@Test(dataProvider ="addToCart")
    public void TC_ShoppingCart_001(String email,String password) {
    	WelcomePage welcomepage = new WelcomePage(driver);
    	welcomepage.clickLogin();
    	test.log(Status.INFO, "Login page is displayed");

    	LoginPage loginpage = new LoginPage(driver);
 	    loginpage.enterEmail(email);
 	    loginpage.enterPassword(password);
 	    loginpage.clickLoginButton();
 	    HomePage homepage = new HomePage(driver);
 	   try {
		   softAssert.assertTrue(homepage.getlogoutLink().isDisplayed());
		   
		   if(homepage.getlogoutLink().isDisplayed()) {
			   test.log(Status.PASS, "User is successfully logged in");

			   welcomepage.clickheaderBooksLink();
			   BooksPage booksPage=new BooksPage(driver);
			   booksPage.computingAndInternetAddToCartButton();
			   booksPage.clickBannerShoppingCartLink();
			   ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
			   softAssert.assertTrue(shoppingCartPage.getShoppingCartFirstRowProductName().getText().contains("Computing and Internet"));
			   test.log(Status. PASS, "Product is added to cart");

		   }
	   }
 	    catch(Exception e) {
 	    	e.printStackTrace();
 	    	test.log(Status.FAIL, "User is not logged in and product is not added to cart"); 
 	    	test.fail(MediaEntityBuilder.createScreenCaptureFromPath (takeScreenshotofPage (driver)).build() );

 	    	Reporter.log("User not logged in");
 	    }
	}
	
	@DataProvider(name="addToCart")
	public String[][] addToCartDataProvider() throws EncryptedDocumentException, IOException{
		return ExcelRead.multipleRead("AddToCart");
	}
}
