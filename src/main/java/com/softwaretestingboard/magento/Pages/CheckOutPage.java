package com.softwaretestingboard.magento.Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.testng.Assert;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.utils.utils;

public class CheckOutPage extends BaseClass {

	public CheckOutPage() {
		PageFactory.initElements(driver,this );

	}


	ProductDetailsPage PD;
	Actions action;
	WebDriverWait wait;

	@FindBy(xpath="//button[@data-role='proceed-to-checkout']")
	private WebElement ProceedToCheckOutBtn;

	@FindBy(id="customer-email")
	private WebElement EmailAdd;

	@FindBy(id="customer-password")
	private WebElement Password;

	@FindBy(xpath="//button[@data-action='checkout-method-login']")
	private WebElement loginBtn;

	@FindBy(xpath="//*[@id='checkout-step-shipping']/div[1]/div/div/div")
	private WebElement ShippingAdd;

	@FindBy(xpath="//button[@data-role='opc-continue']")
	private WebElement NextBtn;

	@FindBy(xpath="//input[@id='billing-address-same-as-shipping-checkmo']")
	private WebElement BillingShippingAddCheckBox;

	@FindBy(xpath="//span[text()='Place Order']")
	private WebElement placeOrderBtn;

	@FindBy(xpath ="//span[text()='Thank you for your purchase!']")
	private WebElement ThanksForPurchase;

	//	@FindBy(xpath = "//*[@class=\"payment-method-content\"]")
	//	private WebElement Overlap;
	
	@FindBy(xpath = "//div[@data-role='loader']/div/img")
	private WebElement loader;

	public void LoginWhileCheckout() 
	{
		PD = new ProductDetailsPage();
		PD.AddToCartOnProdDetails();

		ProceedToCheckOutBtn.click();


		utils.waitForElementPresent(driver, EmailAdd, Duration.ofSeconds(3));
		EmailAdd.sendKeys("danishmansuri89");
		utils.waitForElementPresent(driver, Password, Duration.ofSeconds(10));
		Password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		utils.waitForElementPresent(driver,ShippingAdd , Duration.ofSeconds(10));
		System.out.println("DFGHSF");
		Assert.assertTrue(ShippingAdd.isEnabled());
		NextBtn.click();
		Assert.assertTrue(BillingShippingAddCheckBox.isSelected());
		PlaceOrder();

	}

	public void PlaceOrder() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(3000));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",placeOrderBtn);
				
		wait.until(ExpectedConditions.invisibilityOf(loader));
				
				placeOrderBtn.click();
				
	}


	

		
}