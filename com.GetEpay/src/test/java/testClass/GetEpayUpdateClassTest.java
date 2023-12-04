package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import baseClass.BaseClass;
import pageObjectsPOM.GetEpayCreateClass;
import pageObjectsPOM.GetEpayLogin;
import utility.ExtentManager;
import utility.ListenersClass;

public class GetEpayUpdateClassTest extends  BaseClass {
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	 GetEpayLogin log;
	 GetEpayCreateClass  updateClass;
	 String username = "supportespgetepay1@eshiksa.com";
	 String pass= "12345";
	 
	 @BeforeMethod
	 public void BeforeMethod() {
	 		 launchApp();
	 	 }
	 @Test
	 public void updateOldClass() throws InterruptedException {
		 log= new  GetEpayLogin ();
		  updateClass = new GetEpayCreateClass();
		  log.inpUsernameandPass(username, pass);
		  updateClass .clickClass();
		  updateClass.clickManageClass();
		  updateClass.clickEditClassBtn();
		  updateClass.inpUpdatedClassName();
		  updateClass.inpUpdatedClassDetails();
		  updateClass.clickUpdateClassBtn();
		  updateClass.verifyValidationPopup();
		  updateClass.verifyValidationMessage();
}
	 
	 @AfterMethod
	 public void tearDown() {
	 	driver.quit();
	 }
}