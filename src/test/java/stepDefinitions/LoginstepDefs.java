package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.pages.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginstepDefs {
   String Title1 = null;
   private Properties prop;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
     DriverFactory df = new DriverFactory();
	
	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Trying to open site");
		df.init_driver("Chrome");
		
		DriverFactory.getDriver().get("https://www.cybage.com/");
	
 Title1 =  loginPage.gettheTitle();
	 System.out.println("Titlle is "+Title1);
	}

	
	    
	
}

