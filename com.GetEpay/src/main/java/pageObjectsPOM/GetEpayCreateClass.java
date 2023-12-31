 package pageObjectsPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
	@FindBy(xpath="//tbody/tr[1]/td[4]/div[1]/a[1]/i[1]")
	WebElement editClassbtn;
	@FindBy(xpath="//a[@id='updateCourse']")
	WebElement updateClassBtn;
	@FindBy(xpath="//body/div[@id='messageModal']/div[2]/div[1]/div[2]/strong[1]")
WebElement successMessage1;	
	@FindBy(xpath="//i[@class='fa fa-chevron-right']")
	WebElement nextPageArrow;
	@FindBy(xpath="//tbody/tr[10]/td[4]/div[1]/a[2]")
	WebElement deleteButton;
	@FindBy(xpath="//body/div[@id='messageModal']/div[2]/div[1]/div[1]")
	WebElement deletedPopup;
	@FindBy(xpath="//div[@aria-hidden='false']//div//div//div//strong[contains(text(),'Class Deleted Successfully')]")
	WebElement deleteSuccessMessage;
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
		public void clickEditClassBtn() {
			editClassbtn.click();
			Log.info("Edit class button is clicked");
			test= ExtentManager.test.info("Edit class button is clicked");
		}
		public void inpUpdatedClassName() {
			className.sendKeys("12T");
			Log.info("class name is updated");
			test=ExtentManager.test.info("class name is updated");
		
		}
		public void inpUpdatedClassDetails() {
			classDetails.sendKeys("we4");
			Log.info("Updated class details are provided");
			test= ExtentManager.test.info("Updated class details are probvided");
		}
	public void clickUpdateClassBtn() {
		 updateClassBtn.click();
		 Log.info("Update class button is clicked");
test= ExtentManager.test.info("Update class button is clicked");
	
	}
	public void verifyValidationPopup() throws InterruptedException {
	boolean status1 = validationPopup.isDisplayed();
	Assert.assertEquals(status1, true);
	Thread.sleep(3000);
	//Assert.assertEquals(status1, true);
	Log.info("Verification Popup is displayed");
	test= ExtentManager.test.info("Verification Popup is displayed");
	}
	public void verifyValidationMessage() {
		 boolean messageV = successMessage1.isDisplayed();
			Assert.assertEquals( messageV, true);
			Log.info("Update success message is displayed");
test=ExtentManager.test.log(Status.PASS,MarkupHelper.createLabel("Update success message is displayed",ExtentColor.GREEN))	;		
 String sMessage = successMessage1.getText();
 System.out.println(sMessage);
	}
	public void clickArrowNextage() {
		nextPageArrow.click();
		Log.info("Arrow is clicked");
		test= ExtentManager.test.info("Arrow ia clicked");
	}
	public void clickDeleteButton() {
		deleteButton.click();
		Log.info("Delete button is clicked");
		test= ExtentManager.test.info("Delete button is clicked");
				
	}
	public void verifyDeletedPopup() {
		boolean status2 = deletedPopup.isDisplayed();
		Assert.assertEquals(status2, true);
		Log.info("popup is displayed");
		test=ExtentManager.test.info("popup is displayed");
		
	}
	public void verifyDeleteValidationMessage() {
		 boolean deleteMessage= deleteSuccessMessage.isDisplayed();
			Assert.assertEquals(deleteMessage,true);
			Log.info("delete  success message popup  is displayed");
test=ExtentManager.test.log(Status.PASS,MarkupHelper.createLabel("Delete success message is displayed",ExtentColor.GREEN))	;		
String DMessage =deleteSuccessMessage.getText();
System.out.println(DMessage);
	}
	
	
	
	 
	}

