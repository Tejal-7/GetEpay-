package baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import action.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentManager;

public class BaseClass {
public static Properties prop;
public static WebDriver driver;


@BeforeSuite
public void loadConfig() throws IOException {
	ExtentManager.setExtent();
	DOMConfigurator.configure("log4j.xml");
	
	prop= new Properties();
	
	try {
		FileInputStream ip = new FileInputStream ("D:\\Eclipse Workspace\\com.GetEpay\\src\\test\\resources\\Configuration\\Config.properties");
		prop.load(ip);
		System.out.println(ip);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}
public void launchApp() {
	
	   ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       options.setAcceptInsecureCerts(true);
       options.addArguments("--ignore-certificate-errors");
		options.addArguments("--no-sandbox"); 
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		System.out.println("Launching Browsere"+ " "+ browserName);
	
		if (browserName.equalsIgnoreCase("Chrome")) {
			
			//WebDriverManager.chromedriver().setup();
//			WebDriverManager.chromedriver().browserVersion("116.0.5845.187").setup();
			
			driver = new ChromeDriver(options);
			
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
			
		} else if (browserName.equalsIgnoreCase("IE")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		Action.implicitWait(driver , 10);
		Action.pageLoadTimeOut(driver , 30);
		
		driver.get(prop.getProperty("url"));	
		
	}
	
		
	
@AfterSuite
public void aftersuite() {
	ExtentManager.endReport();
}

}
