package pages.selenium.bestbuy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base_Components.BasePage;

public class SearchPage   extends BasePage{

	public SearchPage(EventFiringWebDriver driver, ExtentTest test) {	
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	String brand1 ; 
	String brand2 ; 
	String item_count;
	
	List<String> allratecounts = new ArrayList<String>(); 
	// validating total count 	

	@FindBy(css=".item-count")
	private WebElement totalItemCount;
	public SearchPage  getTotalitemcount() {
		  item_count  = getText(totalItemCount);
		//verifyExactText(totalItemCount, "895 items"); 
		return this;
	}

	// click  HP and Del  brands

	@FindBy(xpath="(//span[@class='facet-option-label-text'])[1]")
	private WebElement brandHP;
	public SearchPage  clickHPBrand() {
		brand1 = getText(brandHP);
		click(brandHP);
		return this;
	}

	@FindBy(xpath="(//span[@class='facet-option-label-text'])[2]")
	private WebElement brandDel;
	public SearchPage  clickDelBrand() {
		brand2 = getText(brandDel);
		click(brandHP);
		return this;
	}
	// validating the selected brands


	@FindBy(xpath="(//button[@class='c-facet-button '])[1]")
	private WebElement brand1txt;
	public SearchPage  validateBrand1() {
		verifyExactText(brand1txt, brand1);
		return this;
	}	

	@FindBy(xpath="(//button[@class='c-facet-button '])[2]")
	private WebElement brand2txt;
	public SearchPage  validateBrand2() {
		verifyExactText(brand2txt, brand2);
		return this;
	}

	public SearchPage verifySelectedBrands() {
		validateBrand1();
		validateBrand2();
		return this;
	}
	
//validate reduced item count 
	public SearchPage verifyselectedBrandItemCount() {
		String filtered_item = getText(totalItemCount);
		 Assert.assertNotEquals(filtered_item, totalItemCount);
		return this;
	}
	
// choose price low to high 
	
	
	@FindBy(id="sort-by-select")
	private WebElement sortPrice;
	public SearchPage sortPrice() {
		selectDropDownUsingVisibleText(sortPrice, "Price Low to High");
		return this;
	}
	
//  find 4+ stars 
	
	@FindBy(xpath="(//i[contains(@class,'c-stars-v3 c-stars-v3-small')])")
	private List<WebElement>ratings;
	
	public SearchPage getreatingcount() {
	int size = 	ratings.size();
	for(int i = 1 ; i<=size; i++)
	{
		WebElement attrib = driver.findElement(By.xpath("(//i[contains(@class,'c-stars-v3 c-stars-v3-small')])["+i+"]"));
		String ratecount = getAttribute(attrib, "alt");
		if(ratecount.contains("4.")) {
			allratecounts.add(ratecount);
			System.out.println(allratecounts.size());
		}
	}
	
	return this;
		
	}
	@FindBy(xpath="(//button[contains(@class,'btn btn-primary')])")
	private List<WebElement>allAddtocarts;
	
	public SearchPage clickaddtocats() {
		
		for(int i = 1; i< allAddtocarts.size();i++){
			if(allAddtocarts.get(i).getText().equals("Add to Cart")) {
			WebElement compare = driver.findElement(By.xpath("(//label[text()='Compare'])["+i+"]"));
			click(compare);
			WebElement addtocart = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-primary')])["+i+"]"));
			click(addtocart);
			}
		}
		return null;
	}
	
// click confirm button  
	@FindBy(linkText = "Compare")
	private  WebElement compare;
	public ComparePage clickcompare() {
		click(compare);
		return new ComparePage(driver,test);
		
	}
}
