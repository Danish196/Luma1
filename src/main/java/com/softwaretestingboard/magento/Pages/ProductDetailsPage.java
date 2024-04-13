package com.softwaretestingboard.magento.Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.utils.Constants;
import com.softwaretestingboard.magento.utils.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductDetailsPage extends BaseClass {

	Constants con;
	public WebDriverWait wait;

	SignInPage signIn;

	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ui-id-5")
	private WebElement men;

	@FindBy(xpath = "//a[@id='ui-id-18']")
	private WebElement bottoms;

	@FindBy(xpath = "//a[@id=\"ui-id-24\"]")
	private WebElement shorts;

	@FindBy(xpath= "//*[@id='maincontent']/div[3]/div[1]/div[4]/ol/li[1]")
	private WebElement Piercegymshort;

	@FindBy(xpath = "//span[text() ='Shorts']//following::h1")
	private WebElement ShortsText;

	@FindBy(xpath = "//span[@data-ui-id=\"page-title-wrapper\"]")
	private WebElement ProdTitle;

	@FindBy(xpath ="//span[@id=\"product-price-1028\"]//span")
	private WebElement ProdPrice;

	@FindBy(xpath = "//div[@class=\"stock available\"]//span")
	private WebElement availability;


	@FindBy(xpath = "//div[@class=\"product attribute description\"]//p[1]")
	private WebElement des;

	@FindBy(id="product-addtocart-button")
	private WebElement PATOC;

	@FindBy(id="option-label-size-143-item-175")
	private WebElement size;

	@FindBy(id="option-label-color-93-item-52")
	private WebElement color;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
	private WebElement prodAddedToCartMsg;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a")
	private WebElement shoppingCartBtn;

	@FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[1]/div/strong/a")
	private WebElement PiercegymshortTitle;

	@FindBy(xpath ="//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[1]/div/dl/dd[1]")
	private WebElement PiercegymshortSize;

	@FindBy(xpath ="//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[1]/div/dl/dd[2]")
	private WebElement PiercegymshortColor;

	@FindBy(xpath ="//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[2]/span/span/span")
	private WebElement PiercegymshortPrice;


	@FindBy(xpath="//table[@id=\"shopping-cart-table\"]/tbody[1]/tr/td[3]/div/div/label/input")
	private WebElement PiercegymshortQuantity;

	@FindBy(xpath ="//*[@id=\"super_attribute[143]-error\"]")
	private WebElement ErrMsg;

	@FindBy(id="tab-label-reviews-title")
	private WebElement reviewTab;

	@FindBy(xpath="//*[@id='Rating_4']")
	private WebElement StarRating;

	@FindBy(id="nickname_field")
	private WebElement nickName;

	@FindBy(id="summary_field")
	private WebElement Summary;

	@FindBy(id="review_field")
	private WebElement review;

	@FindBy(xpath = "//*[@id=\"review-form\"]/div/div/button")
	private WebElement subReviewBtn;

	@FindBy(xpath="//*[text()='You submitted your review for moderation.']")
	private WebElement submittedMsg;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[5]/div/a[1]" )
	private WebElement wishList;

	@FindBy(xpath ="//*[text()= 'You must login or register to add items to your wishlist.']")
	private WebElement wishListerrMsg;

	@FindBy(xpath = "//div[contains(., 'Pierce Gym Short has been added to your Wish List.'  )]")
	private WebElement produtTitle;
	
	@FindBy(xpath="//h1/span[text()='My Wish List']")
	private WebElement wishListheading;
	
	
	@FindBy(xpath="//*[@id=\"item_19972\"]/div/a/span/span/img")
	private WebElement prod;
	
	@FindBy(xpath ="//*[@id=\"wishlist-sidebar\"]/li/div/div/div[2]/div[2]/a")
	private WebElement RemoveBtnWishList;
	
	@FindBy(xpath = "//span[text()='You have no items in your wish list.']")
	private WebElement emptyWishlist;
	
	@FindBy(className ="page-footer")
	private WebElement footer;

	


	public void productDetails() {
		con = new Constants();
		Actions action = new Actions(driver);
		action.moveToElement(men).perform();
		action.moveToElement(bottoms).perform();
		action.moveToElement(shorts).perform();
		shorts.click();
		Assert.assertTrue(ShortsText.isDisplayed());
		utils.scrollToElement(driver, Piercegymshort);
		Piercegymshort.click();

		String title = ProdTitle.getText();
		String price = ProdPrice.getText();
		String Stock = availability.getText();
		String Des = des.getText();
//		System.out.println(Des);

		Assert.assertEquals(title, con.ProductTitle);
		Assert.assertEquals(price, con.ProductPrice);
		Assert.assertEquals(Stock, con.availability);
		Assert.assertEquals(Des,con.details );

	}

	public void AddToCartOnProdDetails() {
		productDetails();
		size.click();
		color.click();
		PATOC.click();
		String Msg = prodAddedToCartMsg.getText();
		System.out.println(Msg);

		Assert.assertEquals(Msg , "You added Pierce Gym Short to your shopping cart.");
		shoppingCartBtn.click();

		VerifyAddedProdInCart();


	}

	public void VerifyAddedProdInCart() {
		con = new Constants();

		//		System.out.println(actualQuantity);

		String actualTitle = PiercegymshortTitle.getText();
		String actualSize = PiercegymshortSize.getText();
		String actualColor = PiercegymshortColor.getText();
		String actualPrice = PiercegymshortPrice.getText();
		String actualQuantity = PiercegymshortQuantity.getAttribute("value");
		Assert.assertEquals(actualTitle,con.ProductTitle , "Title mismatch");
		Assert.assertEquals(actualSize,con.ProductSize , "Size mismatch");
		Assert.assertEquals(actualColor,con.ProductColor , "Color mismatch");
		Assert.assertEquals(actualPrice, con.ProductPrice, "Price mismatch");
		Assert.assertEquals(actualQuantity, con.quantity, "Quantity mismatch");
		
	}

	public void AddtoCartProdWithoutSelectingSize() {
		productDetails();
		color.click();
		PATOC.click();
		Assert.assertTrue(ErrMsg.isDisplayed());
	}

	public void AddReviewToProd() {
		productDetails();
		utils.scrollToElement(driver,reviewTab );

		reviewTab.click();

		//		
		// Scroll to the element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", StarRating);

		// Click on the element using JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", StarRating);

		nickName.sendKeys("John");
		Summary.sendKeys("Not great ");
		review.sendKeys("- buttons are too small and hurt my fingers trying to button it.");
		subReviewBtn.click();
		utils.ScrolltoTop(driver);
		Assert.assertTrue(submittedMsg.isDisplayed());
		//		
	}

	public void AddProdToWishListwithoutLogin() {
		productDetails();
		wishList.click();
		Assert.assertTrue(wishListerrMsg.isDisplayed());
	}

	public void AddProdToWishList() {
		signIn = new SignInPage();
		signIn.signInWithValidCred();
		productDetails();
		wishList.click();
		Assert.assertTrue(wishListheading.isDisplayed());
		Assert.assertTrue(produtTitle.isDisplayed());
}
	
	
	public void RemoveProdFromWishList() {
		AddProdToWishList();
		utils.scrollToElement(driver,RemoveBtnWishList );
//		Actions action = new Actions(driver);
//		action.moveToElement(prod).perform();

		RemoveBtnWishList.click();
		
		Assert.assertTrue(emptyWishlist.isDisplayed());
		
	}

}