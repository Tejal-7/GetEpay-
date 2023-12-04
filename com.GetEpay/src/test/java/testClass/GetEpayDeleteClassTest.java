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

public class GetEpayDeleteClassTest extends BaseClass{
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	 GetEpayLogin log;
	 GetEpayCreateClass  deleteClass;
	 String username = "supportespgetepay1@eshiksa.com";
	 String pass= "12345";
	 
	 @BeforeMethod
	 public void BeforeMethod() {
	 		 launchApp();
	 	 }
	 @Test
	 public void deleteClass() throws InterruptedException {
		 log= new  GetEpayLogin ();
		 deleteClass = new GetEpayCreateClass();
		  log.inpUsernameandPass(username, pass);
		  deleteClass.clickClass();
		  deleteClass.clickManageClass();
		  deleteClass.clickArrowNextage();
		  deleteClass.clickDeleteButton();
		  deleteClass.verifyDeletedPopup();
		  deleteClass.verifyDeleteValidationMessage();
	 }
	 
	 @AfterMethod
	 public void tearDown() {
	 	driver.quit();
	 }
}
