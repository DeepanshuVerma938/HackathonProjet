package com.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.factory.BaseClass;
import com.pageObjects.Locators;
import com.utils.excelUtils;

public class featuredNewsPage extends BasePage {
	public featuredNewsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="(//div[@class='ar_i_658c9e0a']//span[@id='CaptionElementView'])[1]")
	WebElement scrollNews;
	
	@FindBy(xpath = "//*[@data-automation-id='CanvasControl' and @id='4f7e87d5-f184-4501-8008-0ee4b0a38fcf']")
	WebElement newsSection;
	
	@FindBy(xpath = "//div[@role='listitem' and @class='e_a_37591358 q_a_37591358']")    
	List<WebElement> newsList;
	
	@FindBy(xpath = "//div[@class='z_a_91bed31b l_a_91bed31b']//a[@id='news_text_title']")    
	List<WebElement> toolTip;
	
	@FindBy(id="news_text_title")
	List<WebElement> newslink;
	
	@FindBy(id="title_text")
	WebElement newsTitle;
	
	@FindBy(xpath="//div[@class='ControlZone ControlZone--clean a_c_50a7110f'][2]")
	WebElement newsText;
	
	/*
	@FindBy(xpath = "//div[@id='89c5ffca-2ffb-4052-a723-e99c8c9a14ef']")
	WebElement apps;
	*/
	@FindBy(xpath="//div[@id='vpc_WebPart.QuickLinksWebPart.internal.89c5ffca-2ffb-4052-a723-e99c8c9a14ef']")
	WebElement apps; //appsblock on 8-2-2024
	
	//@FindBy(xpath = "//div[@id='89c5ffca-2ffb-4052-a723-e99c8c9a14ef']//span[@id='CaptionElementView']")
	@FindBy(xpath="//div[@id='vpc_WebPart.QuickLinksWebPart.internal.89c5ffca-2ffb-4052-a723-e99c8c9a14ef']//span[@id='CaptionElementView']")
	WebElement appsAndToolsTitle;
	
	String fileName=System.getProperty("user.dir")+"/src/test/resources/newsData.xlsx"; //storing the path of excel file in fileName
	
	Locators loc=new Locators(BaseClass.getDriver());
	
	public void checkNewsBlock() {
	try {
		//boolean news=driver.findElement(By.xpath("//*[@data-automation-id=\"CanvasControl\" and @id=\"4f7e87d5-f184-4501-8008-0ee4b0a38fcf\"]")).isDisplayed();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scrollNews = driver.findElement(By.xpath("(//div[@class='ar_i_658c9e0a']//span[@id='CaptionElementView'])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", scrollNews);
		
		boolean news=newsSection.isDisplayed();
		Assert.assertTrue(news);
	    System.out.println("NEWS BLOCK DISPLAYED ");
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void displayCount() {
		int newsCount=newsList.size();
		String sizeOfNews=Integer.toString(newsCount);
		System.out.println("\nNumber of featured news displayed on Be.cognizant homepage: "+newsCount);	
		try {
			excelUtils.setCellData(fileName,"Sheet1",1,0,sizeOfNews);
		}
		catch(Exception e){
			
		}

	}
	
	
	
	public void displayNewsHeading() {
		
		loc.Explicit("//div[@role='listitem' and @class='e_a_37591358 q_a_37591358']");
		System.out.println("\nNews Headings are:");
		for(int i=0;i<newsList.size();i++) {

			String headings=newsList.get(i).getText();
			System.out.println("News Heading-"+(i+1));
			System.out.println(headings);
			try {
				String fileName=System.getProperty("user.dir")+"/src/test/resources/newsData.xlsx"; //storing the path of excel file in fileName
				excelUtils.setCellData(fileName,"Sheet1",i+1,1,headings);
			}
			catch(Exception e){
				
			}

		}
		System.out.println();
	}
	
	public void verifyTooltip() {
		
	    for(int i=0;i<toolTip.size();i++)

	    {	    	
	    	String headline=toolTip.get(i).getText();
			String tooltip=toolTip.get(i).getAttribute("title");
	
	    	try {
	    	    Assert.assertEquals(headline,tooltip);
	    		System.out.println("News"+(i+1)+" Headline and Tooltip is matched");
	    	}
	    	catch(Exception e) {
	    		System.out.println("News"+(i+1)+" Headline and Tooltip is not matched");
	    	}
	    }
	    System.out.println();
		
	}
	
	
	public void getNewsInformation() throws IOException, InterruptedException {
		for(int i=0;i<newsList.size();i++) {
			 
			 newslink.get(i).click();
			 Thread.sleep(5000);
			 String AnewsTitle=newsTitle .getText();
			 String newsTooltip=newsTitle.getAttribute("title");
			 
			 
			 TakesScreenshot ts=(TakesScreenshot)driver;
	    	 File src=ts.getScreenshotAs(OutputType.FILE);
	         File trg=new File("C:\\Users\\2303771\\eclipse-workspace\\featuredNews_Project\\screenshots\\Screenshot["+(i+1)+"].png");
	         FileUtils.copyFile(src,trg);
	         
			// Shutterbug.shootPage(driver,Capture.FULL,true).save("C:\\Users\\2303771\\eclipse-workspace\\Sample\\Screenshots\\");
			 System.out.println("____________________________________________________________________________________________________");
				 if(AnewsTitle.equals(newsTooltip)){
			   			System.out.println("------Page Header Matches With ToolTip------");
			   	}
			   		else {
			   			System.out.println(" -----Page Header Not Matches With ToolTip-----");
			   	}
			 	System.out.println(AnewsTitle);
		        //System.out.println(driver.findElement(By.xpath("//div[@class='ControlZone ControlZone--clean a_c_50a7110f']")).getText());
		   		String info=newsText.getText();
				System.out.println(info);
		   		System.out.println("____________________________________________________________________________________________________");
			 
			 System.out.println("\n");
			 System.out.println("\n");
			
			 driver.findElement(By.xpath("//a[@name='be.cognizant']")).click();
		   	 driver.navigate().refresh();
		 }
	}

	public boolean checkApps() {
		boolean appsAndToolsBlock=false;
		try {
			appsAndToolsBlock=apps.isDisplayed();}
		catch(Exception e){
			
		}
		return appsAndToolsBlock;
	}


	public void displayAllApps() throws IOException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scroll = driver.findElement(By.xpath("//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong"));
        js.executeScript("arguments[0].scrollIntoView();", scroll);
        String appsHeading=appsAndToolsTitle.getText();
	    System.out.println(appsHeading); 
	    int row=1;
	    List<WebElement> appsList = driver.findElements(By.xpath("((//*[@class='ControlZone--control'])[8]//div[@id='QuicklinksItemTitle'])"));
		 for(WebElement appsTitles : appsList) {			 
			 String appsName=appsTitles .getAttribute("title");
			 System.out.println(appsName);
			 excelUtils.setCellData(fileName,"Sheet1",row,2,appsName);
		     row++;			
		 }
		 
		 /*
	    for(int i=7;i<=15;i++)
	    {
	    	WebElement appsTitles = driver.findElement(By.xpath("(//*[@id='QuicklinksItemTitle'])["+i+"]"));
	    	String appsName=appsTitles.getAttribute("title");
			System.out.println(appsName);
			try {
				String fileName=System.getProperty("user.dir")+"/src/test/resources/newsData.xlsx"; //storing the path of excel file in fileName
				excelUtils.setCellData(fileName,"Sheet1",row,2,appsName);
				row++;
			}
			catch(Exception e){
				
			}

	    }
		*/
		

	}
}


