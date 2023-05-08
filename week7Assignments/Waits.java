package week7Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/waits.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    driver.findElement(By.xpath("//span[text()='Click']")).click();
	    WebElement vis = driver.findElement(By.xpath("//span[text()='I am here']"));
	    wait.until(ExpectedConditions.visibilityOf(vis));
	    String text = vis.getText();
	    System.out.println(text);
	    driver.findElement(By.xpath("(//span[text()='Click'])[2]")).click();
	    WebElement invis = driver.findElement(By.xpath("//span[text()='I am about to hide']"));
	    wait.until(ExpectedConditions.invisibilityOf(invis));
	    System.out.println("message hidden");
	    driver.findElement(By.xpath("//span[text()='Click First Button']")).click();
	    WebElement click = driver.findElement(By.xpath("//span[text()='Click Second']"));
	    wait.until(ExpectedConditions.elementToBeClickable(click));
	 //   click.click();
	    System.out.println("Clicked Second");
	    driver.findElement(By.xpath("(//span[text()='Click'])[3]")).click();
	   // WebElement pre = driver.findElement(By.xpath("//span[text()='I am going to change!']"));
	    WebElement post = driver.findElement(By.xpath("//span[text()='Did you notice?']")); 
	    wait.until(ExpectedConditions.elementSelectionStateToBe(post, false));
	    System.out.println(post.getText());
	    driver.close();
	    
	}

}
