package com.softwaretestingboard.magento.Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.Pages.LogOutPage;
import com.softwaretestingboard.magento.Pages.SignInPage;

//@Listeners(com.softwaretestingboard.magento.listeners.Listners.class)
public class LogOutTest extends BaseClass {
	
	SignInPage signIn;
	LogOutPage logOut;
	
  @Test
  public void LogOut() {
	  signIn = new SignInPage();
	  signIn.signInWithValidCred();
	  logOut = new LogOutPage();
	  logOut.SignOut();
	  
  }
}