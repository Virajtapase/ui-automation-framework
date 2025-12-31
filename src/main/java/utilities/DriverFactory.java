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

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initDriver() throws Exception {

        String browserStackFlag = System.getProperty("browserstack");

        if ("true".equalsIgnoreCase(browserStackFlag)) {
            driver = getBrowserStackDriver();
        } else {
            driver = getLocalChromeDriver();
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // ---------- LOCAL ----------
    private static WebDriver getLocalChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver localDriver = new ChromeDriver(options);
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return localDriver;
    }

    // ---------- BROWSERSTACK ----------
    private static WebDriver getBrowserStackDriver() throws Exception {

        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

        if (username == null || accessKey == null) {
            throw new RuntimeException("BrowserStack credentials missing");
        }

        MutableCapabilities caps = new MutableCapabilities();

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "11");
        bstackOptions.put("browserName", "Chrome");
        bstackOptions.put("browserVersion", "latest");
        bstackOptions.put("sessionName", "Login Test");
        bstackOptions.put("buildName", "UI-Automation");

        caps.setCapability("bstack:options", bstackOptions);

        WebDriver remoteDriver = new RemoteWebDriver(
                new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"),
                caps);

        remoteDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return remoteDriver;
    }
}
