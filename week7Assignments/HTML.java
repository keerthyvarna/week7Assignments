package week7Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class HTML {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement table = driver.findElement(By.xpath("//table[@class='attributes-list']"));
		Actions act = new Actions(driver);
		act.scrollToElement(table);
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr"));
        int rows = row.size();
        System.out.println("Number of rows: "+rows);
        List<WebElement> col = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr[1]/th"));
	    int cols = col.size();
	    System.out.println("Number of columns: "+cols);
	    driver.close();
	}

}
