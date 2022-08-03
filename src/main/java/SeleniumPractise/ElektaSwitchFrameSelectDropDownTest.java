package SeleniumPractise;

	import java.util.ArrayList;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class ElektaSwitchFrameSelectDropDownTest {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			driver.get("https://www.elekta.com/");
			driver.findElement(By.id("cookie-accept")).click();

//				By Contactpopper = By.xpath("/html/body/div[4]");
//				clickOnElementFromSection(Contactpopper, "Contact and Support");
			driver.findElement(By.xpath("/html/body/div[4]")).click();

			By Job_function = By.id("jobFunction");
			By country = By.id("form-popup-page-Country");
			By Product_interest = By.id("form-popup-page-Product_Group_Form");
			By Purpose = By.id("form-popup-page-Purpose");

			selectValueFromSelectDropDown(Job_function, "CTO");
			selectValueFromSelectDropDown(country, "India");
			selectValueFromSelectDropDown(Product_interest, "Oncology / Delivery");
			selectValueFromSelectDropDown(Purpose, "Need a quote");

			printSelectDropDownValues(Job_function);
			printSelectDropDownValues(country);
			printSelectDropDownValues(Product_interest);
			printSelectDropDownValues(Purpose);

			List<String> countryList = getSelectDropDownValuesList(country);
			if (countryList.contains("India"))
				System.out.println("PASS");
			if (countryList.contains("Brazil"))
				System.out.println("PASS");
			if (countryList.contains("Angola"))
				System.out.println("PASS");

		}

		public static WebElement getElement(By locator) {
			return driver.findElement(locator);
		}

		public static void clickOnElementFromSection(By locator, String value) {
			List<WebElement> eleList = driver.findElements(locator);

			// System.out.println(eleList.size());

		}

		public static void printSelectDropDownValues(By locator) {
			Select select = new Select(getElement(locator));
			List<WebElement> optionsList = select.getOptions();
			System.out.println(optionsList.size());

			for (WebElement e : optionsList) {
				String text = e.getText();
				System.out.println("================" + text + "==============");

			}
		}

		public static List<String> getSelectDropDownValuesList(By locator) {
			List<String> valuesList = new ArrayList<String>();
			Select select = new Select(getElement(locator));
			List<WebElement> optionsList = select.getOptions();

			for (WebElement e : optionsList) {
				String text = e.getText();
				valuesList.add(text);
			}
			return valuesList;
		}

		public static void selectValueFromSelectDropDown(By locator, String value) {
			Select select = new Select(getElement(locator));
			List<WebElement> optionsList = select.getOptions();

			for (WebElement e : optionsList) {
				String text = e.getText();
				if (text.contains(value)) {
					e.click();
					break;
				}
			}
		}

	}
