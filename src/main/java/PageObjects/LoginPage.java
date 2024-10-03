package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1 :  Create a class 
public class LoginPage {

	//Rule 4 : Constructor with same Webdriver refrence
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//Rule 2 : Find WebElement and making then private
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement user_edit;
	
	@FindBy(xpath="//input[@name='pwd']")
	private WebElement pass_edit;
	
	@FindBy(xpath="//input[@id='keepLoggedInCheckBox']")
	private WebElement chechk_box;
	
	@FindBy(xpath="//a[@id='loginButton']")
	private WebElement Login_Btn;
	
	//Generating Getter to use the WebElement

	public WebElement getUser_edit() {
		return user_edit;
	}

	public WebElement getPass_edit() {
		return pass_edit;
	}

	public WebElement getChechk_box() {
		return chechk_box;
	}

	public WebElement getLogin_Btn() {
		return Login_Btn;
	}
	
	//rule 5: Buisness logic 
	
	public void user_send(String username) {
		user_edit.sendKeys(username);
	}
	
	public void pass_send(String password) {
		pass_edit.sendKeys(password);
	}
	
	public void check_box_enable() {
		chechk_box.click();
	}
	
	public void login_Btn_click() {
		Login_Btn.click();
	}
}
