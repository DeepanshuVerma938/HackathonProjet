package com.Insurance.PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Insurance.utils.excelUtils;

public class TravelPage extends BasePage {
	public TravelPage(WebDriver driver) {
		super(driver);
	}

	String actualheading = "Let's secure your travel";

	@FindBy(xpath = "//div[7]//a[1]//div[1]//div[1]")
	WebElement travelIcon; // xpath for finding travel icon present on homepage

	@FindBy(xpath = "//h1[@class='pqHeading__title']")
	WebElement heading;

	@FindBy(xpath = "//input[@id='country']")
	WebElement findcountry;

	@FindBy(xpath = "//button[@class='travel_main_cta']")
	WebElement nextbutton;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[1]/div[1]/h6")
	WebElement startmonth;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[2]/div[1]/h6")
	WebElement endmonth;

	@FindBy(xpath = "//*[@id='prequote-wrapper']/div[2]/div/div[1]/div/div[1]/div/div/input")
	WebElement dateInput;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[1]/div/div/div/div/div/button")
	List<WebElement> startdate;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[2]/div[3]/div/div/div/div/button/span[1]")
	List<WebElement> enddate;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[2]/div[1]/button[2]")
	WebElement nextArrow;

	@FindBy(xpath = "//label[@for='traveller_2']")
	WebElement noOfPeople;

	@FindBy(xpath = "//div[contains(text(),'Select age of traveller 1')]")
	WebElement ageInput1;

	@FindBy(xpath = "//label[@for='22 years_undefined']")
	WebElement travellerage1;

	@FindBy(xpath = "//div[contains(text(),'Select age of traveller 2')]")
	WebElement ageinput2;

	@FindBy(xpath = "//label[@for='21 years_undefined']")
	WebElement travellerage2;

	@FindBy(xpath = "//*[@id='prequote-wrapper']/div[2]/div/div[2]/button")
	WebElement agenextbtn;

	@FindBy(xpath = "//input[@id='ped_no']")
	WebElement medicalHistory;

	@FindBy(xpath = "//input[@id='mobileNumber']")
	WebElement mobile;

	@FindBy(xpath = "//span[@class='slider round']")
	WebElement watsp;

	@FindBy(xpath = "//*[@id='prequote-wrapper']/div[2]/div/div[2]/div/button")
	WebElement viewPlans;

	@FindBy(xpath = "//label[@for='studentTrip']")
	WebElement studentPlan;

	@FindBy(xpath = "//input[@id='Traveller_1']")
	WebElement checkTraveller1;

	@FindBy(xpath = "//input[@id='Traveller_2']")
	WebElement checkTraveller2;

	@FindBy(xpath = "//select[@id='feet']")
	WebElement durationdrp;

	@FindBy(xpath = "//button[normalize-space()='Apply']")
	WebElement applybtn;

	@FindBy(xpath = "//p[@class='filter_name_heading']")
	WebElement sortBy;

	@FindBy(xpath = "//*[@id='root']/div/div[2]/aside/section[1]/details/ul/li/label")
	List<WebElement> sortFilter;

	@FindBy(xpath = "//div[@class='quotesCard__planName']/div/p[1]")
	List<WebElement> companyName;

	@FindBy(xpath = "//div[@class='quotesCard__planName']/div/p[2]")
	List<WebElement> planName;

	@FindBy(xpath = "//span[@class='premiumPlanPrice']")
	List<WebElement> planPrice;

	String fileName = System.getProperty("user.dir") + "/src/test/resources/Policy.xlsx";

	public void clickTravelIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]//a[1]//div[1]//div[1]")));
		travelIcon.click();
	}

	public void checkpage() {

		String expectedheading = heading.getText();
		Assert.assertEquals(actualheading, expectedheading);
	}

	public void selectcountry(String option) {
		WebElement countryinput = driver.findElement(By.xpath("//input[@id='country']"));
		countryinput.click();
		// String option = "Thailand";
		List<WebElement> el = driver.findElements(By.xpath("//div[@id='search-country']/ul/li"));
		int iListsize = el.size();
		System.out.println("Total no. of Countries: " + iListsize);
		for (int i = 0; i < iListsize; i++) {
			String cntry = el.get(i).getText();
			if (cntry.contains(option)) {
				el.get(i).click();
				System.out.println("clicked");
				break;
			}
		}
	}

	public void clickNextButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='travel_main_cta']")));
		nextbutton.click();

	}

	public void setDate() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[1]/div/div[1]/div/div/input")));

		dateInput.click();

		// System.out.println(startmonth.getText());

		if (startmonth.getText().contains("February")) {
			for (int i = 0; i < startdate.size(); i++) {
				if (startdate.get(i).getText().equals("29")) {
					startdate.get(i).click();
					break;
				}
			}
		}
		System.out.println(endmonth.getText());
		int fx = 0;
		while (fx != 1) {
			if (endmonth.getText().contains("March")) {
				fx = 1;
				for (int i = 0; i < enddate.size(); i++) {
					if (enddate.get(i).getText().equals("26")) {
						enddate.get(i).click();
						break;
					}
				}
			} else {
				nextArrow.click();
			}
		}
		WebElement nextbutton = driver.findElement(By.xpath("//button[@class='travel_main_cta']"));
		nextbutton.click();

	}

	public void setAge() {

		noOfPeople.click(); // selecting no 2
		// selecting traveller one age
		ageInput1.click();
		travellerage1.click();
		// selecting traveller second age
		ageinput2.click();
		travellerage2.click();
		// Next Button
		agenextbtn.click();

	}

	public void setOption() {
		medicalHistory.click();
		agenextbtn.click();

	}

	public void setmobileNumber(String mo) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mobileNumber']")));
		// String mo ="6396527359";
		mobile.sendKeys(mo);
		// uncheck Whatsapp Updates
		watsp.click();
		// click on view plans

		viewPlans.click();
	}

	public void applyFilter() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		studentPlan.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='modal-root']/div/div/span")));
		driver.findElement(By.xpath("//*[@id='modal-root']/div/div/span")).click();

		checkTraveller1.click();
		checkTraveller2.click();

		// selecting number of days
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='feet']")));
		Select menu = new Select(durationdrp);
		menu.selectByIndex(2);
		applybtn.click();

		// choosing sort value
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='filter_name_heading']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", sortBy);

		for (WebElement curr : sortFilter) {
			if (curr.getText().equals("Premium low to high")) {
				curr.click();
			}

		}

	}

	public void displayPolicies() throws IOException {

		System.out.println("\nAll Travel Policy are displayed below :");
//		excelUtils.fillGreenColor(fileName, "Sheet1", 0, 0);
//		excelUtils.fillBlueColor(fileName, "Sheet1", 0, 1);
//		excelUtils.fillGreenColor(fileName, "Sheet1", 0, 2);

		for (int i = 0; i < 3; i++) {

			try {
				String cmpny = companyName.get(i).getText();
				System.out.println("\n" + cmpny);
				excelUtils.setCellData(fileName, "Sheet1", i + 1, 0, cmpny);
				String pname = planName.get(i).getText();
				System.out.println(planName.get(i).getText());
				excelUtils.setCellData(fileName, "Sheet1", i + 1, 1, pname);
				String pprice = planPrice.get(i).getText();
				System.out.println(pprice);
				excelUtils.setCellData(fileName, "Sheet1", i + 1, 2, pprice);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		// storing values in excel Sheet

	}

}
