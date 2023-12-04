package pageObjectsPOM;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import baseClass.BaseClass;
import utility.ExtentManager;
import utility.ListenersClass;
import utility.Log;

public class GetEpayAddNewSubject extends BaseClass{
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager  manager;
	ListenersClass ls;
	Faker fake;
Random random;
	@FindBy(xpath="(//i[@class='fa fa-angle-left sidebar-nav-indicator'])[4]")
	WebElement class1;
	@FindBy(xpath="//a[normalize-space()='Subject List']")
	WebElement subjectList;
	@FindBy(xpath="//strong[normalize-space()='Add Subject']")
	WebElement addSubject;
	@FindBy(xpath="//input[@id='subjectname']")
	WebElement subjectName;
	@FindBy(xpath="//input[@id='subjectcode']")
	WebElement SubjectCode;
	@FindBy(xpath="//input[@id='sequence']")
	WebElement subjectSequence;
	@FindBy(xpath="//input[@value='Add Subject']")
	WebElement addSubjectBtn;
	@FindBy(xpath="(//div[@class='modal-content'])[1]")
	WebElement  SuccessPopUp;
	@FindBy(xpath="//strong[text()='Subject Added Successfully']")
	WebElement SuccessMessage;
	public GetEpayAddNewSubject() {
	PageFactory.initElements(driver, this);	
	}
	public void clickClass() {
		class1.click();
		Log.info("Class is clicked succesfully");
	test= ExtentManager.test.info("Class is clicked succesfully");
	
	}
	public void clickSubjectList() {
		subjectList.click();
		Log.info("Subject list is clicked successsfully");
		test=ExtentManager.test.info("Subject list is clicked successsfully");
	}
	public void clickAddSubject() {
		 addSubject.click();
		 Log.info("Add Subject is clicked succesfully");
		 test = ExtentManager.test.info("Add Subject is clicked succesfully");
	}
	public void inputSubjectName() {
		fake = new Faker();
		String fakeSubject= fake.educator().course();
		subjectName.sendKeys(fakeSubject);
		Log.info("Subject Name is entered succesfully");
		test= ExtentManager.test.info("Subject Name is entered succesfully");
		String sub= subjectName.getText();
		System.out.println(sub);
	
	}
	public void inpSubjectCode() {
random = new Random();
fake = new Faker();
  int randomNo = fake.number().numberBetween(0, 99);
		  SubjectCode.sendKeys(String.valueOf( randomNo));
		  Log.info("Subject code is entered succesfully");
		  test= ExtentManager.test.info("Subject code is entered succesfully");
	}
	public void inpSubjectSequence() {
		subjectSequence.sendKeys("one");
		Log.info("Subject sequence is entered succesfully");
		test=ExtentManager.test.info("Subject sequence is entered succesfully");
	}
	public void clickAddSubBtn() {
		addSubjectBtn.click();
		Log.info("Add subject button is clicked succesfully");
		test= ExtentManager.test.info("Add subject button is clicked succesfully");
	}
	public void verifySuccessPopup() {	
		 boolean sucPop = SuccessPopUp.isDisplayed();
		 Assert.assertEquals(sucPop, true);
		 Log.info("Success popup on adding new subject is displayed");
		 test = ExtentManager.test.info("Success popup on adding new subject is displayed");
	}
	public void verifySuccessMessage () {
		boolean successMsg = SuccessMessage.isDisplayed();
		Assert.assertEquals(successMsg, true);
		String msg=  SuccessMessage.getText();
		System.out.println(msg);
		Log.info("Success message on adding new subject is displayed:"+ msg);
		test= ExtentManager.test.info("Success message on adding new subject is displayed:"+ msg);
	}
	
	///////////////////////////////update subject /////////////////////////////////////
	
}
