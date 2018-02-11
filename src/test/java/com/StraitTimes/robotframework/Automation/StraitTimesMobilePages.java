package com.StraitTimes.robotframework.Automation;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;

public class StraitTimesMobilePages {
	

	AppiumDriver driver;
	
	By drawerMenu = By.xpath("//*[@content-desc = 'Navigate up']");
	
	By loginButton = By.id("com.buuuk.st:id/tv_login");

	By btn_continue = By.id("com.buuuk.st:id/btn_ldap_login_continue");
	
	By username = By.id("com.buuuk.st:id/et_ldap_login_username");
	
	By password = By.id("com.buuuk.st:id/et_ldap_login_password");
	
	By latest = By.xpath("//android.widget.TextView[@text='LATEST']");
	
	
	public StraitTimesMobilePages(AppiumDriver driver)

	{

		this.driver = driver;
	}

	public void takeToHomeScreen() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("com.buuuk.st:id/btn_tnc_ok")).click();
		leftRightSwipe(60000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.buuuk.st:id/tv_skip_intro")).click();
		
	}
	
	public void leftRightSwipe(int timeduration) {
  	  // duration should be in milliseconds
  	  Dimension size = driver.manage().window().getSize();
  	  System.out.println(size);
  	  int startx = (int) (size.width * 0.90);
  	  int endx = (int) (size.width * 0.10);
  	  int starty = size.height / 2;
  	  System.out.println("Start swipe operation");
  	  driver.swipe(startx, starty, endx, starty, timeduration);

  	 }

	public void loginToApplication(String email, String password2) {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(drawerMenu).click();
		
			
				
				try {
					
					 {
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						driver.findElement(drawerMenu).click();
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						driver.findElement(loginButton).click();
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						driver.findElement(username).sendKeys(email);
						driver.findElement(password).sendKeys(password2);
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						driver.findElement(btn_continue).click();
					}
							
				} catch (IllegalMonitorStateException e ) {
					WebElement Ad = driver.findElement(By.id("com.buuuk.st:id/toolbar_app_logo"));
					if(Ad.isDisplayed()) {
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					}
					e.printStackTrace();
				}
					
			}
		

	public void assertLogin(String email) {
		
		String source;
		source = driver.getPageSource();
		assertTrue(source.contains(email));
		
	}

	public void navigateToLatest() {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(latest).click();
		
	}

	public void openFirstArticle() {
		
		List<WebElement> list=new ArrayList<WebElement>();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		list = driver.findElementsById("com.buuuk.st:id/layout_item");
		
		list.get(0).click();
		
	
	}

	public void assertFirstArticle() {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.findElement(latest).click();
		String text = driver.findElement(latest).getText();
		assertTrue(text.contains("LATEST"));
		
	}



}
