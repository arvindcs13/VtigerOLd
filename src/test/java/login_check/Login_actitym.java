package login_check;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericUtility.BaseClass;
import PageObjects.HomPage;

@Listeners(GenericUtility.Listeners_code.class)
public class Login_actitym extends BaseClass{
	
	@Test(invocationCount=1)
	public void TC1() throws InterruptedException {
		HomPage hp = new HomPage(driver);
		wdu.expli_wait(driver, hp.getSwithtoactiplans());
		Thread.sleep(3000);
		String title="actiPLANS -  My Schedule12345";
		String actual_title = "Arvind";
		SoftAssert sfa = new SoftAssert();
		sfa.assertEquals(title, actual_title);
		sfa.assertAll();
	}

}
