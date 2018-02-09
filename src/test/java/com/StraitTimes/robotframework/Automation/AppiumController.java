package com.StraitTimes.robotframework.Automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AppiumController {

	AppiumDriver<MobileElement> driver;
	StraitTimesMobilePages straitTimesPages;

    @RobotKeyword("Set Up")
	public void setUp() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "One Plus 5");

		caps.setCapability("udid", "3a5cf70");

		caps.setCapability("platformName", "Android");

		caps.setCapability("platformVersion", "8.0.0");

		caps.setCapability("appPackage", "com.buuuk.st");

		caps.setCapability("appActivity", "com.sph.straitstimes.views.activities.SplashActivity");



		// Instantiate Appium Driver

		try {

			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			straitTimesPages = new StraitTimesMobilePages(driver);

		} catch (MalformedURLException e) {

			System.out.println(e.getMessage());
			
		}

	}
    
    @RobotKeyword("I am in the app home screen")
	public void iAmInTheAppHomeScreen() {
    	
    	straitTimesPages.takeToHomeScreen();
    }
		
	@RobotKeyword("I login with valid credentials")
	@ArgumentNames({ "Email", "Password"})
	public void iLoginWithValidCredentials(String email, String password) {
		
		straitTimesPages.loginToApplication(email, password);
		
	}
    
	@RobotKeyword("I should be logged in successfully")
	@ArgumentNames({ "Email" })
	public void iShouldBeLoggedInSuccessfully(String email) {
		straitTimesPages.assertLogin(email);
	}
	
	@RobotKeyword("I tap the latest tab")
	public void iTapTheLatestTab() {
		straitTimesPages.navigateToLatest();
	}

	@RobotKeyword("I open the first article")
	public void iOpenTheFirstArticle() {
		straitTimesPages.openFirstArticle();
	}

	
	@RobotKeyword("I should see the first article")
	public void iShouldSeeTheFirstArticle() {
		straitTimesPages.assertFirstArticle();
	}
	
}
