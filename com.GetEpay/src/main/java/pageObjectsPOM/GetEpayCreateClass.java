package pageObjectsPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import action.Action;
import baseClass.BaseClass;
import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class GetEpayCreateClass  extends BaseClass{
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager  manager;
	ListenersClass ls;
	Faker fake;
//	int length=10;
	//Faker fake = new Faker();
//return fake.lorem().characters(length);
	
	@FindBy(xpath="(//i[@class='fa fa-angle-left sidebar-nav-indicator'])[4]")
	WebElement class1;
	@FindBy(xpath="//a[normalize-space()='Manage Class']")
	WebElement manageClass;
	@FindBy(xpath="//strong[normalize-space()='Add Class']")
	WebElement addClass;
	@FindBy(xpath="//input[@id='coursename']")
	WebElement className;
	@FindBy(xpath="//input[@id='coursedetails']")
	WebElement classDetails;
	@FindBy(xpath="//a[@id='insertCourse']")
	WebElement addClassBtn;
	@FindBy(xpath="(//div[@class='modal-content'])[1]")
	WebElement validationPopup;
	@FindBy(xpath="(//strong[text()='Class Added Successfully'])[1]")
	WebElement validationMessage;
	
	public GetEpayCreateClass() {
		PageFactory.initElements(driver,this);
	}
	public void clickClass() {
		 class1.click();
		 Log.info("class is clicked");
		 test= ExtentManager.test.info("click is performed");
	}
	public void clickManageClass() {
		manageClass.click();
		Log.info("Manage class is clicked ");
		test= ExtentManager.test.info("click is performed");
	}
	public void clickAddClass() throws InterruptedException {
		 addClass.click();
		 Log.info("add class is clicked ");
		 test= ExtentManager.test.info("click on add class is performed ");
		 Thread.sleep(3000);
	}
	public void inpClassName() throws InterruptedException {
		fake = new Faker();
		 String name = fake.name().firstName();
		Action.moveToElement(driver, addClass);
		className.sendKeys(name);
		 Log.info("Class name is provided ");
		 test=ExtentManager.test.info("Class name is provided ");
		 Thread.sleep(2000);
		 }
	public void inpClassDetails()
	{
		fake= new Faker();
		 String details = fake.name().firstName();
		Action.moveToElement(driver, classDetails);
		classDetails.sendKeys(details);
		Log.info("Class details are provided ");
		test= ExtentManager.test.info("Class details are provided");
	}
	public void clickAddClassBtn() {
		addClassBtn.click();
		Log.info("Add class is clicked");
		test= ExtentManager.test.info("Add class is clicked");
	}
	public void verifyValidation() {
		boolean status = validationPopup.isDisplayed();
		Assert.assertEquals(status , true);
		Log.info("success message is displayed");
		String msg= validationMessage .getText();
		System.out.println(msg);
		Assert.assertEquals(msg ,"Class Added Successfully");
	
		}
		
	}

