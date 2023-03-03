package pages;

import org.openqa.selenium.By;

public class DarazLoginPage extends BasePage{
	public String LOGIN_PAGE_URL = "https://member.daraz.com.bd/user/login";
	public By EMAIL_PHONE_INPUT = By.xpath("//input[@placeholder='Please enter your Phone Number or Email']");
	public By PASSWORD_INPUT = By.xpath("//input[@placeholder='Please enter your password']");
	public By LOGIN = By.xpath("//button[normalize-space()='LOGIN']");
	public By ERORR_MASSAGE = By.xpath("//div[@class='next-feedback-content']");
	public String LOGIN_ERORR_MASSAGE = "Please enter a valid phone number.";
	public String LOGIN_PAGE_TITLE ="Daraz.com.bd: Online Shopping Bangladesh - Mobiles, Tablets, Home Appliances, TV, Audio &amp; More";

	public By ERORR_MASSAGE2 = By.xpath("//div[@class='next-feedback-content']");
	public String LOGIN_ERORR_MASSAGE2 = "Incorrect username or password.";
			
	public void doLogin(String userName, String password) {
		writeTextOnElement(EMAIL_PHONE_INPUT,userName);
		writeTextOnElement(PASSWORD_INPUT,password);
		clickOnElement(LOGIN);
	}
	// erorr masasge method
	public String getErrorMassage() {
	   return getElementText(ERORR_MASSAGE);
		
	}
//	public String getErrorMassage2() {
//		return getElementText(ERORR_MASSAGE2);
//	
//	}
	
}
