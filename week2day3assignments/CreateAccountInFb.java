package week2.week2day3assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountInFb {

	public static void main(String[] args) throws InterruptedException {
		
		//Psuedo code
		// Step 2: Launch the chromebrowser
		// Step 3: Load the URL https://en-gb.facebook.com/
		// Step 4: Maximise the window
		// Step 5: Add implicit wait
		// Step 6: Click on Create New Account button
		// Step 7: Enter the first name
		// Step 8: Enter the last name
		// Step 9: Enter the mobile number
		// Step 10: Enterthe password
		// Step 11: Handle all the three drop downs
		// Step 12: Select the radio button "Female" 
		//          ( A normal click will do for this step)
		
		
		ChromeDriver driver= new ChromeDriver();
		
		//Open the url
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
		//Create New Account
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		//Give Information
		driver.findElement(By.name("firstname")).sendKeys("Enid");
		driver.findElement(By.name("lastname")).sendKeys("Blyton");
		driver.findElement(By.xpath("//input[contains(@name,'email__')]")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("@Enid4kids");
		
		//Birthday Dropdowns
		Select Date= new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		Date.selectByValue("11");
		Select Month= new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		Month.selectByValue("8");
		Select Year= new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		Year.selectByValue("1968");
		
		//Select Gender
		driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
		
		Thread.sleep(8000);
		driver.close();
		
		
		

	}

}
