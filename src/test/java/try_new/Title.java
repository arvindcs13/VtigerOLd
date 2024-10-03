package try_new;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericUtility.BaseClass;

public class Title extends BaseClass {

	@Test(retryAnalyzer=GenericUtility.Retry.class) 
	 public void HomePagetitle() {
		
		
		String title_actual= driver.getTitle();
		String title_expected ="actiTIME -  Arvind Time-Track";
		
		//verifying titile 
		
		SoftAssert sfa = new SoftAssert();
		sfa.assertEquals(title_actual, title_expected);
		sfa.assertAll();

	 }
}
