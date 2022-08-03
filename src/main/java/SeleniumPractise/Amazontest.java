package SeleniumPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazontest {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.amazon.co.uk/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.co.uk%2Fref%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=gbflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("vamsi_659@yahoo.com");

		driver.findElement(By.id("continue")).click();

		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("");
		driver.findElement(By.id("signInSubmit")).click();

		By errorMesg = By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div");

		String actErrorMesg = doGetElementText(errorMesg);
		if (actErrorMesg.contains("Enter your password")) {
			System.out.println("correct error mesg");
		} else {
			System.out.println("incorrect error mesg");
		} 
	//	System.out.println("Logged into Amazon");
		

	}

	public static String doGetElementText(By locator) {
		return getElement(locator).getText();
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
