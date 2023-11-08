package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObjectsPOM.GetEpay;
import pageObjectsPOM.GetEpayCreateOperationYear;

public class GertEpayAddNewOpereationYear extends BaseClass {
	 GetEpay login;
	 String username = "supportespgetepay1@eshiksa.com";
	 String pass= "12345";
	 GetEpayCreateOperationYear opYear;
	 @BeforeMethod
public void BeforeMethod() {
		// Action.implicitWait(driver, 5);
		 launchApp();
	 }
	 @Test 
	 public void addNewOpereationYear() throws InterruptedException {
		 login= new  GetEpay ();
		 login.inpUsernameandPass(username, pass);
		 opYear= new GetEpayCreateOperationYear();
		 opYear.clickSettingBtn();
		 opYear.clickOpereationYearSetting();
		 opYear.inpOpereationYear();
		 opYear.inpStartDate();
		 opYear.inpEndDate();
		 opYear.clickAddOpereationYear();
		 Thread.sleep(2000);
	 }
	 @AfterMethod
	 public void tearDown() {
	 	driver.quit();
	 }

}
