package week3.week3day4assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Redbus {

		public static void main(String[] args) throws InterruptedException {
			
			
/*Psuedo Code
 
	1) Launch Chrome and add  implicitlyWait
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	02) Load https://www.redbus.in/
	03) Type "Chennai" in the FROM text box
	04) Click the first option from the pop up box
	05) Type "Bangalore" in the TO text box
	06) Click the first option from the pop up box
	07) Select tomorrow's date in the Date field
	08) Click Search Buses
	09) Print the number of buses shown as results (107 Buses found) (use .getText())
	10) Choose SLEEPER in the left menu 
	11) Print the name of the second resulting bus (use .getText())
	12) Get the Title of the page(use .getTitle())

*/
			ChromeDriver driver= new ChromeDriver();
			
			//Open the url
			driver.get("https://www.redbus.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			//FROM
			driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@data-no='1']")).click();
			
			//To
			driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@data-no='1']")).click();
			
			//Date
			driver.findElement(By.xpath("//div[@class='fl search-box date-box gtm-onwardCalendar']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//td[@class='wd day'])[1]")).click();
			
			//Search
			driver.findElement(By.xpath("//button[@id='search_btn']")).click();
			Thread.sleep(5000);
			
			//print found buses
			String text = driver.findElement(By.xpath("//div[@class='sort-sec clearfix onward ']//span")).getText();
			System.out.println(text);
			
			//Sleeper (USING JAVA CLICK)
			WebElement element2 = driver.findElement(By.xpath("//input[@id='bt_SLEEPER']"));
			driver.executeScript("arguments[0].click()", element2);
			Thread.sleep(2000);
			
			//Printing Bus Details
			WebElement element = driver.findElement(By.xpath("(//li[@class='row-sec clearfix'])[2]//div[@class='column-two p-right-10 w-30 fl']"));
			
			String text2 = element.getText();
			System.out.println(text2);
			
			
			//Title
			String title = driver.getTitle();
			System.out.println("\n"+title);
			
			//close
			Thread.sleep(5000);
			driver.close();
			
		}
}
