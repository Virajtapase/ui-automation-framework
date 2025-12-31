package utilities;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverLaunch {

	public WebDriver driver;
	
	public WebDriver driverup() throws Exception {
		/*ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");   // REQUIRED
        options.addArguments("--no-sandbox");     // REQUIRED
        options.addArguments("--disable-dev-shm-usage"); // REQUIRED
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        return driver;*/
		
		   String browserStackFlag = System.getProperty("browserstack");

	        if ("true".equalsIgnoreCase(browserStackFlag)) {
	            return getBrowserStackDriver();
	        }
	        else {
	            return getLocalChromeDriver();
	        
	        }
	}
	        
	     // ---------------- LOCAL DRIVER ----------------
	        private static WebDriver getLocalChromeDriver() {
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--start-maximized");

	            WebDriver driver = new ChromeDriver(options);
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            return driver;
	        }

	        // ---------------- BROWSERSTACK DRIVER ----------------
	        private static WebDriver getBrowserStackDriver() throws Exception {

	            String username = System.getenv("BROWSERSTACK_USERNAME");
	            String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

	            if (username == null || accessKey == null) {
	                throw new RuntimeException(
	                    "BrowserStack credentials not found in environment variables");
	            }

	            MutableCapabilities capabilities = new MutableCapabilities();

	            Map<String, Object> bstackOptions = new HashMap<>();
	            bstackOptions.put("os", "Windows");
	            bstackOptions.put("osVersion", "11");
	            bstackOptions.put("browserName", "Chrome");
	            bstackOptions.put("browserVersion", "latest");
	            bstackOptions.put("sessionName", "Login Test");
	            bstackOptions.put("buildName", "UI-Automation-BrowserStack");

	            capabilities.setCapability("bstack:options", bstackOptions);

	            WebDriver driver = new RemoteWebDriver(
	                    new URL("https://" + username + ":" + accessKey +
	                            "@hub.browserstack.com/wd/hub"),
	                    capabilities);

	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            return driver;
	        
		
	}
}
