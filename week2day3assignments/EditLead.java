package week2.week2day3assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		
		/*http://leaftaps.com/opentaps/control/main
		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
*/
		
		ChromeDriver driver= new ChromeDriver();
		
		//Open the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Credentials
		driver.findElement(By.id("username")).sendKeys("DemoCsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Name and ID']")).click();

		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Divya");
		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("Subramanian");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//a[text()='11504']")).click();
		
		String Title=driver.getTitle();
		//System.out.println(Title);
		
		//Verify title
		if(Title.equals("View Lead | opentaps CRM"))
		{
			System.out.println("The title is verified and it is correct.");
		}else
		{
			System.out.println("The title is verified and it is not correct");
		}
		
		//Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement companyname=driver.findElement(By.id("updateLeadForm_companyName"));
		
		companyname.clear();
		companyname.sendKeys("Bosch");
		
		//Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
	/*	//Check updated name
		WebElement Update_CompanyName=driver.findElement(By.linkText("Bosch (11504)"));
		String update_company= Update_CompanyName.getText();
		
		System.out.println(update_company);
		*/
		
		Thread.sleep(1000);
		driver.close();
		
		
		
		
		
		
		
		

	}

}
