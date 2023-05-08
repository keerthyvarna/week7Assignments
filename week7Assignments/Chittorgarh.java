package week7Assignments;

import java.time.Duration;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Chittorgarh {
	
    public static void main(String[] args)  {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'table-striped')]"));
        Actions act = new Actions(driver);
        act.moveToElement(table);
        List<WebElement> row = driver.findElements(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr"));
        int rsize = row.size(); 
        Set<String> set = new HashSet<String>();
		Set<String> dup = new HashSet<String>();
	    System.out.println("Security Name");
	    System.out.println("*************"); 
		  for(int i=1;i<=rsize;i++) { 
			   WebElement values = driver.findElement(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr["+i+"]/td[1]"));
		       String name = values.getText();
		       System.out.println(name);
		       set.add(name);
		       if(!set.add(name)) {
		    	   dup.add(name);
		       }
		  }
	   System.out.println();
	   System.out.println("Duplicate Security Names:");
	   System.out.println("*************************");
		  for (String Duplicates : dup) {
			  System.out.println(Duplicates);
			
		}
	   driver.close();
	}
    
}
		 

		 
		
			
	