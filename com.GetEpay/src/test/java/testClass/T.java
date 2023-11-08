package testClass;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class T extends BaseClass{
@BeforeMethod
public void a() {
	launchApp();
}
@Test 
public void test1() {
	driver.findElement(By.xpath("//input[@id='captcha]")).click();
}
@AfterMethod
public void tearDown() {
	
	driver.quit();
}
}
