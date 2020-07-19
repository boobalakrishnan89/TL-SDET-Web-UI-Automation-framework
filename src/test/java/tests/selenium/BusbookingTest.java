package tests.selenium;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base_Components.BasePage;
import pages.selenium.busbooking.BookBusTickets;

public class BusbookingTest	extends BasePage {



	@BeforeTest
	public void setValues() {

		testCaseName = " BusBooking  ";
		testDescription = "book bus tickets as per requirements ";
		nodes = " bus Booking ";
		authors = " BK";
		category = " UI";
		dataSheetName = "";
	}


	@Test
	public void  testdate() {

		new BookBusTickets(driver,test) 
		.selectdate()
		.selectSource("Cameron Highlands")
		.selectDestination("Kuala Lumpur")
		.clickbooknow()
		.busprice()
		.lowestprice() 
		.selectseats()
		.verifytheselectedSeats("6")
		.clickproceed()
		.enterFullName() 
		.enterMobileNo()
		.entermailid() 
		.reEnterMail()
		.proceedtoPayment()
		.verifyAlert();


	}
}
