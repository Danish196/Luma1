package com.softwaretestingboard.magento.Test;


import org.testng.annotations.Test;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.Pages.WomenPage;

public class Products extends BaseClass{
	WomenPage wp;
	
  @Test
  public void AddProductToCartFromWomenDD() {
	  wp = new WomenPage();
	  wp.AddproductTOCartFromWomenDropdown();
	  wp.VerifyAddedProdInCart();
  }
  
  @Test
  public void AddMultipleProdTOCart() {
	  wp = new WomenPage();
	  wp.AddToCartMultipleProd();
  }
  
  @Test
  public void VerifyPriceOption() {
	  wp = new WomenPage();
	  wp.ShoppingOptions();
  }
  
  @Test
  public void VerifyShowPerPage() {
	  wp = new WomenPage();
	  wp.ShowperPageDD();
  }
  
  
}