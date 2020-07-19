package pages.selenium.bestbuy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import base_Components.BasePage;

public class Landingpage extends BasePage{

	public Landingpage(EventFiringWebDriver driver, ExtentTest test) {	
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	// choose US flag 
	@FindBy(xpath="(//img[@alt='United States'])[1]")
	private WebElement usFlag;
	public  Landingpage clickFlag() {
		click(usFlag);
		return this;
	}

	//close popup
	@FindBy(css=".c-close-icon ")
	private WebElement closepopup;
	public Landingpage  clickClosePopup() {
		//acceptAlert();
		waitForclickability(closepopup);
		click(closepopup);
		return this;
	}

	// enter search field
	@FindBy(css=".search-input")
	private WebElement searchField;
	public Landingpage  typeSearchText() {
		type(searchField,"Laptops");
		return this;
	}

	// select laptop computers 

	//(//span[@class=' '])[3]    (//li[@class='selected'])[4]

	@FindBy(xpath="(//span[@class=' '])[3]")
	private WebElement selectlaptop;
	public SearchPage  clickLaptopComputers() {
		click(selectlaptop);
		return new  SearchPage (driver,test) ;
	}


	
	
}
