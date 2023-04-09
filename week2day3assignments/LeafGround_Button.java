package week2.week2day3assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGround_Button {

	public static void main(String[] args) {
		
		/* Psuedo code 
		Button
		======
		https://www.leafground.com/button.xhtml
		1. Click and Confirm title
		2. Confirm if the button is disabled
		3. Find the position of the Submit button

		

*/
		
		ChromeDriver driver= new ChromeDriver();
		
		//BUTTON
		
		//Open the url
				driver.get("https://www.leafground.com/button.xhtml");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
						
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c' and text()='Click']")).click();
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.navigate().back();
		boolean button_enabled=driver.findElement(By.xpath("//button[contains(@class,'disabled')]")).isEnabled();
		if(button_enabled) {
			System.out.println("The Button is not Disabled");
		}else {
			System.out.println("The Button is Enabled");
		}
		
		
		Point Location=driver.findElement(By.xpath("(//span[contains(@class,'ui-button-icon')])[1]")).getLocation();
		System.out.println("The location of the Submit Button is\t"+Location);
		
		//DROPDOWN
		
		//Open the url
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		

	}

}
