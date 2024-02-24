package com.Insurance.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarPage extends BasePage {

	public CarPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[2]/section/div[4]/a")
	WebElement carlogo;

	@FindBy(xpath = "//a[@class='btn-proceed']")
	WebElement buycar;

	@FindBy(xpath = "//span[@id='spn2']")
	WebElement city;

	@FindBy(xpath = "//span[normalize-space()='DL12']")
	WebElement RegNo;

	@FindBy(xpath = "//span[contains(@class,'honda')]")
	WebElement carCompany;

	@FindBy(xpath = "//b[normalize-space()='CIVIC HYBRID']")
	WebElement carModel;

	@FindBy(xpath = "//input[@id='name']")
	WebElement pName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement pEmail;

	@FindBy(xpath = "//input[@id='mobileNo']")
	WebElement mobile;

	@FindBy(xpath = "//button[@id='btnLeadDetails']")
	WebElement viewPrice;

	@FindBy(xpath = "//*[@id='dvVariant']/div[2]/div[1]/div[2]/div[2]")
	WebElement emailMsg;

	@FindBy(xpath = "//*[@id='dvVariant']/div[2]/div[1]/div[3]/div[2]")
	WebElement moMsg;

	@FindBy(xpath = "//button[@id='btnGetQuotes']")
	WebElement price;

	@FindBy(xpath = "//span[@id='error_car_number']")
	WebElement errormsg;

	public void getCarInsurance() {
		carlogo.click();
		buycar.click();

	}

	public void getCity() {
		city.click();
		// selecting dlno
		RegNo.click();

	}

	public void getCompanyModel() {
		// selecting car company
		carCompany.click();
		// selecting car model
		carModel.click();

	}

	public void setDetails() {
		// Entering name
		pName.sendKeys("Deepanshu");
		// Entering invalid email
		pEmail.sendKeys("abc@123");
		// entering invalid number
		mobile.sendKeys("8899689");
		// clicking on view prices
		viewPrice.click();

	}

	public void captureMSG() {

		System.out.println(emailMsg.getText());
		// capturing phone msg
		System.out.println(moMsg.getText());

	}

	public void getPrice() {
		carlogo.click();
		price.click();

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

	public void setName(String string) {
		pName.sendKeys(string);

	}

	public void setInfo(String string, String string2) {
		// Entering invalid email
		pEmail.sendKeys(string);
		// entering invalid number
		mobile.sendKeys(string2);
		// clicking on view prices
		viewPrice.click();

	}

	public void getPage() {
		driver.get("https://ci.policybazaar.com/questions?ishome=true&isnew=true&utm_content=home_v11");

	}

	public void buyCar() {
		buycar.click();

	}

}
