package com.softwaretestingboard.magento.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.softwaretestingboard.magento.Base.BaseClass;

public class SignInPage extends BaseClass{
	
	public SignInPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='panel header']//ul//li[2]//a")
	private WebElement signInBtn;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "pass")
	private WebElement pass;

	@FindBy(id = "send2")
	private WebElement SignIn;
	
	@FindBy(xpath = "//div[@class='panel header']//ul//li[1]//span[text() ='Welcome, Danish Mansuri!']")
	private WebElement welcome;
	
	@FindBy(xpath = "//*[text() ='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")
	private WebElement errorMsg;
	
	@FindBy(xpath ="//*[text() = 'New Customers']")
	private WebElement newCustomer;
	
	@FindBy(xpath ="//a[@class='action create primary']")
	private WebElement createAcc;
	
	@FindBy(xpath = "//span[text()='Create New Customer Account']")
	private WebElement CreateNewAccText;
	
	@FindBy(xpath = "//a[@class='action remind']")
	private WebElement forgotpass;
	
	@FindBy(xpath ="//h1[@class='page-title']//span")
	private WebElement forgetUrPass;
	
	
	public void signInWithValidCred() {
		signInBtn.click();
		email.sendKeys("danishmansuri3@gmail.com");
		pass.sendKeys(prop.getProperty("password"));
		SignIn.click();
		
		Assert.assertTrue(welcome.isDisplayed());
	}
	
	public void SignInWithInavlidCred() {
		signInBtn.click();
		email.sendKeys("danishmansuri3@gmail.com ");
		pass.sendKeys(prop.getProperty("password"));
		SignIn.click();
		Assert.assertTrue(errorMsg.isDisplayed());
		
	}
	
	public void createAccBtn() {
		signInBtn.click();
		Assert.assertTrue(newCustomer.isDisplayed());
		createAcc.click();
		Assert.assertTrue(CreateNewAccText.isDisplayed());
	}
	
	public void ForgotpassBtn() {
		signInBtn.click();
		forgotpass.click();
		String forgotpassUrl ="https://magento.softwaretestingboard.com/customer/account/forgotpassword/";
		Assert.assertEquals(driver.getCurrentUrl(),forgotpassUrl );
		
	}
}
