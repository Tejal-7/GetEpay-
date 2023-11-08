package pageObjectsPOM;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.Faker;

import action.Action;
import baseClass.BaseClass;

import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class GetEpayCreateOperationYear extends BaseClass{
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager  manager;
	ListenersClass ls;
	Faker fake;
	@FindBy(xpath="//i[@class='fa fa-angle-down']")
	WebElement SettingBtn;
	@FindBy(xpath="//a[normalize-space()='Change Password Setting']")
	WebElement opereationYearSetting;
	@FindBy(xpath="//input[@id='opyear']")
	WebElement opereationYear;
	@FindBy(xpath="//input[@id='startDate']")
	WebElement startDate;
	@FindBy(xpath="//input[@id='endDate']")
	WebElement endDate;
	@FindBy(xpath="//input[@id='insertOpYear']")
	WebElement  addOpereationYearb;
	
	
	public  GetEpayCreateOperationYear() {
		PageFactory.initElements(driver, this);
	}
	public void clickSettingBtn() {
		Action.moveToElement(driver, SettingBtn);
		SettingBtn.click();
		Log.info("Settings button is clicked");
		test= ExtentManager.test.info("Setting button is clicked");
	}
	public void clickOpereationYearSetting() {
		Action.moveToElement(driver, opereationYearSetting);
		opereationYearSetting.click();
		Log.info("Opereation year setting button is clicked");
		test=ExtentManager.test.info("opereation year setting  button is clicked");
	}
	public void inpOpereationYear() {
		fake = new Faker();
		//genrate random date 
		java.util.Date randomDate=fake.date().birthday();
		//extract year from date 
		SimpleDateFormat yearFormat= new SimpleDateFormat("yyyy");
		String year = yearFormat.format(randomDate);
//	String specialString = fake.regexify("[a-z A-Z 0-9 +(&^%E!@#$%^&*()]");
		opereationYear.sendKeys(year);
		Log.info("opereation year input is entered");
		test = ExtentManager.test.info("Opereation year input is entered");
	}
	public void inpStartDate() {
	fake = new Faker();
	java.util.Date randomDa = fake.date().birthday();
	SimpleDateFormat sd= new SimpleDateFormat("dd MM yyyy");
	String date1 = sd.format(randomDa);
	startDate.sendKeys(date1);
	Log.info("Staring date is entered succesfully");
	test= ExtentManager.test.info("Starting date is entered succesfully");
	
	}
	public void inpEndDate () {
		fake = new Faker();
		java.util.Date randomDa = fake.date().birthday();
		SimpleDateFormat sd= new SimpleDateFormat("dd MM yyyy");
		String date2 = sd.format(randomDa);	
		endDate.sendKeys(date2);
		Log.info("end date is entered succesfully");
		test= ExtentManager.test.info("end date is entered succesfully");

	}
	public void clickAddOpereationYear() {
		addOpereationYearb.click();
		Log.info("Add Opereation year button clicked ");
		test =ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Add opereation year button is clicked succesfully", ExtentColor.GREEN));	
	}
}
