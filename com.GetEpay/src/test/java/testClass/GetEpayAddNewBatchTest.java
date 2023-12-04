package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import baseClass.BaseClass;
import pageObjectsPOM.GetEpayAddNewBatch;
import pageObjectsPOM.GetEpayLogin;
import utility.ExtentManager;
import utility.ListenersClass;

public class GetEpayAddNewBatchTest extends BaseClass {
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	 GetEpayLogin log;
	 GetEpayAddNewBatch newBatch ;
	 String username = "supportespgetepay1@eshiksa.com";
	 String pass= "12345";
	 @BeforeMethod
	 public void BeforeMethod() {
	 		
	 		 launchApp();
	 	 }
	 @Test
	 public void addNewBatch() throws InterruptedException {
		 log= new  GetEpayLogin();
		 newBatch= new  GetEpayAddNewBatch  ();
		 log.inpUsernameandPass(username, pass);
		 newBatch.clickClass();
		 newBatch.clickManageBatches();
		 newBatch.clickAddBatch();
		 newBatch.clickselectClass();
		 newBatch.selectClassFromDropDown();
		 newBatch.inputBatchName();
		 newBatch.inpStartDate();
		 newBatch.inpEndDate();
		 newBatch.clickAddBatchBtn();
		 newBatch.verifyPopup();
		 newBatch.verifyValidationMessage();
	 }
	 
	 @AfterMethod
	 public void tearDown() {
	 	driver.quit();
	 }

	 
}
	 