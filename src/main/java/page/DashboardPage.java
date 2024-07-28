package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePage{

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	Element List
	@FindBy(how = How.XPATH, using = "//strong[text()='Dashboard']")
	WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[@href='#customers']")
	WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[@title='Add Customer']")
	WebElement ADD_CUSTOMER_MENU_ELEMENT;
	
	public void validateDashboardPage(String expectedText) {
		validateElement(DASHBOARD_HEADER_ELEMENT, expectedText, "Dashboard Page Not Found");
	}
	
	public void clickCustomerMenu() {
		CUSTOMER_MENU_ELEMENT.click();
	}
	
	public void clickAddCustomerMenu() {
		ADD_CUSTOMER_MENU_ELEMENT.click();
	}
}
