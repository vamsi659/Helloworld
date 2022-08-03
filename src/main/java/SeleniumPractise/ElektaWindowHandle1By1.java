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

		public class ElektaWindowHandle1By1 {
			
			static WebDriver driver;

			public static void main(String[] args) {

				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				
				driver.get("https://www.elekta.com/#bottom");// parent window
				driver.findElement(By.id("cookie-accept")).click();
				//String parentWindowId = driver.getWindowHandle();

				By facebookLink = By.xpath("//div[@id='content']//ul[@class='social']//img[@src='/img/facebook.svg']");
				doClick(facebookLink);
				WindowHandle1by1(facebookLink);
				
//				Set<String> handles1 = driver.getWindowHandles();
//				Iterator<String> it = handles1.iterator();
//				String parentWindowId = it.next();
//				System.out.println("Parent window id : " + parentWindowId);
//				String childWindowId = it.next();
//				System.out.println("youtube Child window id : " + childWindowId);
//				
//				driver.switchTo().window(childWindowId);
//				driver.close();
//				driver.switchTo().window(parentWindowId);
//				
//				//2
//				driver.findElement(By.xpath("//div[@id='content']//ul[@class='social']//img[@src='/img/linkedin.svg']")).click();
//				Set<String> handles2 = driver.getWindowHandles();
//				Iterator<String> it2 = handles2.iterator();
//				String parentWindowId2 = it2.next();
//				System.out.println("Parent window id : " + parentWindowId2);
//				String childWindowId2 = it2.next();
//				System.out.println("LinkedIn Child window id : " + childWindowId2);
//				
//				driver.switchTo().window(childWindowId2);
//				driver.close();
//				driver.switchTo().window(parentWindowId);
//				
//				
//				
//				//3
//				driver.findElement(By.xpath("//div[@id='content']//ul[@class='social']//img[@src='/img/twitter.svg']")).click();
//				Set<String> handles3 = driver.getWindowHandles();
//				Iterator<String> it3 = handles3.iterator();
//				String parentWindowId3 = it3.next();
//				System.out.println("Parent window id : " + parentWindowId3);
//				String childWindowId3 = it3.next();
//				System.out.println("FB Child window id : " + childWindowId3);
//				
//				driver.switchTo().window(childWindowId3);
//				//driver.findElement(By.xpath("//*[@id=\"facebook\"]/body/div[2]/div[1]/div/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div/div[1]/div/span/span")).click();
//				//Thread.sleep(3000);
//				driver.close();
//				driver.switchTo().window(parentWindowId);
//				
//				//4
//				driver.findElement(By.xpath("//div[@id='content']//ul[@class='social']//img[@src='/img/instagram.svg']")).click();
//				Set<String> handles4 = driver.getWindowHandles();
//				Iterator<String> it4 = handles4.iterator();
//				String parentWindowId4 = it4.next();
//				System.out.println("Parent window id : " + parentWindowId4);
//				String childWindowId4 = it4.next();
//				System.out.println("Twitter Child window id : " + childWindowId4);
//				
//				driver.switchTo().window(childWindowId4);
//				driver.close();
//				driver.switchTo().window(parentWindowId);
				
			}
			
			public static WebElement getElement(By locator) {
				return driver.findElement(locator);
			}
			public static void doClick(By locator) {
				getElement(locator).click();
			}
			
				public static void WindowHandle1by1(By locator) {
//					Select select = new Select(getElement(locator));
//					List<WebElement> optionsList = select.getOptions();
//	
//					for (WebElement e : optionsList) {
//						String text = e.getText();
//						if (text.contains(value)) {
//							e.click();
//							break;
							
							Set<String> handles = driver.getWindowHandles();
							Iterator<String> it = handles.iterator();
							String parentWindowId = it.next();
							System.out.println("Parent window id : " + parentWindowId);
							String childWindowId = it.next();
							System.out.println("Twitter Child window id : " + childWindowId);
							
							driver.switchTo().window(childWindowId);
							//driver.close();
							driver.switchTo().window(parentWindowId);
							
						}

					////*[@id="footer"]/div/ul/li[1]/a/img
				
		
				}
		