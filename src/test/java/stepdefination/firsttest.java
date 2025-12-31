package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import hooks.Hooks;
import io.cucumber.java.en.*;
import utilities.DriverFactory;
import utilities.DriverLaunch;
import utilities.TestcasesUtilities;

public class firsttest extends DriverLaunch {
	TestcasesUtilities tc = new TestcasesUtilities();
	WebDriver driver = DriverFactory.getDriver();
	
	@Given("user navigates to the login page {string}")
    public void user_navigates_to_the_login_page(String url) {

        
        driver.get(url);
    }
	

	
	@When("user enters username {string}")
	public void user_enters_username(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    tc.putUsername(driver);
	}
	@When("user enters password {string}")
	public void user_enters_password(String string) { 
	    // Write code here that turns the phrase above into concrete actions
		 tc.putPassword(driver);
	}
	@When("user selects the user checkbox")
	public void user_selects_the_user_checkbox() {
	    // Write code here that turns the phrase above into concrete actions
	    tc.selectUserCheckbox(driver);
	}
	@When("user accepts the alert popup")
	public void user_accepts_the_alert_popup() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	   tc.acceptPopup(driver);
	}
	@When("user selects {string} from the role dropdown")
	public void user_selects_from_the_role_dropdown(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    tc.selectDropdown(driver);
	}
	@When("user selects the terms and conditions checkbox")
	public void user_selects_the_terms_and_conditions_checkbox() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("user clicks on the sign in button")
	public void user_clicks_on_the_sign_in_button() {
	    // Write code here that turns the phrase above into concrete actions
	   tc.clickSignin(driver);
	}
	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	   tc.loginSuccesfull(driver);
	}



	

}
