package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverLaunch {

	public WebDriver driver;
	
	public WebDriver driverup() {
		ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");   // REQUIRED
        options.addArguments("--no-sandbox");     // REQUIRED
        options.addArguments("--disable-dev-shm-usage"); // REQUIRED
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        return driver;
		
	}
}
