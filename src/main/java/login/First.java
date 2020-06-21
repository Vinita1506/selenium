package login;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class First {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/* #For direct login# */
		/*
		 * driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("abc@gmail.com");
		 * driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("defgh@123");
		 * driver.findElement(By.xpath("//*[@id=\'u_0_b\']")).click();
		 */

		/* #For New users# */
		driver.findElement(ByName.name("firstname")).sendKeys("Kirti");
		driver.findElement(By.xpath("//*[@id=\'u_0_o\']")).sendKeys("Mahajan");
		driver.findElement(By.xpath("//*[@id=\'u_0_r\']")).sendKeys("7536982144");
		driver.findElement(By.xpath("//*[@id=\'u_0_w\']")).sendKeys("Success@12");

		/* # to select day# */
		WebElement day_drop = driver.findElement(By.id("day"));
		Select day = new Select(day_drop);
		day.selectByVisibleText("28");

		/* #For getting total values present in dropdown# */
		List<WebElement> values = day.getOptions();

		System.out.println("Total values are : " + values.size());

		/* # to select month# */
		WebElement month_drop = driver.findElement(By.id("month"));
		Select month = new Select(month_drop);
		month.selectByVisibleText("Aug");

		/* #For getting total values present in dropdown# */
		List<WebElement> values2 = month.getOptions();

		System.out.println("Total values are : " + values2.size());

		WebElement year_drop = driver.findElement(By.id("year"));
		Select year = new Select(year_drop);
		year.selectByVisibleText("1995");

		List<WebElement> values3 = year.getOptions();

		System.out.println("Total values are : " + values3.size());

		/* #To select checkbox and get total number of checkbox# */
		WebElement radio1 = driver.findElement(By.xpath("//*[@id=\'u_0_z\']/span[1]"));
		WebElement radio2 = driver.findElement(By.xpath("//*[@id=\'u_0_z\']/span[2]"));

		List<WebElement> checkboxes = driver.findElements(By.name("sex"));

		radio1.click();

		System.out.println("Total checkboxes are" + checkboxes.size());

		/* #to click sign up box# */
		driver.findElement(By.name("websubmit")).click();

		/* #To get links from particular section */
		WebElement block = driver.findElement(By.xpath(("//*[@id=\'pageFooterChildren\']")));
		List<WebElement> links = block.findElements(By.tagName("a"));
		System.out.println("----Printing Links----");

		System.out.println("Total links are" + links.size());

		for (WebElement link : links) {
			System.out.println(link.getText() + " --URL is-- " + link.getAttribute("href"));
		}

		/* # To get all the links present in webpage */
		List<WebElement> links1 = driver.findElements(By.tagName("a"));

		System.out.println("----Printing Links----");

		System.out.println("Total links are" + links1.size());
        
		/* # Handle Multiple Windows */
		for (WebElement link : links1) {
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			link.sendKeys(clickonlinkTab);

			Thread.sleep(1000);
			System.out.println(link.getText() + " --URL is-- " + link.getAttribute("href"));
		}

	}
}
