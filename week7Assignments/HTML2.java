package week7Assignments;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTML2 {
  public static void main(String[] args) {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver();
	driver.get(" https://html.com/tags/table/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//WebElement table= driver.findElement(By.xpath("//div[@class='render']/table"));
	List<WebElement> elements = driver.findElements(By.xpath("(//table)[1]/tbody/tr"));
	int rowSize = elements.size();
	//System.out.println("Number of rows are :"+rowSize);
	List<WebElement> elements2 = driver.findElements(By.xpath("(//table)[1]/tbody/tr[1]/td"));
	int columnSize = elements2.size();
	//System.out.println("Number of columns are :"+columnSize);
	
	String lib1="Market Share";
	String lib2="Absolute Usage";
	System.out.println(lib1);
	System.out.println("***********");
	
	for(int i=1;i<=rowSize;i++) {
		WebElement elm1 = driver.findElement(By.xpath("(//table)[1]/tbody/tr["+i+"]/td[1]"));
		String Library = elm1.getText();
		//System.out.println(str1);
		
		if(Library.contains(lib1)) {
			
			for(int j=2;j<=columnSize;j++) {
				WebElement th = driver.findElement(By.xpath("(//table)[1]/thead/tr/th["+j+"]"));
				WebElement td = driver.findElement(By.xpath("(//table)[1]/tbody/tr["+i+"]/td["+j+"]"));
				String Title = th.getText();
				String Data= td.getText();
				System.out.println(Title+":"+Data);
				}
	 System.out.println();
	 System.out.println(lib2);
	 System.out.println("**************");
		}else if(Library.contains(lib2)) {
			for(int j=2;j<=columnSize;j++) {
				WebElement th = driver.findElement(By.xpath("(//table)[1]/thead/tr/th["+j+"]"));
				WebElement td = driver.findElement(By.xpath("(//table)[1]/tbody/tr["+i+"]/td["+j+"]"));
				String Title = th.getText();
				String Data= td.getText();
				System.out.println(Title+":"+Data);
			}
		}
	}
	driver.close();
  }
}
		
	
	
  


