package com.softwaretestingboard.magento.Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.Pages.ProductDetailsPage;

//@Listeners(com.softwaretestingboard.magento.listeners.Listners.class)
public class ProductDetailsTest extends BaseClass{
	ProductDetailsPage PD;
	
  @Test
  public void VerifyProductDetails() {
	  PD = new ProductDetailsPage();
	  PD.productDetails();
  }
  
  @Test
  public void AddToCartProdFromProdDetailsPage() {
	  PD = new ProductDetailsPage();
	  PD.AddToCartOnProdDetails();
  }
  
  @Test
  public void VerifyAddtoCartProdWithoutSelectingSize() {
	  PD = new ProductDetailsPage();
	  PD.AddtoCartProdWithoutSelectingSize();
  }
  
  @Test
  public void VerifyAddreviewtoProduct() {
	  PD = new ProductDetailsPage();
	  PD.AddReviewToProd();
	  
  }
  
  @Test
  public void VerifyAddToWishlistWithoutLogin() {
	  PD = new ProductDetailsPage();
	  PD.AddProdToWishListwithoutLogin();
  }
  
  
  @Test
  public void VerifyAddToWishlistWithLogin() {
	  PD = new ProductDetailsPage();
	  PD.AddProdToWishList();
  }
  
  @Test
  public void VerifyRemoveProdFromWishList() {
	  PD = new ProductDetailsPage();
	  PD.RemoveProdFromWishList();
  }
  
  
  
  
}