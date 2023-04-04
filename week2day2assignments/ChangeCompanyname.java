package week2.week2day2assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangeCompanyname {

	public static void main(String[] args) {
		
		/*Psuedo code
		 	* 1	Launch the browser
			* 2	Enter the username
			* 3	Enter the password
			* 4	Click Login
			* 5	Click crm/sfa link
			* 6	Click Leads link
			* 7	Click on Create Lead
			* 8 Enter company name
			* 9 Enter first name
			* 10 Enter last name
			* 11 click on Create Lead button  
			* 12 Click Edit button 
			* 13 Change the company name
			* 14 Click Update
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
		
		//Edit Company Name
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Robert Bosch");

		//Update
	    WebElement update=driver.findElement(By.name("submitButton"));
	    update.click();
	    
	}

}
