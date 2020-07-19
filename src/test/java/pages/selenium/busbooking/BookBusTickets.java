package pages.selenium.busbooking;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import base_Components.BasePage;

public class BookBusTickets extends BasePage{

	public BookBusTickets(EventFiringWebDriver driver, ExtentTest test) {	
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}

	// objects for bus booking home page 

	@FindBy(id="txtOrigin")
	private  WebElement  depart;
	public BookBusTickets selestdepart() {
		click(depart);
		return this;
	}

	@FindBy(xpath="(//div[@class='select2-result-label'])[2]")
	private WebElement  source;
	
	// select source
	public BookBusTickets selectSource(String start) {
		type(depart,start);
		click(source);
		return this;
	}

	@FindBy(id="txtDestination")
	private WebElement arriveTo;
	
	// select destination
	public BookBusTickets selectDestination(String dest) {
		type(arriveTo , dest);
		click(source);
		return this;
	}


	@FindBy(id="ContentPlaceHolder1_txtDepartDate")
	private WebElement txtDepartDate;
	@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-e']")
	private WebElement nextmonthselector;

	@FindBy(xpath="//table[@class='ui-datepicker-calendar']/tbody[1]/tr[4]/td[5]/a[1]")
	private  WebElement  selectdate;
	

	public BookBusTickets selectdate() {
		click(txtDepartDate);
		click(nextmonthselector);
		click(selectdate);
		return this;
	}
	
	
	//book now  
	@FindBy(id="btnBusSearchNew")
	private WebElement booknow;
	public BookingPage clickbooknow() {
		click(booknow);
		return new BookingPage (driver,test);
		
} 

	

}
