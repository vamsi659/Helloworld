package SeleniumPractise;

	import java.util.Iterator;
	import java.util.List;
	import java.util.Set;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

		public class ClickFacebookLink {

			public static void main(String[] args) throws InterruptedException {

				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.elekta.com/#bottom");// parent window
				driver.findElement(By.id("cookie-accept")).click();
				//String parentWindowId = driver.getWindowHandle();

				driver.findElement(By.xpath("//div[@id='content']//ul[@class='social']//img[@src='/img/facebook.svg']")).click();
				
				Set<String> handles1 = driver.getWindowHandles();
				Iterator<String> it = handles1.iterator();
				String parentWindowId = it.next();
				System.out.println("Parent window id : " + parentWindowId);
				String childWindowId = it.next();
				System.out.println("youtube Child window id : " + childWindowId);
				
				driver.switchTo().window(childWindowId);
				//driver.close();
				driver.switchTo().window(parentWindowId);
//				
			}
			}