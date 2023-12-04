package testClass;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import baseClass.BaseClass;
import pageObjectsPOM.GetEpayAddNewSubject;
import pageObjectsPOM.GetEpayLogin;
import utility.ExtentManager;
import utility.ListenersClass;

public class GetEpayAddNewSubjectTest extends BaseClass{
	ExtentReports extent;
	ExtentTest test;
	ExtentManager manager;
	ListenersClass ls;
	 GetEpayLogin log;
	 String username = "supportespgetepay1@eshiksa.com";
	 String pass= "12345";
	 GetEpayAddNewSubject subjects ;
	 @BeforeMethod
	 public void BeforeMethod() {
	 		
	 		 launchApp();
	 	 }
	 @Test
	 public void addSubject() throws InterruptedException {
		   log =new GetEpayLogin ();
			 log.inpUsernameandPass(username, pass);
        subjects= new GetEpayAddNewSubject(); 
        subjects.clickClass();
        subjects.clickSubjectList();
        subjects.clickAddSubject();
        subjects.inputSubjectName();
        subjects.inpSubjectCode();
	 subjects.inpSubjectSequence();
	 subjects.clickAddSubBtn();
	 subjects.verifySuccessPopup();
	 subjects.verifySuccessMessage();
	 }
	 
	 @AfterMethod
	 public void tearDown() {
	 	driver.quit();
	 }

}
