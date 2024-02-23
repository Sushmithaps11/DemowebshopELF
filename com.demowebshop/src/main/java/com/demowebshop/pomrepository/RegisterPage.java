package com.demowebshop.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Base_Page
{
	public RegisterPage(WebDriver driver)
	  {
		 super(driver) ;
	  }

  @FindBy(xpath = "//input[@value='F']")
 private WebElement femaleRadioButton;
  public void clifeckFemaleRadioButton() {
	femaleRadioButton.click();
  }
	
  @FindBy(xpath = "//input[@value='M']")
 private WebElement maleRadioButton;
  public void clickMaleRadioButton() {
	  maleRadioButton.click();
  }
  
  @FindBy(id="FirstName")
 private WebElement firstNameTextField;
  public void enterFirstName(String firstName)
  {
	  firstNameTextField.sendKeys(firstName);
  }
  
  @FindBy(id="LastName")
  private WebElement lastNameTextField;
  public void enterLastName(String lastName) {
	  lastNameTextField.sendKeys(lastName);
  }
  
  @FindBy(id="Email")
 private WebElement emailTextField;
  public void enterEmail(String email) {
	  emailTextField.sendKeys(email);
  }
  
  @FindBy(id = "Password")
private  WebElement passwordTextField;
  public void enterpassword(String password) {
	  passwordTextField.sendKeys(password);
  }
  
  @FindBy(id = "ConfirmPassword")
 private WebElement confirmPasswordTxtFld;
  public void confirmpassword(String password) {
	  confirmPasswordTxtFld.sendKeys(password);
  }
  
  @FindBy(id = "register-button")
 private WebElement registerButton;
  public void clickRegisteButtonr()
  {
	  registerButton.click();
  }
    
 
  
}
