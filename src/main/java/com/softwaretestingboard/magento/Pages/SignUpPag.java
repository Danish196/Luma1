package com.softwaretestingboard.magento.Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.softwaretestingboard.magento.Base.BaseClass;

import sun.security.util.Password;

public class SignUpPag extends BaseClass {

	public SignUpPag() {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//div[@class='panel header']//ul//li[3]//a")
	private WebElement createAccBtn;

	@FindBy(xpath = "//span[text()='Create New Customer Account']")
	private WebElement CreateNewAccText;

	@FindBy(id = "firstname")
	private WebElement firstName;

	@FindBy(id = "lastname")
	private WebElement lastName;

	@FindBy(id = "email_address")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement pass;

	@FindBy(id = "password-confirmation")
	private WebElement confirmpass;

	@FindBy(xpath = "//button[@class='action submit primary']")
	private WebElement submitBtn;

	@FindBy(xpath = "//*[text() = 'Thank you for registering with Main Website Store.']")
	private WebElement successfulRegMsg;
	
	@FindBy(xpath ="//*[text() ='There is already an account with this email address. If you are sure that it is your email address, ']")
	private WebElement regEmailerror;

	public void signUp() {
		createAccBtn.click();
		Assert.assertTrue(CreateNewAccText.isDisplayed());

		firstName.sendKeys("Danish");
		lastName.sendKeys("Mansuri");
		email.sendKeys("danishmansuri23");
		pass.sendKeys(prop.getProperty("password"));
		confirmpass.sendKeys(prop.getProperty("password"));
		submitBtn.click();
		Assert.assertTrue(successfulRegMsg.isDisplayed());
	}
	
	public void signUpWithRegisteredEmail() {
		createAccBtn.click();
		Assert.assertTrue(CreateNewAccText.isDisplayed());
		firstName.sendKeys("Danish");
		lastName.sendKeys("Mansuri");
		email.sendKeys("danishmansuri23");
		pass.sendKeys(prop.getProperty("password"));
		confirmpass.sendKeys(prop.getProperty("password"));
		submitBtn.click();
		Assert.assertTrue(regEmailerror.isDisplayed());
	}
	
	

}


		