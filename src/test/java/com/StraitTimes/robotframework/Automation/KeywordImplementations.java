package com.StraitTimes.robotframework.Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testng.Assert;

import com.StraitTimes.robotframework.Automation.StraitTimesPages;

@RobotKeywords

public class KeywordImplementations {
	static WebDriver driver;
	StraitTimesPages straitTimesPages;

	

	@RobotKeyword("Set Up")
	public void setUp(){
	 driver = new ChromeDriver();
	 straitTimesPages = new StraitTimesPages(driver);
	}
	
	@RobotKeyword("I am in the app home screen")
	@ArgumentNames({ "URL" })
	public void iAmInTheAppHomeScreen(String url) {
		driver.get(url);
		driver.get(url);
		maximizeBrowser();
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
		
	}
	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	
	@RobotKeyword("I navigate to login screen")
	public void INavigateToLoginScreen() {
		straitTimesPages.navigateToLoginPage();
	}
	
	@RobotKeyword("I Enter Email")
	@ArgumentNames({ "Email" })
	public void iEnterEmail(String email) {
		straitTimesPages.enterEmail(email);

	}

	@RobotKeyword("I Enter password")
	@ArgumentNames({ "PASSWORD" })
	public void iEnterPassword(String password) {
		straitTimesPages.enterPassword(password);

	}

	@RobotKeyword("I Login into the application")
	public void iLoginIntoTheApplication() {
		straitTimesPages.loginIntoTheApplication();
	}
	
	@RobotKeyword("I should be successfully logged in")
	@ArgumentNames({ "Email" })
	public void iShouldBeSuccessfullyLoggedIn(String Email) {
		straitTimesPages.assertLogIn(Email);
	}

	@RobotKeyword("I should see the main article with Media")
	public void iShouldSeeTheMainArticleWithMedia() {
		straitTimesPages.assertMediaForMainArticle();	
	}
	
	@RobotKeyword("I click the main article")
	public void iClickTheMainArticle() {
		straitTimesPages.mainArticleNavigation();	
	}
	
	@RobotKeyword("I should be navigated to main article")
	public void iShouldBeNavigatedToMainArticle() {
		straitTimesPages.mainArticleNavigationVerification();	
	}
	
	@RobotKeyword("I should see the media in the page")
	public void iShouldSeeTheMediaInThePage() {
		straitTimesPages.assertMediainMainArticle();
	}
	
	@RobotKeyword("Tear Down")
	public void tearDown() {
		driver.quit();
	}

}
