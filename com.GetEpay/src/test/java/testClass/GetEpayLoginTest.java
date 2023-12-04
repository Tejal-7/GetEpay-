package testClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import baseClass.BaseClass;
import pageObjectsPOM.GetEpayLogin;
import utility.ExtentManager;
import utility.ListenersClass;


public class GetEpayLoginTest extends BaseClass{
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	 GetEpayLogin log;
		//valid credentials
		String username1 ="supportespgetepay1@eshiksa.com";
		String password1="12345";
		//Invalid Credentials
		String username2= "suppo1@eshiksa.com";
		String password2="5678";
	 @BeforeMethod
public void BeforeMethod() {
		// Action.implicitWait(driver, 5);
		 launchApp();
	 }
	 @Test 
	 public void login1() throws InterruptedException {
		 log=new GetEpayLogin();
		 log.inpUsernameandPass(username1, password1);
	 }
	 @Test public void login2() throws InterruptedException {
		 log=new GetEpayLogin();
		log.loginWithInvalidCredentials(username2, password2);
	 }
	 @Test
	 public void login3() throws InterruptedException {
		 log=new GetEpayLogin();
		 log.loginWithValidUNAndInvalidPass(username1, password2);
	 }
	 @Test
	 public void login4() throws InterruptedException {
		 log=new GetEpayLogin();
		 log.loginWithinvalidUnAndValidPass(username2, password1);
	 }
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
}
