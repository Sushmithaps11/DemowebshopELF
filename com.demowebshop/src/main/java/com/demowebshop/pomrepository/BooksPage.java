package com.demowebshop.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends Base_Page
{

	public BooksPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath  = "//a[text()='Computing and Internet']/parent::h2/..//input")
    private  WebElement computingAndInternetAddToCartButton;
	
	public void computingAndInternetAddToCartButton() {
		computingAndInternetAddToCartButton.click();
	}
	
	@FindBy(xpath = "//a[text()='shopping cart']")
	private WebElement shoppingCartLinkAfterAddingProductToCart;
	
	public void clickBannerShoppingCartLink() {
		shoppingCartLinkAfterAddingProductToCart.click();
	}
}
