package com.Insurance.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegressionPage extends BasePage {

	public RegressionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[5]//a[1]//div[1]//div[1]")
	WebElement twoWheeler;

	@FindBy(xpath = "//input[@id='rto']")
	WebElement rtoInput;

	@FindBy(xpath = "//button[@value='Go']")
	WebElement viewprice;

	@FindBy(xpath = "//div[@id='error-msg']")
	WebElement txt;

	public void getTwoWheeler() {
		twoWheeler.click();

	}

	public void setNumber() {
		rtoInput.sendKeys("67-48-4874");
		viewprice.click();

	}

	public void captureMessage() {
		try {
			if (txt.isDisplayed()) {
				System.out.println("Error--------");
				System.out.println(txt.getText());
			}
		} catch (Exception e) {
			System.out.println("Entered number is valid");
		}

	}

}
