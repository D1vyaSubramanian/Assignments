package week2.week2day2assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

	public static void main(String[] args) {
		/*Pseudo Code 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 2. Enter UserName and Password Using Id Locator
		 * 3. Click on Login Button using Class Locator
		 * 4. Click on CRM/SFA Link
		 * 5. Click on Leads Button
		 * 6. Click on create Lead Button
		 * 7. Enter CompanyName using id Locator
		 * 8. Enter FirstName using id Locator
		 * 9. Enter LastName using id Locator
		 * 10. Enter your mail-id
	     * 11.phone number 
		 * 12. Click on create Lead Button Using name Locator
		 */
		
		ChromeDriver driver= new ChromeDriver();
		
		//Open the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//Credentials
		driver.findElement(By.id("username")).sendKeys("DemoCsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Enter Personal Details
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Bosch");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("DIVYA");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("SUBRAMANIAN");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("divyas.us17@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("8012787044");
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
		driver.findElement(By.name("submitButton")).click();
		
		
	}

}
