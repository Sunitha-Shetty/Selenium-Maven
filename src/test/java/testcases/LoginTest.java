package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass{
	
	@Test 	
	public void LoginFailureTest()
	{
		
		test = report.startTest("LoginFailureTest");
				LoginPage login = new LoginPage();
				login.LoginFunction("Java_Sel@gmail.com", "Abc@2021");
				
				WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
				
				String ActualMsg = ErrorMsg.getText();
				String ExpMsg= "The email or password you have entered is invalid.";
				
				AssertJUnit.assertEquals(ActualMsg, ExpMsg);
		
		report.endTest(test);
	}	
	
	@Test 	
	public void LoginSuccessTest()
	{
		
		test = report.startTest("LoginFailureTest");
		LoginPage login = new LoginPage();
		login.LoginFunction("Test_Selenium2022@gmail.com", "xyz@2021");
		report.endTest(test);	
		
	}	
	
	
	@Test (enabled = false)
	@Parameters({"Param1", "Param2"})	
	public void ParameterizedTest(String UserNameVal, String PasswordVal)
	{
		
		test = report.startTest("LoginFailureTest");
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal, PasswordVal);
		report.endTest(test);		
		
	}
	
	@Test
	public void ExternalDataTest()
	{

		test = report.startTest("LoginFailureTest");
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal,PasswordVal);		
		report.endTest(test);
		
	}
	

}
