package pages.selenium.busbooking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;

import base_Components.BasePage;

public class BookingPage  extends BasePage{

	public BookingPage(EventFiringWebDriver driver, ExtentTest test) {	
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	List<String> allBusPriceList = new ArrayList<String>(); 
	String lowestPrice;

	//bus price
	@FindBy (css =".bustr1" )
	private List<WebElement> allrows;

	public BookingPage  lowestprice() {
		int size = allrows.size();
		for( int i = 1 ; i<size;i++) {
			WebElement  price = driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr["+i+"]/td[5]/div[1]/div[2]"));	
			String priceCheck = price.getText();
			if(priceCheck.equals(lowestPrice)){ 
			WebElement  select = driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr["+i+"]/td[6]/a[1]"));
			waitForclickability(select);
			click(select);
			break;
			}
		}
		return this;
	}

	@FindBy (css =".busprice2" )
	private List<WebElement> allbusprices;

	public BookingPage  busprice() {
		
			int size = allbusprices.size();
			for (int i= 1; i<size ; i++) {
				String busprice = allbusprices.get(i).getText();
				allBusPriceList.add(busprice);
			}
			Collections.sort(allBusPriceList);
			lowestPrice = allBusPriceList.get(0);
		return this;
	}

	@FindBy (css =".seat_available" )
	private List<WebElement> seats;
	public BookingPage  selectseats() {
		if(seats.size()>=6){
			for(int i = 2 ; i<=7;i++) {
				seats.get(i).click();
			} }
		else if(seats.size()<6){
			seats.get(i).click();
		}
		return this;	
	}
	
	// seat quantity 
	@FindBy (css =".seat_qty" )
	private  WebElement  selectedSeats;
	public BookingPage  verifytheselectedSeats(String text) {
		verifyExactText(selectedSeats, text);
		return this;	
	}

	// click proceed 
	@FindBy (css =".seatproceed" )
	private  WebElement  proceed;

	public PaymentPage  clickproceed() {
		click(proceed);
		return new  PaymentPage(driver,test);	
	}
}
