package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestcasesUtilities {

	public void putUsername(WebDriver driver) {
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
	}

	public void putPassword(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("password")).sendKeys("learning");
	}

	public void selectUserCheckbox(WebDriver driver) {
		
		driver.findElement(By.xpath("//span[text()=' User']/following-sibling::span")).click();
		// TODO Auto-generated method stub
		
	}

	public void acceptPopup(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		driver.findElement(By.id("okayBtn")).click();;
	}

	public void selectDropdown(WebDriver driver) {
		WebElement dropdown = driver.findElement(By.xpath("//select[@data-style='btn-info']"));
		Select select = new Select(dropdown);
		select.selectByValue("stud");
		
		driver.findElement(By.id("terms")).click();
	}

	public void clickSignin(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("signInBtn")).click();
	}

	public void loginSuccesfull(WebDriver driver) {
		// TODO Auto-generated method stub
		String title = driver.getTitle();
		System.out.println(title);
	}
}
