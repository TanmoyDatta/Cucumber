package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class DarazHomePage extends BasePage{
	public String HOME_PAGE_TITLE = "Online Shopping in Bangladesh: Order Now from Daraz.com.bd";
	public By SIGNUP_LOGIN_BUTTON = By.xpath("//a[contains(text(),'Signup / Login')]");
	public By LAGUAGE_CHANGE_OPTION = By.xpath("//*[@id='topActionSwitchLang']/span");
	
	public By SEARCH_FIELD = By.xpath("//*[@id=\"q\"]");
	public By SEARCH_BUTTON = By.xpath("//button[contains(text(),'SEARCH')]");
	
	public By ELECTRONIC_LAPTOP_ASUS = By.xpath("//span[normalize-space()='Asus Laptops']");
	

}
