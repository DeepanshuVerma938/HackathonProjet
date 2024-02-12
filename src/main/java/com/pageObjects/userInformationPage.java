package com.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userInformationPage extends BasePage {
	
	public userInformationPage(WebDriver driver) {
		super(driver);
	}
	
	By accountIcon = By.xpath("//*[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']");
	By accountUsername = By.id("mectrl_currentAccount_primary");
	By accountUserEmail = By.id("mectrl_currentAccount_secondary");
	By settingIcon = By.xpath("//div[@class=\"o365cs-base\"]/span");
	//By portalTitleName = By.xpath("//*[text()='be.cognizant']");
	
	public void clickAccountIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(settingIcon));
		driver.findElement(accountIcon).click();
	}
	/*
	public String pageTittle() {
		//return(driver.getTitle());
		return (driver.findElement(portalTitleName).getText());
	}
	*/
	
    public String getAccountUsername() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		return(driver.findElement(accountUsername).getText());
	}
    
    public String getAccountUserEmail() {
    	//driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		return(driver.findElement(accountUserEmail ).getText());
	}
    

}
