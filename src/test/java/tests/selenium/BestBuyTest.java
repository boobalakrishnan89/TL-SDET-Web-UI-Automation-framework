package tests.selenium;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base_Components.BasePage;
import pages.selenium.bestbuy.Landingpage;

 

public class BestBuyTest extends BasePage {

		@BeforeTest
		public void setValues() {

			testCaseName = "  ";
			testDescription = " ";
			nodes = " ";
			authors = "Boobala Krishnan";
			category = "UI ";
			dataSheetName = "";
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
