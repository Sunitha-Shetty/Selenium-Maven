package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	
public static WebDriver driver;

XSSFWorkbook wbook;
XSSFSheet sheet;

public static ExtentReports report;
public static ExtentTest test;


@BeforeTest
public void DataSetUP() throws IOException {
	
	FileInputStream fis = new FileInputStream("exceldata.xlsx");
	wbook = new XSSFWorkbook(fis);
	sheet = wbook.getSheet("Sheet1");	
	
	report = new ExtentReports("ExtentReport.html");
	
}

@AfterTest
public void DataTearDown() throws IOException {
	
	wbook.close();
	report.flush();
	report.close();
	
}
	
	
	@BeforeMethod
	public void SetUp()
	{
		//Chrome Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		//Firefox Driver
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		//Creating instance of a Chrome browser		
		driver = new ChromeDriver();
		
		//	driver = new FirefoxDriver();
		
		driver.get("https://www.simplilearn.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.close();	
		
	}

}