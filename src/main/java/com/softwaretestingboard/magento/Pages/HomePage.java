package com.softwaretestingboard.magento.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.utils.utils;

public class HomePage extends BaseClass {
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//h2[text() = 'Hot Sellers']")
	private WebElement hotSeller;
	
	@FindBy(id= "search")
	private WebElement search;
	
	@FindBy(xpath= "//button[@class='action search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//span[text() = \"Search results for: 'shirt'\"]")
	private WebElement searchResultFor;
	
	@FindBy(xpath = "//*[text() = 'Related search terms']")
	private WebElement RelatedSearch;
	
	@FindBy(xpath= "//div[@class='search results']/dl/dd")
	private List<WebElement> relatedSearchItems;
	
	public void hotSellers() {
		utils.scrollToElement(driver, hotSeller);
		Assert.assertTrue(hotSeller.isDisplayed());
		
	}
	
	public void SearchProduct() {
		search.sendKeys("shirt");
		utils.waitForClickableElement(driver, searchBtn, Duration.ofSeconds(5));
		searchBtn.click();
		Assert.assertTrue(searchResultFor.isDisplayed());
	}
	
	public void RelatedSearchItems() {
		SearchProduct();
		Assert.assertTrue(RelatedSearch.isDisplayed());
		
		for(WebElement relatedSearchResult : relatedSearchItems) {
			String result = relatedSearchResult.getText();
			Assert.assertTrue(result.toLowerCase().contains("shirt") || result.toLowerCase().contains("shirts"),
					"Search result title doesn't contain search query: " + result);
		}
		
	}
	
	
	public void blankSearch() {
		search.sendKeys("");
		Assert.assertTrue(searchBtn.isDisplayed());
		
	}
	
	public void navigation() {
		
	}
	

}