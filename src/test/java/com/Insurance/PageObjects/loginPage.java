package com.Insurance.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class loginPage extends BasePage {

	public loginPage(WebDriver driver) {
		super(driver);
	}

	String actualheading = "Login to my account";

	@FindBy(xpath = "//div[contains(@class,'col-xl-12 col-lg-12 col-md-12 col-sm-12')]//a[contains(text(),'Contact Us')]")
	WebElement contactus;

	@FindBy(xpath = "//a[@id='myacc-login-btn']")
	WebElement login;

	@FindBy(xpath = "//input[@id='mobileNo']")
	WebElement phoneInput;

	@FindBy(xpath = "//button[normalize-space()='LOGIN WITH OTP']")
	WebElement loginbtn;

	@FindBy(xpath = "//label[@class='error-message']")
	WebElement errormsg;

	public void scroll() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Payment Methods']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void getContactus() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", contactus);
		// contactus.click();

	}

	public void checkPage() {
		String expectedheading = login.getText();
		Assert.assertEquals(actualheading, expectedheading);
	}

	public void clickLogin() {
		login.click();

	}

	public void setPhoneNumber(String moNo) {
		phoneInput.sendKeys(moNo);
	}

	public void clickLoginBtn() {
		loginbtn.click();
	}

	public void getMessage() {
		try {
			if (errormsg.isDisplayed()) {
				System.out.println("Error--------");
				System.out.println(errormsg.getText());
			}
		} catch (Exception e) {
			System.out.println("Entered Number is Valid..");
		}
	}

}
