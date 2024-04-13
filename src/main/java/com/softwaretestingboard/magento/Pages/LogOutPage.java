package com.softwaretestingboard.magento.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.softwaretestingboard.magento.Base.BaseClass;

public class LogOutPage extends BaseClass {
	
	
	
	public LogOutPage() {
		PageFactory.initElements(driver, this );
	}
	
	@FindBy(xpath = "//div[@class='panel header']//ul//span[@class='customer-name']//button")
	private WebElement customerName;
	
	@FindBy(xpath ="//div[@class='panel header']/ul/li[2]/div/ul/li[3]/a")
	private WebElement signOut;
	
	
	public void SignOut() {
		customerName.click();
		signOut.click();
		String logOutsuccessUrl = "https://magento.softwaretestingboard.com/customer/account/logoutSuccess/";
		Assert.assertEquals(driver.getCurrentUrl(), logOutsuccessUrl);
		System.out.println("Customer logged out successfully");
	}
}