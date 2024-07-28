package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage{

	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	Element List
	@FindBy(how = How.XPATH, using = "//strong[text()='New Customer']")
	WebElement ADD_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@name='company_name']")
	WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='save_btn']")
	WebElement SAVE_BUTTON_ELEMENT;
	
	public void validateAddCustomerPage(String expectedText) {
		validateElement(ADD_CUSTOMER_HEADER_ELEMENT, expectedText, "Add Customer Page Not Found");
	}
	
	public void insertFullName(String fullName) {
		FULL_NAME_ELEMENT.sendKeys(fullName);
	}
	
	public void selectCompanyDropDown(String visibleText) {
		selectVisibleFromDropDown(COMPANY_DROPDOWN_ELEMENT, visibleText);
	}
	
	public void insertEmail() {
		EMAIL_ELEMENT.sendKeys("demo" + randomEmailNum() + "@techfios.com");
	}
	
	public void insertPhoneNum() {
		PHONE_ELEMENT.sendKeys(randomPhoneNum());
	}
	
	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}
}
