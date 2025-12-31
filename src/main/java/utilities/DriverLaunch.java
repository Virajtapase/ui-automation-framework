package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverLaunch {

	public WebDriver driver;
	
	public WebDriver driverup() {
		 driver = new ChromeDriver();
		
		return driver; 
	}
}
