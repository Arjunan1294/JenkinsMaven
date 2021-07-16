package com.pages;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.safari.SafariDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class DriverFactory {

		public WebDriver driver;
		public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
		
		public WebDriver init_driver(String browser)
		{
			System.out.println("Browser Value is "+browser);
			if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			}
			
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			return getDriver();
		}
		
		
		public static synchronized WebDriver getDriver() {
			return tlDriver.get();
		}
		
		
		
		
		
	}


