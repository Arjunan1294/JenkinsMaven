package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	private By careers = By.xpath("//a[contains(@href,'careers')][1]");
	
	
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String gettheTitle() {
		//summa
		return driver.getTitle();
	}
}
