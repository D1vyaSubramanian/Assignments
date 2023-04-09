package week2.week2day3assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		
		/*http://leaftaps.com/opentaps/control/main
		 
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Email
		9	Enter Email
		10	Click find leads button
		11	Capture name of First Resulting lead
		12	Click First Resulting lead
		13	Click Duplicate Lead
		14	Verify the title as 'Duplicate Lead'
		15	Click Create Lead
		16	Confirm the duplicated lead name is same as captured name
		17	Close the browser (Do not log out)
		
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
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("divyas.us17@gmail.com");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		WebElement LeadID_1=driver.findElement(By.xpath("(//div[contains(@class,'firstName')])[2]//a"));
		String LeadName= LeadID_1.getText();
		LeadID_1.click();
		
		Thread.sleep(1000);
		
		
		//Duplicate
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		
		//Verify title
		String Title=driver.getTitle();
		System.out.println(Title);
		
		if(Title.contains("Duplicate Lead"))
		{
			System.out.println("The title is verified and it is correct.");
		}else
		{
			System.out.println("The title is verified and it is not correct");
		}
		
		
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		
		//Finding Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("divyas.us17@gmail.com");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		
		
		//Checking Duplicate function		
		
		WebElement LeadID_2=driver.findElement(By.xpath("(//div[contains(@class,'firstName')])[3]//a"));
		String Lead_DuplicateName= LeadID_2.getText();
		
		System.out.println(LeadName);
		System.out.println(Lead_DuplicateName);
		
		if(LeadName.equals(Lead_DuplicateName))
		{
			System.out.println("The Duplicate function works correctly");
		}else
		{
			System.out.println("There is some error in Duplicate");
		}
		
		driver.close();
		
	}

}
