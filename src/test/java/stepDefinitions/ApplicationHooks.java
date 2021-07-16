package stepDefinitions;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.pages.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver  driver;
	private ConfigReader congigReader;
	Properties prop;
	
	
	@Before(value = "@Skip", order = 0)
	public void skip_Scenario(Scenario scenario) {
		System.out.println("Skipped Scrnario is: "+scenario.getName());
		Assume.assumeTrue(false);
	}
	
	
	@Before(order=1)
	public void getProperty() {
		congigReader = new ConfigReader();
		prop = congigReader.init_prop();
	}
	
	@Before(order=2)
	public void launchBrowser() {
	String browserName = prop.getProperty("browser");
	driverFactory = new DriverFactory();
	driver = driverFactory.init_driver(browserName);	
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void teatDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//Take Screenshot
			String ScreenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", ScreenshotName);
		}
	}
	
}
