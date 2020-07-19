package tests.selenium;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base_Components.BasePage;
import pages.selenium.bestbuy.Landingpage;

 

public class BestBuyTest extends BasePage {

		@BeforeTest
		public void setValues() {

			testCaseName = "Delete all Purchase data  ";
			testDescription = "Delete all Purchase data for specfic user";
			nodes = "Recon/Matching";
			authors = "Boobala Krishnan";
			category = "UI ";
			dataSheetName = "deletepurchasedata";
		}
		
		
@Test
public void  scenario2 () {
	new  Landingpage (driver,test)
	.clickFlag()
	.clickClosePopup()
	.typeSearchText()
	.clickLaptopComputers()
	.getTotalitemcount()
	.clickHPBrand()
	.clickDelBrand()
	.verifySelectedBrands()
	.verifyselectedBrandItemCount()
	.sortPrice()
	.getreatingcount()
	.clickaddtocats()
	.clickcompare();
}
}
