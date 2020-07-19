package base_Components;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DataInputProvider;
import utilities.HTMLReporter;


public class BasePage extends WebDriverServiceImpl{

	public String dataSheetName;	

	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}

	@BeforeClass
	public void beforeMethod() throws FileNotFoundException, IOException{

		startTestCase(testCaseName, testDescription);	

		// Load the properties file
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));

		//for reports		
		startTestModule(nodes);
		test.assignAuthor(authors);
		test.assignCategory(category);
		HTMLReporter.svcTest = test;		

		// settings for launching browser

		// Start browser
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			webdriver = new ChromeDriver( );
		}
		
		else if ((prop.getProperty("browser").equalsIgnoreCase("firefox"))) {
			WebDriverManager.firefoxdriver().setup();
			webdriver = new FirefoxDriver();
		}
		 
		else if ((prop.getProperty("browser").equalsIgnoreCase("ie"))) {
			WebDriverManager.iedriver().setup();
			webdriver = new InternetExplorerDriver();
		}
		
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);
		driver.manage().window().maximize();
		driver.get("https://"+prop.getProperty("server"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
	closeActiveBrowser();
	}


	@AfterMethod
	public void afterMethod() {

	}

	@AfterSuite
	public void afterSuite() {
		endResult();
	}

	@DataProvider(name="fetchData", indices= {0})
	public  Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}	



}
