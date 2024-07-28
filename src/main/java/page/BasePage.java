package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage {
	
	public void validateElement(WebElement element, String expectedText, String errorMessage) {
		Assert.assertEquals(element.getText(), expectedText, errorMessage);
	}
	
	public void selectVisibleFromDropDown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public String randomEmailNum() {
		Random rand = new Random();
		String emailNum = "" + rand.nextInt(10000);
		return emailNum;
	}
	
	public String randomPhoneNum() {
		Random rand = new Random();
		String phoneNum = "";
		for(int i = 0; i < 10; i++) {
			phoneNum = phoneNum + rand.nextInt();
		}
		return phoneNum;
	}
}
