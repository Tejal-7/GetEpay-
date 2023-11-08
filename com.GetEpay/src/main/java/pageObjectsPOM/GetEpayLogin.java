package pageObjectsPOM;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import action.Action;
import baseClass.BaseClass;

import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class GetEpayLogin  extends BaseClass{
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager  manager;
	ListenersClass ls;
	//valid credentials
	String username1 ="supportespgetepay1@eshiksa.com";
	String password1="12345";
	//Invalid Credentials
	String username2= "suppo1@eshiksa.com";
	String password2="5678";
	//Declaration 
	@FindBy(xpath="//input[@id='user_email']")
	WebElement userName ;
	@FindBy(xpath="//input[@id='user_pass']")
	WebElement password;
	@FindBy(xpath="//input[@id='captcha']")
	WebElement captcha;
	@FindBy(xpath="//button[@class='btn  btn-primary btn-block']")
	WebElement loginBtn;
	
	
	
	
	
	
	public  GetEpayLogin () {
		PageFactory.initElements(driver, this);
	}
	public void inpUsernameandPass(String username1 , String password1) throws InterruptedException {
		 Action.type(userName, username1);
		 Log.info("usename is entered");
		 test = ExtentManager.test.info("Username Entered : " + username1);
Action.type(password, password1);
Log.info("password is entered ");
test= ExtentManager.test.info("password entered:" + password1);
String cap= JOptionPane.showInputDialog("enter captcha ");
captcha.sendKeys(cap);
Log.info("captcha is entered succesfully ");
test= ExtentManager.test.info("captcha entered ");
loginBtn.click();
Log.info("Logged in succesfully");
test = ExtentManager.test.info("login button is clicked");
	}
	public void loginWithInvalidCredentials(String username2, String password2) throws InterruptedException {
		 Action.type(userName, username2);
		 Log.info("usename is entered");
		 test = ExtentManager.test.info("Username Entered : " + username2);
Action.type(password, password2);
Log.info("password is entered ");
test= ExtentManager.test.info("password entered:" + password2);
String cap= JOptionPane.showInputDialog("enter captcha ");
captcha.sendKeys(cap);
Log.info("captcha is entered succesfully ");
Thread.sleep(2000);

test= ExtentManager.test.info("captcha entered ");
loginBtn.click();
Log.info("Logged in succesfully");
test = ExtentManager.test.info("login button is clicked");
	}
	public void loginWithValidUNAndInvalidPass(String username1, String password2) {
		 Action.type(userName, username1);
		 Log.info("username is entered");
		 test = ExtentManager.test.info("Username Entered : " + username1);
Action.type(password, password2);
Log.info("password is entered ");
test= ExtentManager.test.info("password entered:" + password2);
String cap= JOptionPane.showInputDialog("enter captcha ");
captcha.sendKeys(cap);
Log.info("captcha is entered succesfully ");
test= ExtentManager.test.info("captcha entered ");
loginBtn.click();
Log.info("Logged in succesfully");
test = ExtentManager.test.info("login button is clicked");
	}
	public void loginWithinvalidUnAndValidPass(String username2, String password1) {
		 Action.type(userName, username2);
		 Log.info("username is entered");
		 test = ExtentManager.test.info("Username Entered : " + username2);
Action.type(password, password1);
Log.info("password is entered ");
test= ExtentManager.test.info("password entered:" + password1);
String cap= JOptionPane.showInputDialog("enter captcha ");
captcha.sendKeys(cap);
Log.info("captcha is entered succesfully ");
test= ExtentManager.test.info("captcha entered ");
loginBtn.click();
Log.info("Logged in succesfully");
test = ExtentManager.test.info("login button is clicked");
	}
	}

