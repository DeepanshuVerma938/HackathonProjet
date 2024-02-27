package com.Insurance.PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Insurance.utils.excelUtils;

public class HealthPage extends BasePage {

	public HealthPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Insurance Products']")
	WebElement insuranceproducts;

	@FindBy(xpath = "//a[@class='headlink'][normalize-space()='Health Insurance']")
	WebElement healthinsurance;

	@FindBy(xpath = "//label[@data-id='self']")
	WebElement self;

	@FindBy(xpath = "//div[@class='button btnHealthStep1']")
	WebElement continuebtn1;

	@FindBy(xpath = "//*[@id='name_feild']/select")
	WebElement ageinput;

	@FindBy(xpath = "//div[@class='button btnHealthStep2']")
	WebElement continuebtn2;

	@FindBy(xpath = "//span[normalize-space()='Delhi']")
	WebElement city;

	@FindBy(xpath = "//*[@id='name_feild']/input")
	WebElement fullName;

	@FindBy(xpath = "//input[@id='name5']")
	WebElement mobile;

	@FindBy(xpath = "//div[@id='btnHealthStep4']")
	WebElement continuebtn4;

	@FindBy(xpath = "//label[@for='ped_last']//div[@class='chkbox']")
	WebElement noneofthese;

	@FindBy(xpath = "//span[@class='slider round']")
	WebElement watsapp;

	@FindBy(xpath = "//button[@id='btnHealthStep5']")
	WebElement continuebtn5;

	@FindBy(xpath = "//*[@id='corp_no']")
	WebElement selectNo;

	@FindBy(xpath = "//span[normalize-space()='View plans']")
	WebElement viewPlans;

	@FindBy(xpath = "//div[@class='quotes_rvmp_card__content__plan_header']//span[1]")
	List<WebElement> policyName;

	@FindBy(xpath = "//div[@class='quotes_rvmp_card__content__bottom_buttons']/div[2]/button")
	List<WebElement> policyPrice;

	@FindBy(xpath = "//label[@data-id='daughter']")
	WebElement child;

	@FindBy(xpath = "//div[@id='errorHighlight']")
	WebElement txt;

	@FindBy(xpath = "//div[2]/section/div[2]/a")
	WebElement heart;

	@FindBy(xpath = "//h1[@class='anim firstStep']")
	WebElement heading;

	String path = System.getProperty("user.dir") + "/src/test/resources/Policy.xlsx";
	String actualheading = "Find top plans for you with up to ";

	public void getHealthInsurance() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		// clicking on health icon
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Insurance Products']")));
		Actions act = new Actions(driver);
		act.moveToElement(insuranceproducts).build().perform();

		healthinsurance.click();

	}

	public void setMember() {
		// finding list of members
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='memberSelection__block'])[3]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		self.click();
		js.executeScript("arguments[0].click();", continuebtn1);
		// continuebtn1.click();

	}

	public void setAge() {
		// selecting age
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='name_feild']/select")));
		Select menu = new Select(ageinput);
		menu.selectByValue("23");

		// clicking on continue button
		continuebtn2.click();

	}

	public void setCity() {
		// selecting country name
		city.click();

	}

	public void setDetails(String moNumber) {
		// entering full name
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='name_feild']/input")));
		fullName.sendKeys("Deepanshu");

		// entering mobile number
		mobile.sendKeys(moNumber);

		// clicking on continue button

		continuebtn4.click();

	}

	public void checkMedicalHistory() {
		// Selecting none of these option
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='ped_last']//div[@class='chkbox']")));
		noneofthese.click();
		// unchecking whatsapp updates
		// watsapp.click();
		// clicking on continue button
		// continuebtn5.click();

	}

	public void getInsuranceOption() {
		// selecting no
		// selectNo.click();
		// clicking on view plans
		// viewPlans.click();

	}

	public void displayHealthPlans() throws IOException {
//		excelUtils.fillGreenColor(path, "Sheet2", 0, 0);
//		excelUtils.fillBlueColor(path, "Sheet2", 0, 1);
		System.out.println("Health Policy names:");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < 5; i++) {

			try {
//				String pname = policyName.get(i).getText();
//				System.out.println("\n" + pname);
//				excelUtils.setCellData(path, "Sheet2", i + 1, 0, pname);
				String pprice = policyPrice.get(i).getText();
				System.out.println(pprice);
				excelUtils.setCellData(path, "Sheet2", i + 1, 0, pprice);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void getChild() {
		child.click();
	}

	public void captureText() {
		try {
			if (txt.isDisplayed()) {
				System.out.println("Error--------");
				System.out.println(txt.getText());
			}
		} catch (Exception e) {
			System.out.println("Please select parent also");
		}

	}

	public void clickheartlogo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/section/div[2]/a")));

		heart.click();
	}

	public void checkhealthpage() {
		String expectedheading = heading.getText();
		Assert.assertEquals(actualheading, expectedheading);

	}

}
