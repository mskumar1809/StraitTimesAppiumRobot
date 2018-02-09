package com.StraitTimes.robotframework.Automation;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class StraitTimesPages {
	
	

	WebDriver driver;
	
	String mainArticleLink = null;
	boolean flag = false;
	//HomePage object
	By loginlink = By.xpath("//*[@id=\"navbar\"]/div/div[2]/nav/div[2]/div/ul/li[1]/a");
			
	//LoginPage object
	By btn_signin = By.xpath("//*[contains(text(), 'Sign in!')]");

	//AfterLoginPage object
	By main_video = By.xpath("//*[@id='block-system-main']/div/div/div/div/div[2]/div/div/div/div[5]/div/div/div/div/a");
	
	By username = By.id("j_username");
	
	By password = By.id("j_password");
	
	
			
	public StraitTimesPages(WebDriver driver)

	{

		this.driver = driver;
	}

	public void navigateToLoginPage() {
		driver.findElement(loginlink).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}


	public void enterPassword(String pass) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(password).sendKeys(pass);
	}

	public void loginIntoTheApplication() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(btn_signin).click();
	}



	public void enterEmail(String email) {
		
		driver.findElement(username).sendKeys(email);
		
	}

	public void assertLogIn(String Email) {
		assertTrue(driver.findElement(loginlink).getText().contains(Email));
		
	}

	public void assertMediaForMainArticle() {
		
		assertTrue(driver.findElement(main_video).isDisplayed());
		mainArticleLink = driver.findElement(main_video).getAttribute("href");
		if (driver.findElement(main_video).isDisplayed()) {
			System.out.println("The main article has a picture/video");
			Reporter.log("The main article has a picture/video. \n", true);
			flag = true;
		} else {
			System.out.println("The main article does not have a picture/video");
			Reporter.log("The main article does not have a picture/video", true);
		}
		
	}

	public void mainArticleNavigation() {
		driver.findElement(main_video).click();
		
	}
	
	public void mainArticleNavigationVerification() {
		assertTrue(driver.getCurrentUrl().contains(mainArticleLink));
	}

	public void assertMediainMainArticle() {
		if (flag == true) {
			System.out.println(
					"The page has been navigated to the main article, and the picture/video is present in the article.");
			Reporter.log(
					"The page has been navigated to the main article, and the picture/video is present in the article. \n",
					true);
		} else {
			System.out.println(
					"The page has been navigated to the main article, and the picture/video is NOT present in the article.");
			Reporter.log(
					"The page has been navigated to the main article, and the picture/video is NOT present in the article.",
					true);
		}
		
		
	}

}
