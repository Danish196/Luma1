package com.softwaretestingboard.magento.Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.Pages.CheckOutPage;

public class CheckOutTest extends BaseClass {
	
	CheckOutPage check;
	
  @Test
  public void VerifyLoginWhileCheckOutPeod() throws InterruptedException {
	  check = new CheckOutPage();
	  check.LoginWhileCheckout();
  }
}