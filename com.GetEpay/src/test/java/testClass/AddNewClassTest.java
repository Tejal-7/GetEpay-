package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import action.Action;
import baseClass.BaseClass;
import pageObjectsPOM.GetEpay;
import pageObjectsPOM.GetEpayCreateClass;
import pageObjectsPOM.GetEpayLogin;
import utility.ExtentManager;
import utility.ListenersClass;

public class AddNewClassTest  extends BaseClass{
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	 GetEpayCreateClass createClass;
	 GetEpay login;
	 String username = "supportespgetepay1@eshiksa.com";
	 String pass= "12345";
	 
	 @BeforeMethod
public void BeforeMethod() {
		// Action.implicitWait(driver, 5);
		 launchApp();
	 }
	 @Test
	 public void addnewClass() throws InterruptedException {
		 login= new  GetEpay ();
		 createClass= new  GetEpayCreateClass ();
		 login.inpUsernameandPass(username, pass);
		 
		 createClass.clickClass();
		 createClass.clickManageClass();
		createClass.clickAddClass();
		 createClass.inpClassName();
		 Thread.sleep(5000);
	
		createClass.inpClassDetails();
		 Thread.sleep(5000);
		 createClass.inpClassDetails();
		 //Thread.sleep(7000);
		 createClass.clickAddClassBtn();
		 Thread.sleep(3000);
		 createClass.verifyValidation();
		 
	 }
	 @AfterMethod
	 public void tearDown() {
	 	driver.quit();
	 }

}
