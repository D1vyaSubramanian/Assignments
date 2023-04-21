package week4.week4day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) {
		
		/*
		 * //Pseudo Code
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 2. Enter UserName and Password Using Id Locator
		 * 3. Click on Login Button using Class Locator
		 * 4. Click on CRM/SFA Link
		 * 5. Click on contacts Button
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 7. Click on Widget of From Contact
		 * 8. Click on First Resulting Contact
		 * 9. Click on Widget of To Contact
		 * 10. Click on Second Resulting Contact
		 * 11. Click on Merge button using Xpath Locator
		 * 12. Accept the Alert
		 * 13. Verify the title of the page
		 */
		
		
		//Pre-Condition
		ChromeDriver driver= new ChromeDriver();
	
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']/parent::div")).click();
		
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//7. Click on Widget of From Contact
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
		
		//8. Click on First Resulting Contact
			
			//Window Handles
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> window_Handles= new ArrayList<String>(windowHandles);
				driver.switchTo().window(window_Handles.get(1));
		driver.findElement(By.xpath("(//td[contains(@class,'partyId') and @tabindex='0']//a)[1]")).click();
				driver.switchTo().window(window_Handles.get(0));
		
		//9. Click on Widget of To Contact
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		
		//10. Click on Second Resulting Contact
		
				//Window Handles
				Set<String> windowHandles1 = driver.getWindowHandles();
				List<String> window_Handles1= new ArrayList<String>(windowHandles1);
				driver.switchTo().window(window_Handles1.get(1));
		driver.findElement(By.xpath("(//td[contains(@class,'partyId') and @tabindex='0']//a)[2]")).click();
				driver.switchTo().window(window_Handles1.get(0));
		
		//11. Click on Merge button using Xpath Locator
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
				
		//12. Accept the Alert
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
		
		//13. Verify the title of the page
		String title = driver.getTitle();
		if(title.contains("Contact")) {
			System.out.println("The title is verified and is correct");
		}else {
			System.out.println("The title is incorrect");
		}
			
		
		//Post-Condition
		driver.close();
		
		
		
		
		
		
		

	}

}
