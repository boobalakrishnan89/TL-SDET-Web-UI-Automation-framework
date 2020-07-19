package pages.selenium.busbooking;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import base_Components.BasePage;

public class PaymentPage extends BasePage{

	public PaymentPage(EventFiringWebDriver driver, ExtentTest test) {	
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="ContentPlaceHolder1_txtName")
	private WebElement fullName;
	public PaymentPage enterFullName() {
		type(fullName , "Mr.Kuala Lumpur");
		return this;
	}

	@FindBy(id="ContentPlaceHolder1_txtEmail")
	private WebElement mailid;
	public PaymentPage entermailid() {
		type(mailid , "abc@mail.com");
		return this;
	}
	@FindBy(id="ContentPlaceHolder1_txtPhone")
	private WebElement moblieNo;
	public PaymentPage enterMobileNo() {
		type(moblieNo , "9876543212");
		return this;
	}
	@FindBy(id="ContentPlaceHolder1_txtEmail1")
	private WebElement reEnterMail;
	public PaymentPage reEnterMail() {
		type(reEnterMail , "abc@mail.com");
		return this;
	}

	@FindBy(id="ContentPlaceHolder1_btnProceedPayment")
	private WebElement proceedtopayment;
	public PaymentPage proceedtoPayment()   {
		proceedtopayment.click();
		return this;
	}
	public PaymentPage verifyAlert() {
		acceptAlert();
		return this;
	}
}
