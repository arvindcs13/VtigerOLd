package login_check;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import PageObjects.HomPage;
import PageObjects.TaskNewCustomerPage;
import PageObjects.TaskPage;

@Listeners(GenericUtility.Listeners_code.class)
public class NewCustomerCreation extends BaseClass {
	
	//to check custmer name is ebnabled or not 
	@Test(priority=3)
	public void custmernameEnabledcheck() {
		HomPage hp = new HomPage(driver);
		hp.taskBtnclick();
		TaskPage tp = new TaskPage(driver);
		tp.addnewBtnclick();
		tp.NewCustomerBtnclick();
		TaskNewCustomerPage tncp = new TaskNewCustomerPage(driver);
		if(tncp.getCreatecustmrBtn().isEnabled()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		tncp.customerLightBoxCloseButtonclick();
	}

	
	@Test(priority=0)
	public void testcase1() throws Throwable {
		
		HomPage hp = new HomPage(driver);
		hp.taskBtnclick();
		TaskPage tp = new TaskPage(driver);
		tp.addnewBtnclick();
		tp.NewCustomerBtnclick();
		TaskNewCustomerPage tncp = new TaskNewCustomerPage(driver);
		String cus_name = pfr.getPropertydata("customer")+ju.genrateRandomNum();
		String desciption = pfr.getPropertydata("Description");
        tncp.custnrNameEdit1(cus_name);
        tncp.descrytionEdit1(desciption);
        tncp.CreatecustmrBtnclick();
		
	}
	
	
}
