package com.softwaretestingboard.magento.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.softwaretestingboard.magento.Base.BaseClass;
import com.softwaretestingboard.magento.utils.Constants;
import com.softwaretestingboard.magento.utils.utils;

public class WomenPage extends BaseClass{
	Constants con;

	public WomenPage() {
		PageFactory.initElements(driver,this );
	}

	@FindBy(id ="ui-id-4")
	private WebElement WomenBtn;

	@FindBy(xpath= "//h1//span[text()='Women']")
	private WebElement Womenheading;

	@FindBy(id="ui-id-9")
	private WebElement WTops;

	@FindBy(id ="ui-id-11")
	private WebElement WJackets;

	@FindBy(xpath = "//span[text() = \"Jackets\"]//following::h1")
	private WebElement jacketText;

	@FindBy(xpath = "//div[@data-product-id=\"1396\"]")
	private WebElement OliviaJacket;



	@FindBy(id = "option-label-size-143-item-166")
	private WebElement sizeOliveaJacket;

	@FindBy(id="option-label-color-93-item-49")
	private WebElement BlackColorOliveaJacket;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/div/div[3]/div/div[1]/form/button" )
	private WebElement OliviaAtoC;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
	private WebElement  AddedToCartMsg;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div/a")
	private WebElement shoppingCart;

	@FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[1]/div/strong/a")
	private WebElement OliviaTitle;

	@FindBy(xpath ="//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[1]/div/dl/dd[1]")
	private WebElement OliviaSize;

	@FindBy(xpath ="//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[1]/div/dl/dd[2]")
	private WebElement OliviaColor;

	@FindBy(xpath ="//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[2]/span/span/span")
	private WebElement OliviaPrice;

	//	@FindBy(xpath="//input[@id='cart-657971-qty']")
	@FindBy(xpath="//table[@id=\"shopping-cart-table\"]/tbody[1]/tr/td[3]/div/div/label/input")
	private WebElement OliviaQuantity;


	@FindBy(xpath = "//div[@data-product-id='1380']")
	private WebElement JunoJacket;

	@FindBy(xpath= "//div[@class=\"products wrapper grid products-grid\"]//ol//li[2]//div//div[3]/div//div[@id=\"option-label-size-143-item-166\"]")
	private WebElement JunoJacketSize;

	@FindBy(xpath= "//ol[@class=\"products list items product-items\"]/li[2]/div/div/div[3]/div[2]/div/div[1]")
	private WebElement JunoJacketColor;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[2]/div/div/div[4]/div/div[1]/form/button")
	private WebElement JunoJacketAToCBtn;

	@FindBy(xpath= "//div[@data-block=\"minicart\"]/a")
	private WebElement minicart;

	@FindBy(xpath ="//a[@class=\"action viewcart\"]")
	private WebElement viewCart;


	@FindBy(xpath ="//*[@id='shopping-cart-table']/tbody[2]/tr[1]/td[1]/div/strong/a")
	private WebElement JunoJacketTitle;

	@FindBy(xpath ="//*[@id='shopping-cart-table']/tbody[2]/tr[1]/td[1]/div/dl/dd[1]")
	private WebElement JunoJacketsize;

	@FindBy(xpath="//*[@id='shopping-cart-table']/tbody[2]/tr[1]/td[1]/div/dl/dd[2]")
	private WebElement JunoJacketcolor;

	@FindBy(xpath="//*[@id='shopping-cart-table']/tbody[2]/tr[1]/td[2]/span/span/span")
	private WebElement JunoJacketprice;

	@FindBy(xpath="//table[@id='shopping-cart-table']/tbody[2]/tr/td[3]/div/div/label/input")
	private WebElement JunoJacketquantity;
	
	
	@FindBy(xpath="//div[@id='narrow-by-list']/div[3]/div[1]")
	private WebElement priceShoppingOption;
	
	@FindBy(xpath ="//div[@id='narrow-by-list']/div[3]/div[2]/ol/li[2]/a")
	private WebElement priceOption;
	
	@FindBy(xpath ="//span[text()='$50.00 - $59.99']")
	private WebElement selectedPriceOpt;
	
	@FindBy(xpath="//h1[@id=\"page-title-heading\"]//*[text()='Tops']")
	private WebElement wTopsText;
	
	@FindBy(xpath="//li[@class='item product product-item']")
	private List<WebElement> prodcount ;
	
	@FindBy(xpath="//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]")
	private WebElement showperpage;
//	
//	@FindBy(xpath ="//div[@class=\"toolbar toolbar-products\"][2]/div[4]/select")
	@FindBy(xpath ="//div[5]//div[3]//div[1]//select[1]")
	private WebElement showperpageDD;
	
	
	
	Select select;
	



	public void AddproductTOCartFromWomenDropdown() {
		Actions action = new Actions(driver);
		action.moveToElement(WomenBtn).perform();
		action.moveToElement(WTops).perform();
		action.moveToElement(WJackets).click().perform();
		Assert.assertTrue(jacketText.isDisplayed());
		utils.scrollBy(driver);
		action.moveToElement(OliviaJacket).perform();
		sizeOliveaJacket.click();
		BlackColorOliveaJacket.click();
		OliviaAtoC.click();
		utils.scrollToElement(driver, AddedToCartMsg);
		String AddedProdToCart = AddedToCartMsg.getText();
		Assert.assertTrue(AddedProdToCart.contains(AddedProdToCart));
		shoppingCart.click();

	}


	public void AddToCartMultipleProd() {
		Actions action = new Actions(driver);
		action.moveToElement(WomenBtn).perform();
		action.moveToElement(WTops).perform();
		action.moveToElement(WJackets).click().perform();
		Assert.assertTrue(jacketText.isDisplayed());
		utils.scrollBy(driver);
		action.moveToElement(OliviaJacket).perform();
		sizeOliveaJacket.click();
		BlackColorOliveaJacket.click();
		OliviaAtoC.click();
		utils.scrollToElement(driver, AddedToCartMsg);
		String AddedProdToCart = AddedToCartMsg.getText();
		Assert.assertTrue(AddedProdToCart.contains(AddedProdToCart));


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//		
		//2nd product
		action.moveToElement(JunoJacket).perform();
		JunoJacketSize.click();
		JunoJacketColor.click();
		JunoJacketAToCBtn.click();
		utils.scrollToElement(driver, AddedToCartMsg);
		String AddedProdToCart2 = AddedToCartMsg.getText();
		Assert.assertTrue(AddedProdToCart.contains(AddedProdToCart2));

		utils.ScrolltoTop(driver);
		minicart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		viewCart.click();
		driver.navigate().refresh();
		VerifyMultipleProdAddedInCart();

	}


	public void VerifyAddedProdInCart() {
		con = new Constants();

		//		System.out.println(actualQuantity);

		String actualTitle = OliviaTitle.getText();
		String actualSize = OliviaSize.getText();
		String actualColor = OliviaColor.getText();
		String actualPrice = OliviaPrice.getText();
		String actualQuantity =  OliviaQuantity.getAttribute("value");
		Assert.assertEquals(actualTitle,con.productName , "Title mismatch");
		Assert.assertEquals(actualSize,con.size , "Size mismatch");
		Assert.assertEquals(actualColor,con.color , "Color mismatch");
		Assert.assertEquals(actualPrice, con.price, "Price mismatch");
		Assert.assertEquals(actualQuantity, con.quantity, "Quantity mismatch");



	}

	public void VerifyMultipleProdAddedInCart() {
		VerifyAddedProdInCart();
		con = new Constants();
		String actualTitle = JunoJacketTitle.getText();
		String actualSize = JunoJacketsize.getText();
		String actualColor = JunoJacketcolor.getText();
		String actualPrice = JunoJacketprice.getText();
		String actualQuantity =  JunoJacketquantity.getAttribute("value");
		System.out.println(actualQuantity);

		Assert.assertEquals(actualTitle,con.productName2 , "Title mismatch");
		Assert.assertEquals(actualSize,con.size2 , "Size mismatch");
		Assert.assertEquals(actualColor,con.color2 , "Color mismatch");
		Assert.assertEquals(actualPrice, con.price2, "Price mismatch");
		Assert.assertEquals(actualQuantity, con.quantity2, "Quantity mismatch");
	}
	
	public void ShoppingOptions() {
		Actions action = new Actions(driver);
		action.moveToElement(WomenBtn).perform();
		action.moveToElement(WTops).perform();
		action.moveToElement(WJackets).click().perform();
		Assert.assertTrue(jacketText.isDisplayed());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)",priceShoppingOption);
		priceShoppingOption.click();
		priceOption.click();
		Assert.assertTrue(selectedPriceOpt.isDisplayed());
		
		
	}
	
	
	public void ShowperPageDD() {
		Actions action = new Actions(driver);
		action.moveToElement(WomenBtn).perform();
		action.moveToElement(WTops).click().perform();
		Assert.assertTrue(wTopsText.isDisplayed());
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].scrollIntoView(true)",showperpageDD);
		
		utils.scrollToElement(driver, showperpage);
		
		utils.waitForElementPresent(driver, showperpageDD, Duration.ofSeconds(3));
		select = new Select(showperpageDD);
		
		select.selectByVisibleText("36");
//		showperpageDD.sendKeys("36");
		
		int expProdcount = 36;
		
		int Actualcount = prodcount.size();
		
		Assert.assertEquals(expProdcount,Actualcount);

		
		
		
		
		
	}
	

}
