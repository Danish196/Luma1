package com.softwaretestingboard.magento.Test;

import org.testng.annotations.Test;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.Pages.CartPage;

//@Listeners(com.softwaretestingboard.magento.listeners.Listners.class)
public class CartTest extends BaseClass{
	
	CartPage cart;
	
  @Test
  public void VerifyEditBtnInCart() {
	  cart = new CartPage();
	  cart.EditAddedProductinCart();
  }
  
  @Test
  public void VerifyRemoveProdFromCart() {
	  cart = new CartPage();
	  cart.RemoveAddedProductFromCart();
  }
  
}