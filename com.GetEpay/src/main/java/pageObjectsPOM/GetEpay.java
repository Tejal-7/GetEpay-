package pageObjectsPOM;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import utility.ExtentManager;
import action.Action;
import baseClass.BaseClass;
import utility.ListenersClass;
import utility.Log;

public class GetEpay extends BaseClass{
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager  manager;
	ListenersClass ls;
	//Declaration 
	
	@FindBy(xpath="//input[@id='user_email']")
	WebElement userName ;
	@FindBy(xpath="//input[@id='user_pass']")
	WebElement password;
	@FindBy(xpath="//input[@id='captcha']")
	WebElement captcha;
	@FindBy(xpath="//button[@class='btn  btn-primary btn-block']")
	WebElement loginBtn;
	
	public GetEpay() {
		PageFactory.initElements(driver, this);
	}
	//login with valid credentials 
	public void inpUsernameandPass(String un , String pawd) throws InterruptedException {
		 Action.type(userName, un);
		 Log.info("usename is entered");
		 test = ExtentManager.test.info("Username Entered : " + un);
Action.type(password, pawd);
Log.info("password is entered ");
test= ExtentManager.test.info("password entered:" + pawd);
String cap= JOptionPane.showInputDialog("enter captcha ");
captcha.sendKeys(cap);
Log.info("captcha is entered succesfully ");
test= ExtentManager.test.info("captcha entered ");
loginBtn.click();
Log.info("Logged in succesfully");
test = ExtentManager.test.info("login button is clicked");
	}

	
}
