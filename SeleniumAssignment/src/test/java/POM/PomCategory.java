package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WaitUtility.WaitUtility;
import webDriverUtility.WebDriverActions;

public class PomCategory {

	WebDriver driver;
	WaitUtility wait;
	WebDriverActions action;

	public PomCategory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtility(driver);
		action = new WebDriverActions(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[9]/a/span")
	public WebElement category;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button/i")
	public WebElement addCategoryBtn;
	
	@FindBy(xpath = "//*[@id=\"name\"]")
	public WebElement categoryName;
	
	@FindBy(xpath = "//*[@id=\"short_code\"]")
	public WebElement categoryCode;
	
	@FindBy(xpath = "//*[@id=\"category_add_form\"]/div[3]/button[1]")
	public WebElement categorySaveBtn;
	
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
	public WebElement categorySaveConfirmation;
	
	public void categoryUi() {
		action.click(category);
	}
	
	public void addCategory() {
		action.click(addCategoryBtn);
	}
	
	public void categoryNameSendkeys(String expectedValue) {
		action.sendkeys(categoryName, expectedValue);
	}
	
	public void categoryCodeSendkeys(String expectedValue) {
		action.sendkeys(categoryCode, expectedValue);
	}
	
	public void categorySave() {
		action.click(categorySaveBtn);
	}
	
	public String getTextCategoryAdd() {
		String text = action.getText(categorySaveConfirmation);
		return text;
	}

}
