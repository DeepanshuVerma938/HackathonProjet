package com.Insurance.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SmokePage extends BasePage {

	public SmokePage(WebDriver driver) {
		super(driver);
	}

	String actualheading = "Login to my account";

	@FindBy(xpath = "//div[2]/section/div[14]/a")
	WebElement home;

	@FindBy(xpath = "//p[@class='title']")
	WebElement hometitle;

	@FindBy(xpath = "//div[2]/section/div[1]/a")
	WebElement umbrella;

	@FindBy(xpath = "//span[normalize-space()='Male']//i[@class='radio']")
	WebElement maleradio;

	@FindBy(xpath = "//div[2]/section/div[12]/a")
	WebElement retireplan;

	@FindBy(xpath = "//span[@class='brktext']")
	WebElement retireHeading;

	@FindBy(xpath = "//div[2]/section/div[11]/a")
	WebElement child;

	@FindBy(xpath = "//*[@id='wrapper']/div/div[2]/div[2]/div[1]/div[1]/b")
	WebElement childHeading;

	@FindBy(xpath = "//div[2]/section/div[6]/a")
	WebElement family;

	@FindBy(xpath = "//h1[@class='anim firstStep']")
	WebElement familyHeading;

	@FindBy(xpath = "//*[@id='txtCustomerName']")
	WebElement childName;

	@FindBy(xpath = "//*[@id='txtMobileNo']")
	WebElement childMo;

	@FindBy(xpath = "//button[normalize-space()='View Plans']")
	WebElement childPlan;

	@FindBy(xpath = "//p[@class='error ng-star-inserted']")
	WebElement retiretxt;

	@FindBy(xpath = "//*[@id='Fullname']")
	WebElement homeName;

	@FindBy(xpath = "//input[@name='MobileNo']")
	WebElement homeMo;

	@FindBy(xpath = "//span[@class='error']")
	WebElement hometxt;

	@FindBy(xpath = "//button[@class='pq-cta']")
	WebElement homeviewplan;

	public void homelogo() {
		home.click();
	}

	public void validateHomePage() {
		boolean flag = hometitle.isDisplayed();
		Assert.assertTrue(flag);
	}

	public void UmbrellaLogo() {
		umbrella.click();

	}

	public void validateTermPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[normalize-space()='Male']//i[@class='radio']")));
		boolean flag = maleradio.isEnabled();
		Assert.assertTrue(flag);
	}

	public void clickRetire() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/section/div[12]/a")));
		retireplan.click();

	}

	public void getRetirementPage() {
		boolean flag = retireHeading.isDisplayed();
		Assert.assertTrue(flag);

	}

	public void clickChild() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/section/div[11]/a")));
		child.click();

	}

	public void CheckChildPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div/div[2]/div[2]/div[1]/div[1]/b")));
		boolean flag = childHeading.isDisplayed();
		Assert.assertTrue(flag);
	}

	public void clickFamily() {
		family.click();

	}

	public void CheckFamilyPage() {
		boolean flag = familyHeading.isDisplayed();
		Assert.assertTrue(flag);

	}

	public void setNameMo() {
		childName.sendKeys("uiwuidi");
		childMo.sendKeys("9111111111");
	}

	public void childViewPlan() {

		boolean f = childPlan.isEnabled();
		Assert.assertTrue(!f);

	}

	public void getRetireError() {

		try {
			if (retiretxt.isDisplayed()) {
				System.out.println("Error--------");
				System.out.println(retiretxt.getText());
			}
		} catch (Exception e) {
			System.out.println("Text not displayed");
		}

	}

	public void setInvalidNameMo() {
		homeName.sendKeys("uiwuidi");
		homeMo.sendKeys("9111111111");

	}

	public void getHomeError() {
		try {
			if (hometxt.isDisplayed()) {
				System.out.println("Error--------");
				System.out.println(hometxt.getText());
			}
		} catch (Exception e) {
			System.out.println("Text not displayed");
		}
	}

	public void clickhomeplan() {
		homeviewplan.click();

	}

	public void homeplanpage() {
		boolean f = homeviewplan.isEnabled();
		Assert.assertTrue(!f);
	}

}
