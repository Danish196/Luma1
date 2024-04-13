package com.softwaretestingboard.magento.Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.Pages.HomePage;

//@Listeners(com.softwaretestingboard.magento.listeners.Listners.class)
public class HomePageTest extends BaseClass {
	HomePage home;
  @Test
  public void VerifyHotSeller() {
	  home = new HomePage();
	  home.hotSellers();
  }
  
  @Test
  public void VerifySearchProduct() {
	  home = new HomePage();
	  home.SearchProduct();
  }
  
  @Test
  public void VerifyRelatedSearchItems() {
	  home = new HomePage();
	  home.RelatedSearchItems();
  }
  
  @Test
  public void VerifyBlankSearch() {
	  home = new HomePage();
	  home.blankSearch();
  }
}