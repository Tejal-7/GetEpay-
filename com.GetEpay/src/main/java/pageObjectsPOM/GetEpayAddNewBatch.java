package pageObjectsPOM;

import java.text.SimpleDateFormat;
import java.util.Date;

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

public class GetEpayAddNewBatch extends BaseClass {
	SoftAssert asert = new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
	ExtentManager  manager;
	ListenersClass ls;
	Faker fake;
	
	@FindBy(xpath="(//i[@class='fa fa-angle-left sidebar-nav-indicator'])[4]")
	WebElement class1;
	@FindBy(xpath="//a[normalize-space()='Manage Batches']")
	WebElement manageBatches; 
	@FindBy(xpath="//strong[normalize-space()='Add Batch']")
	WebElement addBatchBtn;
	@FindBy(xpath="//span[normalize-space()='Select Class']")
	WebElement selectClass;
	@FindBy(xpath="//select[@id='course_id']")
	WebElement selectClass1;
	@FindBy(xpath="//div[@class='container-fluid main-content']")
	WebElement className;
	@FindBy(xpath="//input[@id='batchname']")
	WebElement batchName;
	@FindBy(xpath="//input[@id='dpd1']")
	WebElement startDate;
	@FindBy(xpath="//input[@id='dpd2']")
	WebElement endDate;
	@FindBy(xpath="//a[@id='insertBatch']")
	WebElement addBatch;
	@FindBy(xpath="//body/div[@id='messageModal']/div[2]/div[1]/div[2]")
	WebElement validationPopup;
	@FindBy(xpath="//div[@aria-hidden='false']//div//div//div//strong[contains(text(),'Batch added successfully')]")
	WebElement verificationMesaage;
	@FindBy(xpath="//table[@id='batch-datatable']")
	WebElement webTableBatches;
	
	@FindBy(xpath="//tbody/tr[5]/td[7]/div[1]/a[1]/i[1]")
	WebElement editBatchBtn;
	@FindBy(xpath="//a[@id='updateBatch']")
	WebElement updateBatchBtn;
	@FindBy(xpath="(//div[@class='modal-content'])[1]")
	WebElement updatePopup;
	@FindBy(xpath="(//strong[text()='Batch updated successfully'])[1]")
	WebElement updateSuccessMsg;
	@FindBy(xpath="//tbody/tr[4]/td[7]/div[1]/a[2]")
	WebElement deleteButton;
	@FindBy(xpath="//body/div[@id='messageModal']/div[2]/div[1]/div[1]")
	WebElement deletePopup;
	@FindBy(xpath="//body/div[@id='messageModal']/div[2]/div[1]/div[2]/strong[1]")
	WebElement deleteMessage;
	/*int rowIndex= 5;
	int ColIndex=7;

	@FindBy(xpath="//tbody/tr[" + rowIndex + "]/td[" + ColIndex + "]/div[1]/a[1]/i[1]")
	WebElement editBatchwithWT;*/
	
public GetEpayAddNewBatch() {
	PageFactory.initElements(driver,this);
}
public void clickClass() {	
	class1.click();
	Log.info("Class is clicked succesfully");
test= ExtentManager.test.info("Class is clicked succesfully");
}
public void clickManageBatches() {
	manageBatches.click();
	Log.info("Manage batches is clicked successfully");
test= ExtentManager.test.info("Manage batches is clicked succesfully");
}
public void clickAddBatch() {
	addBatchBtn.click();
	Log.info("Add batch is clicked succesfully");
	test= ExtentManager.test.info("Add batch is clicked succesfully");
}
public void clickselectClass() {
	selectClass.click();
	Log.info("Select class is clikced succesfully");
	test= ExtentManager.test.info("Select class is clikced succesfully");
}
public void selectClassFromDropDown() {
	 className.click();
	 Log.info("Class is selected succesfully");
	 test= ExtentManager.test.info("Class is selected succesfully");
}
public void inputBatchName() {
	fake = new Faker ();
	String name= fake.name().firstName();
	 batchName.sendKeys(name);
	 Log.info("batch name is entered succesfully:"+ name);
	 test= ExtentManager.test.info("batch name is entered succesfully:"+ name);
}
public void inpStartDate() {
	fake = new Faker ();
	Date fakeDate = fake.date().birthday();
	SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
	String formattaedDate = sdf.format(fakeDate);
	 startDate.sendKeys(formattaedDate);
	 Log.info("start date is entered succesfully");
	 test = ExtentManager.test.info("start date is entered succesfully");
}
public void inpEndDate() throws InterruptedException {
	fake = new Faker ();
	Date fakeDate1 = fake.date().birthday();
	SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");
	String date2=sdf1.format(fakeDate1);
	endDate.sendKeys(date2);
	Thread.sleep(4000);
	Log.info("End Date is entered succesfully");
	test= ExtentManager.test.info("End Date is entered succesfully");
}
public void clickAddBatchBtn() {
	addBatch.click();
	Log.info("Add batch button is clicked succesfully");
	test= ExtentManager.test.info("Add batch button is clicked succesfully");
}
public void verifyPopup() {
	 boolean status = validationPopup.isDisplayed();
	 Assert.assertEquals(status,true);
	 Log.info("validation popup is displayed");
	 test= ExtentManager.test.info("Validation popup is displayed");
	
}
public void verifyValidationMessage() {
	boolean succesmsg = verificationMesaage.isDisplayed();
	Assert.assertEquals(succesmsg,true);
String smsg= verificationMesaage.getText();
System.out.println(smsg);
	Log.info("success message is displayed:"+smsg);
	test= ExtentManager.test.log(Status.PASS,MarkupHelper.createLabel("Success message is displayed:"+ smsg,ExtentColor.GREEN));
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////edit Batch//////////////

public void clickEditBatchBtn() {
	
	editBatchBtn.click();
	Log.info("Edit batch button is clicked succesfully");
	test= ExtentManager.test.info("Edit batch button is clicked succesfully");
	 batchName.sendKeys("updated ");
	 Log.info("updated baatch name is provided");
	 test=ExtentManager.test.info("updated baatch name is provided");
	 
}
public void clickUpdateBatch() {
	updateBatchBtn.click();
	Log.info("Update batch button is clicked succesfully");
	test= ExtentManager.test.info("Update batch button is clicked succesfully");
	
}
public void verifyUpadteSuccesspopup() throws InterruptedException {
	Thread.sleep(1000);
	 boolean updpopup = updatePopup.isDisplayed();
	 try {
	Assert.assertEquals(updpopup, true);
	Log.info("Update verification popup is displayed");
	test= ExtentManager.test.info("Update verification popup is displayed");}
	 catch (Exception e) {
		 e.getMessage();
	 }
}
public void verifyUpdateSuccessMessage() {
boolean upMsg = updateSuccessMsg.isDisplayed();
	//Assert.assertEquals(upMsg, true);
String updatedMsg=updateSuccessMsg.getText();
System.out.println(updatedMsg);
Log.info("Success message on updating batch is displayed:"+upMsg);
test= ExtentManager.test.log(Status.PASS,MarkupHelper.createLabel("Success message on updating batch is displayed:" +upMsg,ExtentColor.GREEN));


}
///////////Delete Batch///////////////////////////////////////
public void deleteBatch() {
	Action.moveToElement(driver, deleteButton);
	 deleteButton.click();
	 Log.info("Delete batch button clicked succesfully");
	 test = ExtentManager.test.info("Delete batch button clicked succesfully");
}
public void verifyDeletePopup() {
	boolean deletePop= deletePopup.isDisplayed();
	try {
		Assert.assertEquals(deletePop, true);
		Log.info("Batch deleted succesfully popup is displayed");
		test= ExtentManager.test.info("Batch deleted succesfully popup is displayed");
	}
	catch(Exception e) {
		e.getMessage();
	}

}
public void verifyDeleteMessage() {
	boolean dltMsg = deleteMessage.isDisplayed();
	try {
	Assert.assertEquals(dltMsg,true);
	String dMsg=deleteMessage.getText();
	System.out.println(dMsg);
	Log.info("Batch deleted succesfully  Message is displayed:"+dltMsg );
	test= ExtentManager.test.log(Status.PASS, MarkupHelper.createLabel("Batch deleted succesfully  Message is displayed:"+dltMsg, ExtentColor.GREEN));
	}
	catch(Exception e) {
		e.getMessage();
	}
	
}
}





