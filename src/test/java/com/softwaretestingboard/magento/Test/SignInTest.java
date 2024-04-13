package com.softwaretestingboard.magento.Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.Pages.SignInPage;


public class SignInTest extends BaseClass{
	
	SignInPage signIn;
	
  @Test
  public void SignInValidCred() {
	  signIn = new SignInPage();
	  signIn.signInWithValidCred();
  }
  
  @Test
  public void SignInWithInvalidCred() {
	  signIn = new SignInPage();
	  signIn.SignInWithInavlidCred();
  }
  
  @Test
  public void CreateNewAccOnSignInPage() {
	  signIn = new SignInPage();
	  signIn.createAccBtn();
  }
  
  @Test
  public void ForgotpassBtn() {
	  signIn = new SignInPage();
	  signIn.ForgotpassBtn();
  }
  
}