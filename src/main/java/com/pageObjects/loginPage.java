package com.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends BasePage {

	public loginPage(WebDriver driver) {
		super(driver);
	}
	
	
	By textEmail = By.id("i0116");
	By nextButton = By.id("idSIButton9");
	By textPassword = By.id("i0118");
	By signInButton = By.xpath("//input[@value='Sign in']");
	By checkBox = By.id("KmsiCheckboxField");
	By portalTitleName = By.xpath("//*[text()='be.cognizant']");
	
	
	public void setUsername(String email) {
		//driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
			driver.findElement(textEmail).sendKeys(email);
	}
	
	public void clickNext() {
			driver.findElement(nextButton).click();
	}

	public void setPassword(String password) {
			driver.findElement(textPassword).sendKeys(password);		
	}
	
	public void clickSignin() {
			driver.findElement(signInButton).click();
	}
	
	
	public void staySignedIn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
		driver.findElement(nextButton).click();
	}
	
	public String pageTittle() {
		//return(driver.getTitle());
		return (driver.findElement(portalTitleName).getText());
	}
	

}
