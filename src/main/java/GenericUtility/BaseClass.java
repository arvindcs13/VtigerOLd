package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.HomPage;
import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	
/*
 * create object of other class(available in Generic Library)in Base class 
 * so that after extending only Base class to Test Script we can access all other class 
 */
	  
	   public JavaUtility ju = new JavaUtility();
	   public ExcelFileReader excel_data = new ExcelFileReader(); 
	   public PropertyFileReader pfr = new PropertyFileReader();
	   public WebDriverUtility  wdu = new WebDriverUtility();
	   
	   public WebDriver driver;
	   
	   @BeforeTest(alwaysRun=true)
	   public void launch_Browser() throws Throwable {
		   System.out.println("Choosing_____Browser");
		   
		   //Extracting browser name from properties file
		   String browser_config = pfr.getPropertydata("browser");
		   /*
		    * extracting application link from property file  
		    */
		   String web_link = pfr.getPropertydata("url");
		   /*
		    * Condition on browser selection 
		    */
		   if(browser_config.equals("chrome")) {
			   WebDriverManager.chromedriver().setup();
			   driver = new ChromeDriver();
			   
		   }
		   else if(browser_config.equalsIgnoreCase("firefox")) {
	    		WebDriverManager.firefoxdriver().setup();	 
	    		 driver=new FirefoxDriver();
	    	}
	    	else {
	    		System.out.println("....Invalid browser.....");
	    	}
		   wdu.imp_wait(driver);
	    	wdu.max_window(driver);
	   	
	    	driver.get(web_link);
	    	
	   }
	   
	   @BeforeMethod(alwaysRun=true)
	   public void login_Application() throws Throwable {                      //Logic for Application Login
		   String USER_login = pfr.getPropertydata("username");
		   String Pass_login = pfr.getPropertydata("password");
		   
		   LoginPage lp = new LoginPage(driver);
		   lp.user_send(USER_login);
		   lp.pass_send(Pass_login);
		   lp.login_Btn_click();
	   }
	   
	   @AfterMethod(alwaysRun=true)
	   public void logout_Application() {
		   System.out.println("...Log out from the application");
	    	HomPage hp=new HomPage(driver);
	    	hp.logOutBtnclick();
	   }
	   
	   @AfterClass(alwaysRun=true)
	   public void close_browser() {
		   System.out.println("Closing Browser.....!!!!!");
	   }
	   
	   public void getScreenshot() throws IOException {
	 		 Date current_date = new Date();
	 		 String screenshotfile = current_date.toString().replace(" ", "_").replace(":", "_");
	 		 File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 		 FileUtils.copyFile(srcfile, new File(".//screenshot//"+screenshotfile+".jpeg"));
	   }
}
