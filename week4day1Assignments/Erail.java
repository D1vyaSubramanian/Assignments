package week4.week4day1Assignments;

import java.time.Duration;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Erail {

	public static void main(String[] args) throws InterruptedException {
		 
		/*Psuedo code
		 classroom:1
			Steps:
			1. Navigate to https://erail.in/
			2. Clear the text in source and enter "ms" and tab or enter(keys.enter or tab )
			Hint : sendKeys(" ms",Keys.Enter)
			
			3. Clear the text in destination and enter "co" and tab or enter
			4. Uncheck sort on date
			5. Store all the train names in a list		
			6.print train names
*/
		
			ChromeDriver driver= new ChromeDriver();
		
			//Open the url
			driver.get("https://erail.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			String from="ms";
			String to="co";
			
			//Give details
			WebElement src = driver.findElement(By.id("txtStationFrom"));
			src.clear();
			src.sendKeys(from);
			src.sendKeys(Keys.TAB);
						
			WebElement dest = driver.findElement(By.id("txtStationTo"));
			dest.clear();
			dest.sendKeys(to);
			dest.sendKeys(Keys.ENTER);
			
			driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
			Thread.sleep(2000);
			java.util.List<WebElement> list= driver.findElements(By.xpath("//div[@id='divTrainsList']/table[1]/tbody/tr")); 
			int size1= list.size();
			System.out.println(size1);
			
			//Print names
			System.out.println("\nAvailable Train Names");
			for (int i = 2; i <= size1; i++) {
				String Train_name=driver.findElement(By.xpath("//div[@id='divTrainsList']/table[1]/tbody/tr["+i+"]/td[2]")).getText();
				System.out.println(Train_name);
				}
			
			driver.close();
			
		}

}
